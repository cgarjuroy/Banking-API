package com.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse {

	private int id;
	private String username;
	private String email;
	private String firstName; 
	private String lastName; 
	private String mobileNumber;
	
}
