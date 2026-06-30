package com.API.Services;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	private static final String BASE_URI = "http://64.227.160.186:8080";
	private RequestSpecification request;
	
	public BaseService() {
		request = given().baseUri(BASE_URI);
	}


	protected Response postMethod(Object payload, String path)
	{
		return request.contentType(ContentType.JSON).body(payload).post(path);
	}
}
