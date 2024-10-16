package br.com.arthur.petstore;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PetOrderTest extends BaseTest {

    // 1. Cadastro novo pedido de pet com sucesso (POST /store/order)

    @Test
    public void PetOrderRegisterSuccess() {

        String orderJson = "{ \"id\": 0, \"petId\": 0, \"quantity\": 0, \"shipDate\": \"2024-10-16T04:45:17.806Z\", \"status\": \"placed\", \"complete\": true }";

        // Given
        given()
            .contentType(ContentType.JSON)
            .body(orderJson)
            // When
            .when()
                .post("/store/order")
            // Then
                .then()
                .statusCode(200)        // SUCCESS
                .body("petId", equalTo(0))
                .body("quantity", equalTo(0))
                .body("shipDate", equalTo("2024-10-16T04:45:17.806+0000"))
                .body("status", equalTo("placed"))
                .body("complete", equalTo(true));
    }

    // 2. Cadastro novo pedido de pet inválido (POST /store/order)

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
                .statusCode(400)        // STATUS CODE 400 (Bad Request )
                .body("message", equalTo("bad input"));
    }
}