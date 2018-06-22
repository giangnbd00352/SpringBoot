package com.example.Model;

import com.example.Entity.User;

public class LoginDTO {
	private String token;
	private User profile;
	
	public LoginDTO(String token, User profile) {
		super();
		this.token = token;
		this.profile = profile;
	}
	
	

	public LoginDTO() {
		super();
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getProfile() {
		return profile;
	}

	public void setProfile(User profile) {
		this.profile = profile;
	}

	
	
}
