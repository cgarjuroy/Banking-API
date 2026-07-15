package com.api.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

	private String token; 
	private String type; 
	private int id;
	private String username;
	private String email;
	private List<String>  roles;

}
