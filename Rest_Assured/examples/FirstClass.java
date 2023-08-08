package examples;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class FirstClass {
    // Base URI
    String baseURI ="https://petstore.swagger.io/v2/pet";

    @Test

    public void getRequestWithQueryParam() throws MalformedURLException {
        // Send get request
        Response response =
                given().headers("Content-Type","application/json").queryParam("status","sold").


        when().get(baseURI + "/findByStatus");

        //Response body
        System.out.println(response.getBody().asString());
       // System.out.println(response.getBody().asPrettyString());


        // Response header
        //System.out.println(response.getHeaders().asList());
       // System.out.println(response.getHeader("Date"));

        //Extract individual properties
       String petStatus = response.then().extract().path("[0].status");
       System.out.println("Status of pet 1 is : " +petStatus);


       // Assert.assertEquals("petStatus","alive");

        //RestAssured Assertion

        URL petSchema = new URL("https://petstore.swagger.io/v2/swagger.json");
        response.then().body(matchesJsonSchema(petSchema));
        response.then().statusCode(200);
        response.then().body("[0].status",equalTo("sold"));
        response.then().time(lessThanOrEqualTo(2000L));

    }

    @Test

    public void getRequestWithPathParam()
    {
        //Send GET Request
        given().headers("Content-Type","application/json").pathParam("petId",77232).
                when().get(baseURI + "/{petId}").then().statusCode(200).body("name",equalTo("Riley"));

    }


}
