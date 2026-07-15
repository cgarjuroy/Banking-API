package com.api.stepDefinitions;

import org.testng.Assert;

import com.api.services.AccountController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountUser_03 {
	private final TestContext context;
	private final AccountController accountController;

	public AccountUser_03(TestContext context, AccountController accountController)
	{
		this.context = context;
		this.accountController = accountController;
	}
	
	@Given("user has already logged in")
	public void user_has_already_logged_in() {
	    Assert.assertNotNull(context.getToken(),"Token is Null!");
	}

	@When("User navigated to account tab")
	public void user_navigated_to_account_tab() {
		accountController.token(context.getToken());
	   context.setResponse(accountController.userAccount());
	}

	@Then("Account details displayed successfully")
	public void account_details_displayed_successfully() {
	    
		Assert.assertEquals(context.getResponse().statusCode(), 200);
	}
}
