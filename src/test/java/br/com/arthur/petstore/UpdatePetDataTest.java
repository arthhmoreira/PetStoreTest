package br.com.arthur.petstore;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UpdatePetDataTest extends BaseTest {

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
            .statusCode(200)    // SUCCESS
            .body("name", equalTo("Cachorro"))
            .body("status", equalTo("unavailable"));
    }

    //2. Atualizar dados de um pet inválido (PUT /pet)

    @Test
    public void UpdateExistentPetInvalidDataTest() {
        String petJson = "{ \"id\": 990751%6623451, \"name\": \"Cachorro\", \"status\": \"unavailable\" }";

        // Given
        given()
            .contentType(ContentType.JSON)
            .body(petJson)
        // When
        .when()
            .put("/pet/")
        // Then
        .then()
            .statusCode(400)  // BAD REQUEST
            .body("message", equalTo("bad input"));
    }
}