package com.xworkz.signupservice;

import com.xworkz.signup.dto.Signupdto;

public interface Signupservice {
	boolean validateAndSave(Signupdto dto);
}
