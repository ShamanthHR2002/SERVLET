package com.xworkz.JobServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xworkz.job.dto.JobDTO;
import com.xworkz.job.service.JobService;
import com.xworkz.job.service.JobServiceImpl;

@WebServlet("/submitJobForm")
public class JobServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String yop = request.getParameter("yop");

        
        JobDTO jobDTO = new JobDTO();
        jobDTO.setName(name);
        jobDTO.setEmail(email);
        jobDTO.setYop(yop);

        
        JobService jobService = new JobServiceImpl();
        boolean isValid = jobService.validateAndSave(jobDTO);

      
        if (isValid) {
            response.getWriter().println("Job DTO is valid and saved successfully!");
        } else {
            response.getWriter().println("Job DTO validation failed! Please check the input.");
        }
    }
}
