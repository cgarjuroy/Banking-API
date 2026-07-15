package com.api.services;

import com.api.models.request.PasswordRequest;

import io.restassured.response.Response;


public class UserManagement extends BaseService {
	
	private final String PATH = "/api/users";
	private final String SCHEMA_PATH = "JsonSchemas/ProfileResponse.json";
	
	
	public void token(String token) {
		getToken(token);
	}
	
	
	public Response userProfile()
	{
		return getMethod(PATH +"/profile" );
	}
	
	public Response changePassword(PasswordRequest payload)
	{
		return putMethod(payload, PATH + "/change-password");
	}
	
	public void schemaValidation(Response response)
	{
		 jsonSchemaValidator(response, SCHEMA_PATH);
	}
	
}
