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

        String orderJson = "{ \"id\": 0, \"username\": \"user11\", \"firstName\": \"Primeiro\", \"lastName\": \"Teste\", \"email\": \"teste@email.com\", \"password\": \"123456\", \"phone\": 31999999999, \"userStatus\": 0 }";

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
}
