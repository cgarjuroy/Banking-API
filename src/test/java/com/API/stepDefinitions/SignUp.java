package com.api.stepDefinitions;

import org.junit.Assert;

import com.api.models.request.SignUpRequest;
import com.api.services.AuthService;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;


public class SignUp {
	
	Response response;
	SignUpRequest signUpRequest;
	Faker faker;
	
	@Given("User has sign up details")
	public void user_has_sign_up_details() {
		
		faker = new Faker();
		signUpRequest = new SignUpRequest.Builder()
					.username(faker.name().username())
					.email(faker.internet().emailAddress())
					.firstName("Arjun")
					.lastName("Roy")
					.mobileNumber("9876540000")
					.password("Pwd@1234").build();
	}

	@When("User created new account")
	public void user_created_new_account() {
	    AuthService authService = new AuthService();
	    response = authService.signUp(signUpRequest);
	}

	@Then("Account is created successfully")
	public void account_is_created_successfully() {
		try {
			Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		}catch (Exception e) {
			Assert.fail();
		}
	}
}
