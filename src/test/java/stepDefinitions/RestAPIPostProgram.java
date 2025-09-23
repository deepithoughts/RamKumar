package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.net.URL;

public class RestAPIPostProgram {

    RequestSpecification res;
    Response response;
    String response1;

    @Given("User is on the website landing page {string}")
    public void user_is_on_the_website_landing_page(String string) {

        RestAssured.baseURI="https://api.restful-api.dev/";
        res=RestAssured.given();


    }
    @When("the user hits the {string} with payload using http post request")
    public void the_user_hits_the_with_payload_using_http_post_request(String url, String body)  {
       response=res.header("Content-Type","application/json").log().all()
                .body(body).post(url);
        System.out.println(response);
    }

    @Then("capture the {string} from the resposne body")
    public void capture_the_from_the_resposne_body(String id) {

        JsonPath js = new JsonPath(String.valueOf(response));
        String appleid=js.getString(id);
        System.out.println("appleid");
        //String appleid = response.jsonPath().get(id);
    }

    @Then("the response body is verified where name is {string}")
    public void the_response_body_is_verified_where_name_is(String expectedname) {
        String name =response.jsonPath().getString("name");
        //res.then().log().all();
        Assert.assertEquals(name,expectedname);
    }
    @Then("status code is {int}")
    public void status_code_is(Integer statuscode) {
        Assert.assertEquals(response.getStatusCode(),statuscode);
    }



}
