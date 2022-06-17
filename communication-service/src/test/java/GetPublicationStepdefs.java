import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetPublicationStepdefs {
    String POSTS_API_URL = "https://jsonplaceholder.typicode.com/posts";
    HttpClient _client;
    HttpRequest _request;

    @Given("I set GET publication service api endpoint")
    public void iSetGETPublicationServiceApiEndpoint() {
        HttpClient client = HttpClient.newHttpClient();
        _client = client;
    }


    @When("I perform GET for the publication number {string}")
    public void iGetAPublicationByPerformingGETOperationForThePublicationNumber(String arg0) {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POSTS_API_URL))
                .build();
        _request = request;
    }
    @Then("I should see the publication name as {string}")
    public void iShouldSeeThePublicationNameAs(String arg0) throws IOException, InterruptedException {
        HttpResponse<String> response = _client.send(_request, HttpResponse.BodyHandlers.ofString());
        assertNotNull(response);

    }


}
