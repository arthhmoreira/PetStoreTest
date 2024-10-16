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
                    .statusCode(200)  // STATUS CODE 200 (Sucess)
                    .body("size()", greaterThan(0));
    }
}