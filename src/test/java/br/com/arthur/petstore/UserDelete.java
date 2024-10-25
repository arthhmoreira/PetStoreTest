package br.com.arthur.petstore;

import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserDelete extends BaseTest {

// 1. Exclusão de usuário com sucesso (DELETE /user)

private static final String USER_ENDPOINT = "/user/{username}";

    @Test
    public void DeleteUserSuccess() {


        String userName = "user1";

        // Given
        given()
            .contentType(ContentType.JSON)
            .pathParam("username", userName)
            // When
            .when()
                .delete(USER_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_OK)    // STATUS CODE 404
                .body("code", equalTo(200))
                .body("message", equalTo(userName));
    }

    // 2. Exclusão de usuário não encontrado (DELETE /user)

    @Test
    public void DeleteUserNotFound() {

        String userName = "pateta";

        // Given
        given()
            .pathParam("username", userName)
            // When
            .when()
                .delete(USER_ENDPOINT + userName )
            // Then
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);    // STATUS CODE 404
    }
}