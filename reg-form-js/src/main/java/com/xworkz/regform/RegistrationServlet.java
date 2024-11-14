package com.xworkz.regform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");

        
        boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        
        if (name == null || name.length() < 3) {
            isValid = false;
            errorMessage.append("Name must be at least 3 characters.<br>");
        }

        if (email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
            isValid = false;
            errorMessage.append("Enter a valid email address.<br>");
        }

        if (phone == null || !phone.matches("^\\d{10}$")) {
            isValid = false;
            errorMessage.append("Phone must be a valid 10-digit number.<br>");
        }

        if (password == null || password.length() < 6) {
            isValid = false;
            errorMessage.append("Password must be at least 6 characters.<br>");
        }

        
        if (isValid) {
            request.setAttribute("message", "Registration Successful!");
            request.setAttribute("messageColor", "green");
        } else {
            request.setAttribute("message", errorMessage.toString());
            request.setAttribute("messageColor", "red");
        }

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}

