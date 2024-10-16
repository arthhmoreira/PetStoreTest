package br.com.arthur.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdatePetData {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    //1. Atualizar dados de um pet existente (PUT /pet)
    @Test
    public void UpdateExistentPetDataTest() {
        String petJson = "{ \"id\": 0, \"name\": \"Cachorro\", \"status\": \"unavailable\" }";

            // Given
            given()
                .contentType(ContentType.JSON)
                .body(petJson)
                // When
                .when()
                    .put("/pet/")
                // Then
                .then()
                    .statusCode(200)  // STATUS CODE 200 (Sucess)
                    .body("name", equalTo("Cachorro"))
                    .body("status", equalTo("unavailable"));
    }
}