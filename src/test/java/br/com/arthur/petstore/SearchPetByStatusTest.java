package br.com.arthur.petstore;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchPetByStatusTest extends BaseTest {

    //1. Pesquisar por pets com status “pending” (GET /pet/findByStatus)

    private static final String FINDBYSTATUS_ENDPOINT = "/pet/findByStatus";

    @Test
    public void TestSearchPetByStatus() {
        String status = "pending";

        // Given
        given()
            .queryParam("status", status)
            // When
            .when()
                .get(FINDBYSTATUS_ENDPOINT)
            // Then
            .then()
                .statusCode(HttpStatus.SC_OK)  // STATUS CODE 200
                .body("status", everyItem(equalTo(status)));
    }

    //2. Pesquisar por pets com status inválido (GET /pet/findByStatus)

//    @Test
//    @Ignore("Teste para retornar Status Code 400 porém o Swagger retorna sempre 200")
//    public void TestSearchPetByStatusInvalid() {
//        String status = "invalido";
//
//        // Given
//        given()
//            .queryParam("status", status)
//            // When
//            .when()
//                .get(FINDBYSTATUS_ENDPOINT)
//            // Then
//            .then()
//                .statusCode(HttpStatus.SC_BAD_REQUEST) // STATUS CODE 400
//    }
}