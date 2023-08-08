package examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.matcher.DetailedCookieMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.*;
import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
    //Specification

    RequestSpecification requestSpec;

    ResponseSpecification responseSpec;

    int PetId;

    // Post Request

    @BeforeClass
    public void setUp() {
        // Create the request Specification
        requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json").
                setBaseUri("https://petstore.swagger.io/v2/pet").build();

        //Create the response Specification
        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).expectResponseTime(lessThanOrEqualTo(3000L)).
                expectBody("status",equalTo("alive")).build();

    }

    @Test(priority = 1)
    public void postRequestTest()
    {
        //Request Body
        Map<String , Object> reqBody = new HashMap<>();
        reqBody.put("id",77232);
        reqBody.put("name","Riley");
        reqBody.put("status","alive");

        //Send post request
        Response response = given().spec(requestSpec).body(reqBody).when().post();

        //Extract the id from response
        PetId = response.then().extract().path("id");

        //Assertions
        response.then().spec(responseSpec);

    }
    @Test(priority = 2)
    public void getRequestTest()
    {
        //Sent GET Request
        given().spec(requestSpec).pathParam("PetId",PetId).
        when().get("{PetId}").
                then().spec(responseSpec).body("name",equalTo("Riley"));
    }

    @Test(priority = 3)
    public void deleteRequestTest()
    {
        //Send Delete request
        given().spec(requestSpec).pathParam("PetId",PetId).
                when().delete("{PetId}").
                then().statusCode(200).body("message",equalTo("" + PetId));
    }
}