package com.api.stepDefinitions;

import static com.api.utils.ConfigUtility.getProperty;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.model.response.LoginResponse;
import com.api.services.AuthService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_01 {
	
	private JSONObject payload;
	private final TestContext context;
	private final AuthService authService;
	private LoginResponse loginResponse;
	
	public Login_01(TestContext context, AuthService authService)
	{
		this.context = context;
		this.authService = authService;
	}
	
	@Given("User has username and password")
	public void user_has_username_and_password() {
		
	    payload = new JSONObject();
	    payload.put("username" , getProperty("username"));
	    payload.put("password", getProperty("password"));
	}
	
	@When("User tries to login with valid credentials")
	public void user_tries_to_login_with_valid_credentials() {
		context.setResponse(authService.login(payload.toString()));
		loginResponse = context.getResponse().as(LoginResponse.class);
	}

	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
		
		context.setToken(loginResponse.getToken()); 
		
		Assert.assertEquals(context.getResponse().statusCode(),200);
		Assert.assertNotNull(context.getToken(), "Token is null!");
		authService.schemaValidator(context.getResponse());
	}

}
