import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModifyRecipeStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    String _api ;

    @Given("I set PUT recipe service api for {string}")
    public void iSetPUTRecipeServiceApiFor(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
        _api = arg0;
    }

    @And("I perform PUT for the recipe number {string}")
    public void iPerformPUTForTheRecipeNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POSTS_API_URL))
                .header("accept", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString("menu1"))
                .build();
        _request = request;
    }


    @Then("I get a {int} status from modify recipe service")
    public void iGetAStatusFromModifyRecipeService(int arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }
}
