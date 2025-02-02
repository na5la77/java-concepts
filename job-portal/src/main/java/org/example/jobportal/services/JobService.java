package org.example.jobportal.services;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.entities.Job;
import org.example.jobportal.repos.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;


    public List<Job> getAllJobs(String company) {
        if (company != null) {
            return jobRepository.findByCompanyIgnoreCase(company);
        }
        return jobRepository.findAll();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

}

