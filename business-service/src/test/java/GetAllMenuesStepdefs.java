import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetAllMenuesStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    String _api ;

    @Given("I get all menus with GET operation for the {string}")
    public void iGetAllMenusWithGETOperationForThe(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
        _api = arg0;
    }


    @When("I perform GET all menus")
    public void iPerformGETAllMenus() {
        HttpRequest request = HttpRequest.newBuilder()
                .DELETE()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL + _api))
                .build();
        _request = request;
    }

    @Then("I get {string} menus as a result")
    public void iGetMenusAsAResult(String arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }


}