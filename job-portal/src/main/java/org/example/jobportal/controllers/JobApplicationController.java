package org.example.jobportal.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jobportal.entities.JobApplication;
import org.example.jobportal.models.JobApplicationDto;
import org.example.jobportal.projections.JobApplicationProjection;
import org.example.jobportal.services.JobApplicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-applications")
@Slf4j
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping
    public List<JobApplicationProjection> getJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @PostMapping
    public JobApplication createJobApplication(@RequestBody JobApplicationDto dto) {
        return jobApplicationService.createJobApplication(dto);
    }
}
