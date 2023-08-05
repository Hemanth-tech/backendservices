package hooks;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import constants.Environment;
import constants.ErrorCodes;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utilities.FrameworkUtilities;
import utilities.RestAssuredUtilities;

public class Hooks extends RestAssuredUtilities {
	private static final Logger logger = LogManager.getLogger(Hooks.class);

	private static RequestSpecification requestSpecification;

	@Before
	public void setup() throws IOException {
		// Set Request Specification
		if (requestSpecification == null) {
			requestSpecification = RestAssuredUtilities.buildReqSpec("QA");
		}

		// Verify if server is up
		int statusCode = RestAssured.given().spec(Hooks.getRequestSpecification()).when().get("/").getStatusCode();
		Assert.assertEquals(ErrorCodes.SERVER_DOWN.getMessage(), 200, statusCode);
		logger.info("JSONPlaceholder API is up and running");

	}

	@After
	public void teardown() {
		// Reset the RestAssured base URI after each scenario
		RestAssured.reset();
	}

	public static RequestSpecification getRequestSpecification() {
		return requestSpecification;
	}

}
