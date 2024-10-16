package br.com.arthur.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import static io.restassured.RestAssured.given;

public class ApiKeyManager {
    public static String getApiKey() {
        String apiKey = System.getenv("54daadaa-dadc-4c72-9e16-1c1b2113559b");
        RestAssured.baseURI = "https://petstore.swagger.io/";
        RestAssured.requestSpecification = given()
                .contentType(ContentType.JSON);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(RestAssured.baseURI);


        request.addHeader("Authorization", "Bearer " + apiKey);

        return apiKey;
    }
}

