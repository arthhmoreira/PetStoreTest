package br.com.arthur.petstore;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
