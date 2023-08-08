package com.jsonplaceholder.step.stepdefinitions;

import com.jsonplaceholder.step.apiclients.CommentsClient;
import com.jsonplaceholder.step.apiclients.PostClient;
import com.jsonplaceholder.utilities.RequestSpecificationSingleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CommentStepDefinitions {

	CommentsClient commentClient = new CommentsClient(RequestSpecificationSingleton.getRequestSpecification());
	PostClient postClient = new PostClient(RequestSpecificationSingleton.getRequestSpecification());
	Integer postID = 1;

	@Given("the user is authenticated")
	public void the_user_is_authenticated() {
		// Implementation for verifying user authentication has to be added
	}

	@Given("the JsonPlaceHolder Comment API is available")
	public void the_json_place_holder_comment_api_is_available() {
		commentClient.verifyEndpoint();

	}

	@Given("user created a post")
	public void user_created_a_post() {
		/*
		 * we can use post client to create post
		 * postClient.CreatePost(createPostPayload) and get the PostID from response
		 */

	}

	@When("user {string} comment to the post")
	public void user_comment_to_the_post(String action) {

		if (action.equals("adds")) {
			commentClient.addCommentToPost(postID);
		}

		if (action.equals("deletes")) {
			/*
			 * we can code related delete api
			 */
		}

		if (action.equals("update")) {

		}

	}

	@Then("comment should be retrieved")
	public void comment_should_be_retrieved() {

		commentClient.retreiveComments(postID);

	}

	@Given("user delete the post with ID {int}")
	public void userDeleteThePostWithId(int postId) {
		commentClient.deleteComment(postId);
	}


	@When("user retrive comments of {int}")
	public void user_retrive_comments_of(Integer postId) {
		commentClient.retreiveComments(postId);

	}

	@Then("user should receive comment realted error message for {string}")
	public void userShouldReceiveErrorMessageFor(String errorMessage) {

	}

	@Given("user deletes the account with id {int}")
	public void userDeletesTheAccountWithId(int userId) {
		commentClient.deleteComment(userId);

	}


}
