package com.api.stepDefinitions;

import org.testng.Assert;

import com.api.model.response.ProfileResponse;
import com.api.models.request.PasswordRequest;
import com.api.services.UserManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserProfile {
	static String token;
	Response response;
	PasswordRequest payload;

	//Scenario: Display user details------------------------------------------------------------
	
	@Given("User has login credentials")
	public void user_has_login_credentials() {
	    token = Login.token;
	}

	@When("User navigates to user management")
	public void user_navigates_to_user_management() {
		UserManagement user = new UserManagement();
		user.token(token);
	    response = user.userProfile();
	}

	@Then("User profile details are displayed successfully")
	public void user_profile_details_are_displayed_successfully() {
	    ProfileResponse profileResponse = response.as(ProfileResponse.class);
	    
	    try {
	    	Assert.assertEquals(profileResponse.getFirstName(), "Arjun");
	    	Assert.assertEquals(profileResponse.getUsername(), "arroy");
	    }catch (Exception e)
	    {
	    	Assert.fail();
	    }
	}
	
	
	
	//Scenario: User updates password-------------------------------------------------------
	
	
	@Given("User has logged into account")
	public void user_has_logged_into_account() {
		payload = new PasswordRequest.Builder()
				.confirmPassword("pass@1234").currentPassword("Pwd@1234").newPassword("pass@1234").build();
	}

	@When("User updated password from user management")
	public void user_updated_password_from_user_management() {
	    UserManagement user = new UserManagement();
	    user.token(token);
	    response = user.changePassword(payload);
	}

	@Then("Password is updated successfully")
	public void password_is_updated_successfully() {
	    try {
	    	Assert.assertEquals(response.statusCode(), 200);
	    	
	    }catch (Exception f)
	    {
	    	Assert.fail();
	    }
	}

}
