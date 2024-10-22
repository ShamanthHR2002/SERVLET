package com.xworkz.job.service;

import com.xworkz.job.dto.JobDTO;

public class JobServiceImpl implements JobService {

    @Override
    public boolean validateAndSave(JobDTO jobDTO) {
        System.out.println("Start validating JobDTO in Service");

        boolean valid = true;  

        if (jobDTO == null) {
            System.out.println("JobDTO is null. Validation failed.");
            return false;
        }

      
        String name = jobDTO.getName();
        if (name != null && !name.isEmpty() && name.length() >= 3) {
            System.out.println("Name is Valid");
        } else {
            System.out.println("Name is Invalid");
            valid = false;
        }

       
        String email = jobDTO.getEmail();
        if (email != null && !email.isEmpty() && email.contains("@") 
            && (email.endsWith(".com") || email.endsWith(".in"))) {
            System.out.println("Email is Valid");
        } else {
            System.out.println("Email is Invalid");
            valid = false;
        }

        
        String yop = jobDTO.getYop();
        if (yop != null && !yop.isEmpty() && yop.matches("\\d{4}")) {  // Validates a 4-digit year
            System.out.println("Year of Passing is Valid");
        } else {
            System.out.println("Year of Passing is Invalid");
            valid = false;
        }

      
        if (valid) {
            System.out.println("JobDTO is valid. Proceed to save.");
            
        } else {
            System.out.println("JobDTO validation failed.");
        }

        return valid;
    }
}