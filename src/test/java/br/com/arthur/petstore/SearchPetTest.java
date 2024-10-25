package br.com.arthur.petstore;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SearchPetTest extends BaseTest {

    // 1. Pesquisar por um pet inexistente (GET /pet/{petId})

    private static final String PETID_ENDPOINT = "/pet/{petId}";

    @Test
    public void SearchInexistentPetTest() {

        int petIdInexistent = 917953802;

        // Given
        given()
            .pathParam("petId", petIdInexistent)
            // When
            .when()
                .get(PETID_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)  // STATUS CODE 404
                .body("message", equalTo("Pet not found"));
    }

    // 2. Pesquisar por um pet existente (GET /pet/{petId})

    @Test
    public void SearchExistentPetTest() {

        int petIdExistent = 10;

        // Given
        given()
            .pathParam("petId", petIdExistent)
            // When
            .when()
                .get(PETID_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_OK); // STATUS CODE 200
    }
    // 3. Pesquisar de forma inválida (GET /pet/{petId})

//    @Test
//    @Ignore("Teste para retornar Status Code 400 porém o Swagger retorna sempre 404")
//    public void SearchInvalidPetTest() {
//
//        int petIdInvalid = -1;
//
//        // Given
//        given()
//            .pathParam("petId", petIdInvalid)
//            // When
//            .when()
//                .get(PETID_ENDPOINT)
//            // Then
//            .then()
//                .statusCode(HttpStatus.SC_BAD_REQUEST)  // STATUS CODE 400
//                .body("message", equalTo("Invalid ID supplied"));
//    }
}