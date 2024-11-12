package com.xworkz.studentformusingjs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/javascript")
public class Javascript extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");

        String name = request.getParameter("name");
        String userId = request.getParameter("userId"); // Corrected to match form field name
        String email = request.getParameter("email");

        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Form Submission</title></head><body>");
        out.println("<h2>Registration Details</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>User ID: " + userId + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p style='color:green;'>Registration successful!</p>"); // Success message
        out.println("</body></html>");

        out.close();
    }
}
