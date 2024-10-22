package com.xworkz.job.service;

import com.xworkz.job.dto.JobDTO;

public interface JobService {
    boolean validateAndSave(JobDTO jobDTO);
}