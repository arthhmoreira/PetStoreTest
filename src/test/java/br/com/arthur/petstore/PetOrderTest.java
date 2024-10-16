package br.com.arthur.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetOrderTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    // 1. Cadastro novo pedido de pet com sucesso (POST /store/order)
    @Test
    public void PetOrderRegisterSucess() {

        String orderJson = "{ \"id\": 0, \"petId\": 0, \"quantity\": 0, \"shipDate\": \"2024-10-16T04:45:17.806Z\", \"status\": \"placed\", \"complete\": true }";

            // Given
            given()
                .contentType(ContentType.JSON)
                .body(orderJson)
                // When
                .when()
                    .post("/store/order")   // POST
                // Then
                    .then()
                    .statusCode(200)        // STATUS CODE 200 (Sucess)
                    .body("status", equalTo("placed"));
    }

    // 2. Cadastro de novo pedido de pet inválido (POST /store/order)
    @Test
    public void PetOrderRegisterFailed() {

        String orderJson = "{ \"id\": 0, \"petId\": 112898-165, \"quantity\": 0, \"shipDate\": \"2024-10-16T04:45:17.806Z\", \"status\": \"placed\", \"complete\": true }";

            // Given
            given()
                .contentType(ContentType.JSON)
                .body(orderJson)
                // When
                .when()
                    .post("/store/order")   // POST
                // Then
                .then()
                    .statusCode(400)        // STATUS CODE 400 (Bad Request)
                    .body("message", equalTo("bad input"));
    }
}