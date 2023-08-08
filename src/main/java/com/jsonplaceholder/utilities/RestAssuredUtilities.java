package com.jsonplaceholder.utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.jsonplaceholder.constants.Environment;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtilities extends FrameworkUtilities {

	public static RequestSpecification reqSpec;
	public static String testEnv;

	public static String getTestEnv() {
		return testEnv;
	}

	public static void setTestEnv(String newTestEnv) {
		testEnv = newTestEnv;
	}

	// POST or GET Function (payload, endpoint) throws run time exception based on
	// status code

	public static Map<String, String> getHeaderMap() {
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		return headers;
	}

}
