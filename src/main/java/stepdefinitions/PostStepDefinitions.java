package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.RestAssuredUtilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import constants.ApiResources;
import constants.Environment;
import constants.ErrorCodes;

import java.io.IOException;
import java.util.Map;

public class PostStepDefinitions  extends RestAssuredUtilities{
	
	private Response response;
    @Given("the JSONPlaceholder API is up and running")
    public void the_json_placeholder_api_is_up_and_running() throws IOException {
    	int statusCode = RestAssured.given().spec(requestSpecification()).when().get("/").getStatusCode();
        Assert.assertEquals(ErrorCodes.SERVER_DOWN.getMessage(),200, statusCode);
        
    }

    @When("I make a POST request to the endpoint {string} with the following data:")
    public void i_make_a_post_request_to_the_endpoint_with_the_following_data(String string, DataTable dataTable) throws IOException {
        Map<String, String> postPayload = dataTable.asMap(String.class, String.class);
        response =  RestAssured.given().spec(requestSpecification()).when().body(postPayload).post(ApiResources.post.getResource());

    }

    @Then("the API should respond with {int} status code")
    public void the_api_should_respond_with_status_code_created(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(ErrorCodes.CREATE_POST_FAILED.getMessage(),expectedStatusCode, actualStatusCode);
    }

    @Then("the response should contain the following data:")
    public void the_response_should_contain_the_following_data(DataTable dataTable) {
        Map<String, String> expectedData = dataTable.asMap(String.class, String.class);
        Map<String, String> responseData = response.jsonPath().getMap("");
        Assert.assertEquals(ErrorCodes.INCORRECT_USERID.getMessage(),expectedData.get("userId"), responseData.get("userId"));
        Assert.assertEquals(ErrorCodes.INCORRECT_TITLE.getMessage(),expectedData.get("title"), responseData.get("title"));
        Assert.assertEquals(ErrorCodes.INCORRECT_BODY.getMessage(),expectedData.get("body"), responseData.get("body"));
    }


}
