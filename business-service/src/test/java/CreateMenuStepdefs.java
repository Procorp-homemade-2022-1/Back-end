import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateMenuStepdefs {
    String POSTS_API_URL = "https://homemade-evo.herokuapp.com/api";
    HttpClient _client;
    HttpRequest _request;
    String _api ;

    @Given("I set POST menu service api for {string}")
    public void iSetPOSTMenuServiceApiFor(String arg0) {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
        _api = arg0;
    }

    @When("I perform POST menu")
    public void iPerformPOSTMenu()
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(POSTS_API_URL))
                .header("accept", "application/json")
                .POST(BodyPublishers.ofString("menu1"))
                .build();
        _request = request;
    }

    @Then("I get a {int} status from menu service")
    public void iGetAStatusFromMenuService(int arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);
    }


}
