package com.jsonplaceholder.step.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jsonplaceholder.constants.ApiResources;
import com.jsonplaceholder.constants.ApiResponse;
import com.jsonplaceholder.constants.ErrorCodes;
import com.jsonplaceholder.constants.PayLoadPath;
import com.jsonplaceholder.hooks.Hooks;
import com.jsonplaceholder.pojo.CreatePostResponse;
import com.jsonplaceholder.step.apiclients.BaseClient;
import com.jsonplaceholder.step.apiclients.PostClient;
import com.jsonplaceholder.utilities.FrameworkUtilities;
import com.jsonplaceholder.utilities.RequestSpecificationSingleton;
import com.jsonplaceholder.utilities.RestAssuredUtilities;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PostStepDefinitions {

	private static final Logger logger = LogManager.getLogger(PostStepDefinitions.class);
	PostClient client = new PostClient(RequestSpecificationSingleton.getRequestSpecification());

	private Response postResponse;
	private JsonNode createPostPayload;
	private Response getPost;
	private Integer deletPostID ;
	private Response updateDeletePostResponse;
	private String createdPostUserID = "1";


	@Given("the JsonPlaceHolder Post API is available")
	public void theJsonPlaceHolderPostAPIIsAvailable() {
		client.verifyEndpoint();
	}

	@Given("user has {string} payload to create POST")
	public void user_has_payload_to_create_post(String payloadType) throws IOException {
		if (payloadType.equals("Valid")) {
			createPostPayload = RestAssuredUtilities.setPayload(PayLoadPath.CREATE_POST_PAYLOAD.getFilePath());
			createdPostUserID = createPostPayload.get("userId").asText();
		}
		if (payloadType.equals("InValid")) {
			createPostPayload = RestAssuredUtilities.setPayload(PayLoadPath.CREATE_POST_PAYLOAD.getFilePath());
			Map<String, Object> payloadMap = RestAssuredUtilities.jsonToMap(createPostPayload);
			payloadMap.remove("title");
			createPostPayload = RestAssuredUtilities.mapToJson(payloadMap);
		}
	}

	@When("user make a POST request")
	public void user_make_a_post_request() throws IOException {
		postResponse = client.CreatePost(createPostPayload);
	}

	@Then("the {string} should contain posted data")
	public void the_response_should_contain_the_posted_data(String responseType) {
		if (responseType.equals("Createsponse")) {
			client.validatePostResponse(postResponse, createPostPayload);
		}
		if (responseType.equals("retrivedResponse")) {
			client.validatePostResponse(getPost, createPostPayload);
		}

	}

	@When("user retrievs post")
	public void userRetrievesPost1() {
		getPost = client.retrievPost(createdPostUserID);

	}

	@Given("user update the {string} as {string}")
	public void userUpdatesTheFieldAs(String field, String value) throws IOException {
		client.updatePost(Integer.parseInt(createdPostUserID), field, value);
	}

	@Then("the response should contain updated {string} as {string}")
	public void theResponseShouldContainUpdatedFieldAs(String field, String value) {
		client.validateUpdatedResponse(getPost, field, value);
	}

	@Given("user deleted post with below deatils")
	public void userDeletedPostWithBelowDetails(DataTable dataTable) throws IOException {
		Map<String,Integer> data = dataTable.asMap(String.class, Integer.class);
		deletPostID = data.get("PostID");
		client.deletePost(deletPostID);

	}

	@When("user tries to update the deleted post")
	public void userTriesToUpdateTheDeletedPost() throws IOException {
		updateDeletePostResponse = client.updatePost(deletPostID, "", "");

	}

	@Then("user should receive error message for {string}")
	public void userShouldReceiveErrorMessageFor(String errorMessage) {
		if(errorMessage.equals("updating deleted post")){
			//Add error based on how delete api is configured
		}
		if(errorMessage.equals("Retrieving deleted  posts")){
			//Add error based on how  api is configured
		}
		if(errorMessage.equals("Retrieving deleted user posts")){
			//Add error based on how api is configured
		}
	}

	@When("user tries to retrieve the deleted post")
	public void userTriesToRetrieveTheDeletedPost() {
		// Attempt to retrieve the deleted post
	}

	@Given("user delets the account with id {int}")
	public void userDeletesTheAccountWithId(int userId) {
		// Delete the user account with the provided ID
	}

	@When("user retrive post of user with id {int}")
	public void userRetrievePostOfUserWithId(int userId) {
		// Attempt to retrieve posts of the deleted user
	}

}
