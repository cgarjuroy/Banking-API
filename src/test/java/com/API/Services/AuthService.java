package com.api.services;

import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	private final String PATH = "/api/auth/"; 
	private final String SCHEMA_PATH = "JsonSchemas/LoginResponse.json";

	
	public Response signUp(SignUpRequest payload)
	{
		return postMethod(payload, PATH+"signup"); 
	}
	
	public Response login(String payload)
	{
		return postMethod(payload, PATH+"login"); 
	}
	
	public void schemaValidator(Response response)
	{
		 jsonSchemaValidator(response, SCHEMA_PATH);
	}
}
