package com.xworkz.signup.dto;

public class Signupdto {
	private String userId;
	private String email;
	private String password;
	private String confirmPassword;

	public Signupdto(String userId, String email, String password, String confirmPassword) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
