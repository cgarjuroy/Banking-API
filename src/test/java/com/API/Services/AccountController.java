package com.api.services;

import io.restassured.response.Response;

public class AccountController extends BaseService {

	private final String PATH ="/api/accounts";
	
	public void token(String token)
	{
		getToken(token);
	}
	
	public Response userAccount()
	{
		return getMethod(PATH+"/user");
	}
	
}
