package com.jsonplaceholder.utilities;


import com.jsonplaceholder.constants.Environment;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationSingleton {

    private static RequestSpecification requestSpec;

    private RequestSpecificationSingleton() {
    	
    }


    public static RequestSpecification getRequestSpecification() {
    	
    	 if (requestSpec == null) {
    		requestSpec = new RequestSpecBuilder().setBaseUri(Environment.valueOf(RestAssuredUtilities.testEnv).getValue())
    					.setContentType(ContentType.JSON).build();
         }
         return requestSpec;
    	
    }
}
