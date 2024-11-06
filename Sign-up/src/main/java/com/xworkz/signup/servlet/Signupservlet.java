package com.xworkz.signup.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xworkz.signup.dto.Signupdto;
import com.xworkz.signupservice.Signupservice;
import com.xworkz.signupservice.Signupserviceimpl;

@WebServlet("/signup")
public class Signupservlet extends HttpServlet {

	private Signupservice service = new Signupserviceimpl();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		Signupdto signupdto = new Signupdto(userId, email, password, confirmPassword);

		if (service.validateAndSave(signupdto)) {
			response.getWriter().println("Signup Details Submitted Successfully");
		} else {
			response.getWriter().println("Invalid Signup Details");
		}
	}
}
