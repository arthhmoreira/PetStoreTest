package br.com.arthur.petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SearchPetByStatusTest extends BaseTest {

    //1. Pesquisar por pets com status “pending” (GET /pet/findByStatus)
    @Test
    public void TestSearchPetByStatus() {
        String status = "pending";

        // Given
        given()
            .queryParam("status", status)
            // When
            .when()
                .get("/pet/findByStatus")
            // Then
            .then()
                .statusCode(200)  // SUCCESS
                .body("status", everyItem(equalTo(status)));
    }

    //2. Pesquisar por pets com status inválido (GET /pet/findByStatus)

//    @Test
//    @Ignore("Teste para retornar Status Code 400 porém o Swagger retorna sempre 200")
//    public void TestSearchPetByStatusInvalid() {
//        String status = "invalido";
//
//        String responseBody =
//        // Given
//        given()
//            .queryParam("status", status)
//            // When
//            .when()
//                .get("/pet/findByStatus")
//            // Then
//            .then()
//                .statusCode(400)  // STATUS CODE 400 (Bad Request)
//                .extract().body().asString();
//
//        System.out.println("Response Body: " + responseBody);
//    }
}