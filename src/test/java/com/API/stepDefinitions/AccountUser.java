package com.api.stepDefinitions;

import org.testng.Assert;

import com.api.services.AccountController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class AccountUser {
	static String token;
	Response response;
	
	@Given("user has already logged in")
	public void user_has_already_logged_in() {
	    token = Login.token;
	}

	@When("User navigated to account tab")
	public void user_navigated_to_account_tab() {
	   AccountController accountController = new AccountController();
	   accountController.token(token);
	   response = accountController.userAccount();
	}

	@Then("Account details displayed successfully")
	public void account_details_displayed_successfully() {
	    
		Assert.assertEquals(response.statusCode(), 200);
	}
}
