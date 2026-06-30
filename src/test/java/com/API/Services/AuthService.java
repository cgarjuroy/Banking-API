package com.API.Services;

import com.models.Request.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	private static final String PATH = "/api/auth/"; 

	
	public Response signUp(SignUpRequest payload)
	{
		return postMethod(payload, PATH+"signup"); 
	}
	
	
	public Response login(String payload)
	{
		return postMethod(payload, PATH+"login"); 
	}
}
