package com.xworkz.signupservice;

import com.xworkz.signup.dto.Signupdto;

public class Signupserviceimpl implements Signupservice {

	@Override
	public boolean validateAndSave(Signupdto dto) {
		System.out.println("Start validating Signupdto in Service");
		boolean valid = true;

		if (dto != null) {
			String userId = dto.getUserId();
			if (userId != null && !userId.isEmpty() && userId.length() >= 10) {
				System.out.println("userId is valid");
			} else {
				System.out.println("userId is invalid");
				valid = false;
			}

			String email = dto.getEmail();
			if (email != null && !email.isEmpty() && email.contains("@")
					&& (email.endsWith(".com") || email.endsWith(".in"))) {
				System.out.println("Email is valid");
			} else {
				System.out.println("Email is invalid");
				valid = false;
			}

			String password = dto.getPassword();
			if (password != null && password.length() >= 10) {
				System.out.println("Password is valid");
			} else {
				System.out.println("Password is invalid");
				valid = false;
			}

			String confirmPassword = dto.getConfirmPassword();
			if (confirmPassword != null && confirmPassword.equals(password)) {
				System.out.println("Confirm Password matches Password");
			} else {
				System.out.println("Confirm Password does not match Password");
				valid = false;
			}

		} else {
			System.out.println("Signupdto is null, cannot validate");
			valid = false;
		}

		if (valid) {
			System.out.println("Sign-up data is valid");

		} else {
			System.out.println("Sign-up validation failed");
		}

		return valid;
	}
}
