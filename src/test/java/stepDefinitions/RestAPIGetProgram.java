package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class RestAPIGetProgram {
    RequestSpecification res;
    Response response;

    @Given("Hit the base URL {string}")
    public void hit_the_base_url(String string) {

        RestAssured.baseURI="https://api.restful-api.dev/";
        res=RestAssured.given().log().all();
    }
    @When("the user hits the {string} with payload GET HTTP request")
    public void the_user_hits_the_with_payload_get_http_request(String url) {
        response=res.get(url);
    }
    @Then("status code is verified as {int}")
    public void status_code_is_verified_as(Integer statuscode) {
        Assert.assertEquals(response.getStatusCode(),statuscode);


    }


}
