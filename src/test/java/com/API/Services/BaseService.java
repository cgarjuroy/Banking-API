package com.api.services;

import static com.api.utils.ConfigUtility.getProperty;

import com.api.filters.CustomError;
import com.api.filters.SmartLogging;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseService {
	
	private RequestSpecification request;
	private final String BASE_URI;
	
	 public BaseService()
	 {
		 this.BASE_URI = System.getProperty("env.url")!= null?System.getProperty("env.url")
					:getProperty("base.uri");
				
		 this.request = RestAssured.given().baseUri(BASE_URI).filter(new CustomError()).filter(new SmartLogging());
				 
	 }
	
	protected Response postMethod(Object payload, String path)
	{
		return request.contentType(ContentType.JSON).body(payload).post(path);
	}
	
	protected Response getMethod(String path)
	{
		return request.given().baseUri(BASE_URI).get(path);
	}
	
	public void getToken(String token)
	{
		request.header("Authorization", "Bearer "+token);
	}
	
	protected Response putMethod(Object payload, String path)
	{
		return request.contentType(ContentType.JSON).body(payload).put(path);
	}
	
	public void jsonSchemaValidator(Response response, String schemaPath)
	{
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
	}
}
