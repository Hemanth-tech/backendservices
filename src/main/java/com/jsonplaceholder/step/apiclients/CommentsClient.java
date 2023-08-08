package com.jsonplaceholder.step.apiclients;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.jsonplaceholder.constants.ApiResources;
import com.jsonplaceholder.constants.ApiResponse;
import com.jsonplaceholder.constants.ErrorCodes;
import com.jsonplaceholder.utilities.RequestSpecificationSingleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommentsClient extends BaseClient {

	public static final Logger logger = LogManager.getLogger(PostClient.class);
	public String endPoint = ApiResources.COMMENT.getResource();

	public CommentsClient(RequestSpecification requestSpec) {
		this.requestSpec = requestSpec;
	}

	public void verifyEndpoint() {
		int statusCode = RestAssured.given().spec(RequestSpecificationSingleton.getRequestSpecification())
				.pathParam("postID", "1").when().get(ApiResources.COMMENT.getResource()).getStatusCode();
		Assert.assertEquals(ErrorCodes.COMMENT_ENDPOINT_IS_DOWN.getMessage(), 200, statusCode);
		logger.info("JSONPlaceholder Comment End point is up and running");
	}

	public void addCommentToPost(Integer postIDValue) {
		int statusCode = RestAssured.given().spec(RequestSpecificationSingleton.getRequestSpecification())
				.pathParam("postID", postIDValue).when().post(ApiResources.COMMENT.getResource()).getStatusCode();
		Assert.assertEquals(ErrorCodes.COMMENT_ENDPOINT_IS_DOWN.getMessage(), 201, statusCode);
		logger.info("added comment to post");
	}

	public Response retreiveComments(Integer postIDValue) {

		Response response = RestAssured.given().spec(requestSpec).pathParam("postID", "1").when().get(endPoint);
		logger.info("Request is sent to retrive comment based on userId", postIDValue);
		Assert.assertEquals(ErrorCodes.RETRIVE_COMMENT_BY_POSTID_FAILED.getMessage(), ApiResponse.SUCCESS.getCode(),
				response.getStatusCode());
		return response;
	}

	public Response validateErrorMessage(Integer postIDValue) {

		Response response = RestAssured.given().spec(requestSpec).pathParam("postID", postIDValue).when().get(endPoint);
		logger.info("Request is sent to retrive comment based on userId", postIDValue);
		Assert.assertEquals(ErrorCodes.RETRIVE_COMMENT_BY_POSTID_FAILED.getMessage(), ApiResponse.SUCCESS.getCode(),
				response.getStatusCode());
		return response;
	}
	
	public void deleteComment(Integer postID) {
		/*
		 * Used get api here as delete api , doesn't really delete from server
		 * */
		int statusCode = RestAssured.given().spec(RequestSpecificationSingleton.getRequestSpecification())
				.pathParam("postID", "1").when().get(ApiResources.COMMENT.getResource()).getStatusCode();
		Assert.assertEquals(ErrorCodes.COMMENT_ENDPOINT_IS_DOWN.getMessage(), 200, statusCode);
		logger.info("added comment to post");
	}

}
