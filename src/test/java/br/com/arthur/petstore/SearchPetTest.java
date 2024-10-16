package br.com.arthur.petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SearchPetTest extends BaseTest {

    // 1. Pesquisar por um pet inexistente (GET /pet/{petId})
    @Test
    public void SearchInexistentPetTest() {

        int petIdInexistent = 72;

            // Given
            given()
                .pathParam("petId", petIdInexistent)
                // When
                .when()
                    .get("/pet/{petId}")
                // Then
                .then()
                    .statusCode(404)  // STATUS CODE 404 (Not Found)
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
                    .get("/pet/{petId}")
                // Then
                    .then()
                    .statusCode(200); // STATUS CODE 200 (Sucess)
    }
    // 3. Pesquisar de forma inválida (GET /pet/{petId})
//    @Test
//    @Ignore("Teste para retornar Status Code 400 porém o Swagger retorna sempre 404")
//    public void SearchInvalidPetTest() {
//
//        int petIdInvalid = -1;
//
//                // Given
//                given()
//                        .pathParam("petId", petIdInvalid)
//                        // When
//                        .when()
//                        .get("/pet/{petId}")
//                        // Then
//                        .then()
//                        .statusCode(400)  // STATUS CODE 400 (Not Found)
//                        .body("message", equalTo("Invalid ID supplied"))
//
//    }
}