package com.api.services;

import com.api.models.request.SignUpRequest;

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
