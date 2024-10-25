package br.com.arthur.petstore;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUserByUsername extends BaseTest {

    // 1. Lista o usuário através do username

    private static final String USER_ENDPOINT = "/user/{username}";

    @Test
    public void GetUserByUsernameSuccess() {

        String userName = "user1";

        // Given
        given()
            .pathParam("username", userName)
            // When
            .when()
                .get(USER_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_OK)        // STATUS CODE 200
                .body("username", equalTo(userName));
    }

    // 2. Lista o usuário através do username ( NOT FOUND )

    @Test
    public void GetUserByUsernameNotFound() {

        String userName = "teste";

        // Given
        given()
            .pathParam("username", userName)
            // When
            .when()
                .get(USER_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)        // STATUS CODE 404
                .body("code", equalTo(1))
                .body("message", equalTo("User not found"));
    }
}
