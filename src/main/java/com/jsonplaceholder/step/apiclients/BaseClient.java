package com.jsonplaceholder.step.apiclients;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.jsonplaceholder.constants.PayLoadPath;
import com.jsonplaceholder.hooks.Hooks;
import com.jsonplaceholder.utilities.FrameworkUtilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseClient {
	public static final Logger logger = LogManager.getLogger(BaseClient.class);

	protected RequestSpecification requestSpec;

	
	public void setRequestSpecification(RequestSpecification requestSpec) {
		this.requestSpec = requestSpec;
	}
	

	public void logApiResponse(Response response) {
		logger.info("Response Status Code: " + response.getStatusCode());
		logger.info("Response Body: " + response.getBody().asString());
	}

}
