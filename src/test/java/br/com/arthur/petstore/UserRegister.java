package br.com.arthur.petstore;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserRegister extends BaseTest {

    // 1. Cadastro de novo usuário com sucesso (POST /user)

    private static final String USER_ENDPOINT = "/user/";

    @Test
    public void UserRegisterSuccess() {

        String orderJson = "{ \"id\": 0, \"username\": \"user1\", \"firstName\": \"Primeiro\", \"lastName\": \"Teste\", \"email\": \"teste@email.com\", \"password\": \"123456\", \"phone\": 31999999999, \"userStatus\": 0 }";

        // Given
        given()
            .contentType(ContentType.JSON)
            .body(orderJson)
            // When
            .when()
                .post(USER_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_OK)        // STATUS CODE 200
                .body("code", equalTo(200));
    }

    // 2. Exclusão de usuário com sucesso (DELETE /user)

    @Test
    public void DeleteUserSuccess() {

        String username = "Testeuser";

        String responseBody =
        // Given
        given()
            .queryParam("username", username)
            // When
            .when()
                .delete(USER_ENDPOINT + username )
            // Then
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)    // STATUS CODE 404
                .extract().body().asString();

        System.out.println("Response Body: " + responseBody);
    }
}
