import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class apiKeyManager {
    public static void main(String[] args) throws Exception {
        String apiKey = System.getenv("54daadaa-dadc-4c72-9e16-1c1b2113559b"); // Obtém a chave de uma variável de ambiente
        String url = "https://petstore.swagger.io/oauth/authorize";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        request.addHeader("Authorization", "Bearer " + apiKey);

        // Executa a requisição e processa a resposta
        // ...

    }
}

