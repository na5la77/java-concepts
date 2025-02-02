package org.example.jobportal.services;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.entities.JobApplication;
import org.example.jobportal.repos.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationrRepository;


    public List<JobApplication> getAllUsers() {
        return jobApplicationrRepository.findAll();
    }

    public JobApplication createJobApplication(JobApplication jobApplication) {
        return jobApplicationrRepository.save(jobApplication);
    }
    
}

