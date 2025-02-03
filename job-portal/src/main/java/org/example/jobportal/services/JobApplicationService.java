package org.example.jobportal.services;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.entities.Job;
import org.example.jobportal.entities.JobApplication;
import org.example.jobportal.entities.User;
import org.example.jobportal.models.JobApplicationDto;
import org.example.jobportal.projections.JobApplicationProjection;
import org.example.jobportal.repos.JobApplicationRepository;
import org.example.jobportal.repos.JobRepository;
import org.example.jobportal.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;

    public List<JobApplicationProjection> getAllJobApplications() {
        return jobApplicationRepository.findAllProjectedBy();
    }

    public JobApplication createJobApplication(JobApplicationDto dto) {
        JobApplication jobApplication = new JobApplication();
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        jobApplication.setUser(user);
        jobApplication.setJob(job);
        return jobApplicationRepository.save(jobApplication);
    }

}
