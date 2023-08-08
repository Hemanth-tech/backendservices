package com.jsonplaceholder.hooks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.Assert;

import com.jsonplaceholder.constants.Environment;
import com.jsonplaceholder.constants.ErrorCodes;
import com.jsonplaceholder.utilities.FrameworkUtilities;
import com.jsonplaceholder.utilities.RequestSpecificationSingleton;
import com.jsonplaceholder.utilities.RestAssuredUtilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Hooks extends RestAssuredUtilities {
	private static final Logger logger = LogManager.getLogger(Hooks.class);

// rename hooks to driver
	@Before
	public void setup() throws IOException {

		// setTestEnv
		RestAssuredUtilities.setTestEnv("QA");

		// Verify if server is up
		int statusCode = RestAssured.given().spec(RequestSpecificationSingleton.getRequestSpecification()).when()
				.get("/").getStatusCode();
		Assert.assertEquals(ErrorCodes.SERVER_DOWN.getMessage(), 200, statusCode);
		logger.info("JSONPlaceholder server is up and running");

	}

	@After
	public void teardown() {
		// Reset the RestAssured base URI after each scenario
		RestAssured.reset();
	}

}
