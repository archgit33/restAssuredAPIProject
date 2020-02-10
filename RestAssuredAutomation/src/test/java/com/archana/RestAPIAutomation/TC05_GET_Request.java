
package com.archana.RestAPIAutomation;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_GET_Request {
	
	@Test
	void getPosts()
	{
		//Specifying Base URI		
		RestAssured.baseURI="http://qainterview.merchante-solutions.com:3030/";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
				
		//Response Object
		Response response=httpRequest.request(Method.GET,"posts");
		
		//Print response on the UI		
		String response_body=response.getBody().asString();		
		System.out.println("Response body is:" + response_body);
		
		//status code validation 
		int status_code=response.getStatusCode();
		System.out.println("Status code: "+ status_code);		
		//Assertion		
		Assert.assertEquals(200,status_code);
		
		//Status line verification
		String statusLine=response.getStatusLine();
		System.out.println("statusline: "+ statusLine);
		Assert.assertEquals("HTTP/1.1 200 OK", statusLine);
	}

}


