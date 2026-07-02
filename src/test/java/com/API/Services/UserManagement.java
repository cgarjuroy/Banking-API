package com.api.services;

import com.api.models.request.PasswordRequest;

import io.restassured.response.Response;

public class UserManagement extends BaseService {
	
	private static final String PATH = "/api/users";
	
	
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
}
