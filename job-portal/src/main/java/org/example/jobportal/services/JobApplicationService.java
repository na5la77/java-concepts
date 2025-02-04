package org.example.jobportal.services;

import jakarta.persistence.EntityNotFoundException;
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

    public JobApplication createJobApplication(JobApplicationDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Job job = jobRepository.findById(dto.getJobId())
                .orElseThrow(() -> new EntityNotFoundException("Job not found"));

        JobApplication jobApplication = new JobApplication(user, job);
        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplicationProjection getJobApplicationProjection(Long id) {
        return jobApplicationRepository.findProjectedById(id);
    }

    public List<JobApplicationDto> getAllJobApplications() {
        return jobApplicationRepository.findAllJobApplications();
    }


}
