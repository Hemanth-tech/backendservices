package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import constants.Environment;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtilities extends JSONUtilities {
	
	public static RequestSpecification reqSpec;
	Environment env =Environment.valueOf("QA");

	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(reqSpec==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec=new RequestSpecBuilder().setBaseUri(env.getValue()).addHeaders(getHeaderMap())
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return reqSpec;
		}
		return reqSpec;
		
		
	}
	
	
	public static Map<String, String> getHeaderMap() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }
	

}
