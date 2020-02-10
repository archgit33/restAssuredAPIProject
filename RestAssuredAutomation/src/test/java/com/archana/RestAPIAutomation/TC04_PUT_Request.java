package com.archana.RestAPIAutomation;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC04_PUT_Request {

	/**
	  updatecomments
	 */
	
	@Test
	void updateComments()
	{
		//Specifying Base URI		
		RestAssured.baseURI="http://qainterview.merchante-solutions.com:3030/comments";
		
		//Request Object
		RequestSpecification httpRequest=RestAssured.given();
				
		//Request Payload sending along with the post request
		JSONObject requestParams=new JSONObject();
		requestParams.put("username","archanaTest");
		requestParams.put("name","archana");
		requestParams.put("email","arch@noreply.com");
		requestParams.put("body","This is a comment posted by Archana again");
		
		
		httpRequest.header("Content-Type", "application/json");		
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response=httpRequest.request(Method.PUT,"02062020");		
		
		
		//Print response on the UI		
		String response_body=response.getBody().asString();		
		System.out.println("Response body is:" + response_body);
		
		//status code validation 
		int status_code=response.getStatusCode();
		System.out.println("Status code: "+ status_code);		
		//Assertion		
		Assert.assertEquals(status_code,200);
		
        JsonPath changedBody = response.jsonPath();
        String newBody = changedBody.get("body");
        Assert.assertEquals(newBody, "This is a comment posted by Archana again");
		
	}

}


