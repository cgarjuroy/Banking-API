package com.api.stepDefinitions;

import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {
	
	private String token;
	private Response response;	
}
