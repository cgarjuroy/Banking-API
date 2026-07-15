package com.api.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.api.model.response.ProfileResponse;
import com.api.models.request.PasswordRequest;
import com.api.services.UserManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserProfile_02 {
	
	private final TestContext context;
	private PasswordRequest payload;
	private final UserManagement userManagement;

	public UserProfile_02(TestContext context, UserManagement userManagement) 
	{
		this.context = context;
		this.userManagement = userManagement;
	}
	
	//Scenario: Display user details------------------------------------------------------------
	
	@Given("User has login credentials")
	public void user_has_login_credentials() {
		Assert.assertNotNull(context.getToken(),"Token is Null!");
	}

	@When("User navigates to user management")
	public void user_navigates_to_user_management() {
		userManagement.token(context.getToken());
	    context.setResponse(userManagement.userProfile());
	}

	@Then("User profile details are displayed successfully")
	public void user_profile_details_are_displayed_successfully() {
	    ProfileResponse profileResponse = context.getResponse().as(ProfileResponse.class);

	    Assert.assertEquals(profileResponse.getFirstName(), "Arjun");
	    Assert.assertEquals(profileResponse.getUsername(), "arroy");
	    userManagement.schemaValidation(context.getResponse());
	}
	
	
	
	//Scenario: User updates password-------------------------------------------------------
	
	
	@Given("User has logged into account")
	public void user_has_logged_into_account() {
		payload = PasswordRequest.builder()
				.confirmPassword("pass@1234").currentPassword("Pwd@1234").newPassword("pass@1234").build();
	}

	@When("User updated password from user management")
	public void user_updated_password_from_user_management() {
		userManagement.token(context.getToken());
	    context.setResponse(userManagement.changePassword(payload));
	}

	@Then("Password is updated successfully")
	public void password_is_updated_successfully() {
	    Assert.assertEquals(context.getResponse().statusCode(), 200);	
	    Assert.assertTrue(context.getResponse().getTimeIn(TimeUnit.SECONDS)<2000);
	}

}
