package com.ministryoftesting;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginApiTest {

    @Test
    public void testCheckLoginReturnsPositiveResult(){
        // Arrange
        AuthPayload authPayload = new AuthPayload("admin@test.com", "password123");

        // Act
        Response response = given()
                .body(authPayload)
                .contentType("application/json")
                .post("http://localhost:8080/v1/auth/login");

        // Assert
        assertEquals(200, response.getStatusCode());
    }

}
