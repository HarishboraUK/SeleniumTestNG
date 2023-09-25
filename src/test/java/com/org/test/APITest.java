package com.org.test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class APITest {
	
    private static String correctRequestBody = "{\n" +
            "  \"email\": \"test@gmail.com\",\n" +
            "  \"password\": \"test\",\n}";
    
    private static String incorrectRequestBody = "{\n" +
            "  \"email\": \"test@gmail.com\",\n}";

	
	@BeforeMethod
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in";
    }
	
    
	@Test
	  public static void verifyPostJsonPayloadForCorrectData() {
		 Response response = given()
	                .body(correctRequestBody)
	                .when()
	                .post("/api/create")
	                .then()
	                .extract().response();

		 assertEquals(response.statusCode(), 201);
		 assertTrue(response.getBody().asString().contains("id"));
		 assertTrue(response.getBody().asString().contains("createdAt"));
    }
	
	@Test
	  public static void verifyPostJsonPayloadForInCorrectData() {
		 Response response = given()
	                .body(incorrectRequestBody)
	                .when()
	                .post("/api/login")
	                .then()
	                .extract().response();
		 
		 assertEquals(response.statusCode(), 400);
		 assertTrue(response.getBody().asString().contains("error"));
		 assertTrue(response.getBody().asString().contains("Missing email or username"));
  }

}
