package liveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
// create the headers Map

    Map<String, String> headers = new HashMap<>();

    // Create the Pact
    @Pact(consumer="userConsumer", provider = "userProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        //Set the headers
        headers.put("Content-Type", "application/json");

        //Set the body

        DslPart requestResponseBody = new PactDslJsonBody()
                .numberType("id",124)
                .stringType("firstName", "Alka")
                .stringType("lastName","Yadav")
                .stringType("email","alka@example.com");

        //Write the Contract
        return builder.given("request to create a user")
            .uponReceiving("request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(requestResponseBody)
            .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();

    }
    @Test()
    @PactTestFor(providerName = "userProvider", port = "8282")
    public void postRequest()
    {
        Map<String, Object>  reqBody= new HashMap<>();
        reqBody.put("id", 124);
        reqBody.put("firstName", "Alka");
        reqBody.put("lastName","Yadav");
        reqBody.put("email","alka@example.com");

        //Send Post request
        given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody)
                .when().post().
                then().statusCode(201).log().all();


    }


}
