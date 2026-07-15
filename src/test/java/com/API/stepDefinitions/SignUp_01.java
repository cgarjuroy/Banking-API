package com.api.stepDefinitions;

import org.junit.Assert;

import com.api.models.request.SignUpRequest;
import com.api.services.AuthService;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignUp_01 {
	
	private SignUpRequest signUpRequest;
	private TestContext context;
	private Faker faker;
	private final AuthService authService;
	
	public SignUp_01(TestContext context,AuthService authService) {
		this.context = context;
		this.authService = authService;
	}

	@Given("User has sign up details")
	public void user_has_sign_up_details() {
		
		faker = new Faker();
		signUpRequest = SignUpRequest.builder()
					.username(faker.name().username())
					.email(faker.internet().emailAddress())
					.firstName("Arjun")
					.lastName("Roy")
					.mobileNumber("9876540000")
					.password("Pwd@1234").build();
	}

	@When("User created new account")
	public void user_created_new_account() {
	    context.setResponse(authService.signUp(signUpRequest));
	}

	@Then("Account is created successfully")
	public void account_is_created_successfully() {
		Assert.assertEquals(context.getResponse().asPrettyString(), "User registered successfully!");
	}
}
