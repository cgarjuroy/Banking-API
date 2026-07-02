package com.api.stepDefinitions;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.model.response.LoginResponse;
import com.api.services.AuthService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class Login {
	
	JSONObject payload;
	Response response;
	LoginResponse loginResponse;
	static String token;

	@Given("User has username and password")
	public void user_has_username_and_password() {
	    payload = new JSONObject();
	    payload.put("username" , "arroy");
	    payload.put("password", "pass@1234");
	}

	@When("User tries to login with valid credentials")
	public void user_tries_to_login_with_valid_credentials() {
		AuthService authService = new AuthService();
		response = authService.login(payload.toString());
		loginResponse = response.as(LoginResponse.class);
	}

	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
		token = loginResponse.getToken();
		
		try {
		Assert.assertEquals(response.statusCode(),200);
		Assert.assertNotNull(token);
		}catch (Exception e)
		{
			Assert.fail();
		}
	}

}
