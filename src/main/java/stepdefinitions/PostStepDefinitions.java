package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.FrameworkUtilities;
import utilities.RestAssuredUtilities;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.CreatePostResponse;
import org.junit.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import constants.ApiResources;
import constants.ApiResponse;
import constants.ErrorCodes;
import constants.PayLoadPath;
import hooks.Hooks;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostStepDefinitions extends RestAssuredUtilities {

	private static final Logger logger = LogManager.getLogger(PostStepDefinitions.class);

	private Response response;
	private JsonNode createPostPayload;

	@Given("user has {string} payload to create POST")
	public void user_has_payload_to_create_post(String payloadType) throws IOException {
		if (payloadType.equals("Valid")) {
			createPostPayload = FrameworkUtilities.setPayload(PayLoadPath.CREATE_POST_PAYLOAD.getFilePath());
			logger.info("Creating valid payload to Create Post");
		}
	}

	@When("user make a POST request")
	public void user_make_a_post_request() throws IOException {
		response = RestAssured.given().spec(Hooks.getRequestSpecification()).when().body(createPostPayload)
				.post(ApiResources.post.getResource());
		logger.info("Request is sent to create new POST", createPostPayload);
	}

	@Then("the API should respond with {string} status message")
	public void the_api_should_respond_with_status_code_created(String expectedStatusMessage) {
		if (expectedStatusMessage.equals("Created")) {
			int actualStatusCode = response.getStatusCode();
			Assert.assertEquals(ErrorCodes.CREATE_POST_FAILED.getMessage(), ApiResponse.CREATED.getCode(),
					actualStatusCode);
			logger.info("New post is created");
		}
	}

	@Then("the response should contain posted data")
	public void the_response_should_contain_the_posted_data() {
		CreatePostResponse res = response.as(CreatePostResponse.class);
		Assert.assertEquals(ErrorCodes.INCORRECT_USERID.getMessage(), createPostPayload.get("userId").asInt(),
				res.getUserId().intValue());
		Assert.assertEquals(ErrorCodes.INCORRECT_TITLE.getMessage(), createPostPayload.get("title").asText(),
				res.getTitle());
		Assert.assertEquals(ErrorCodes.INCORRECT_BODY.getMessage(), createPostPayload.get("body").asText(),
				res.getBody());
		logger.info("Create post response pay load is validated");

	}

}
