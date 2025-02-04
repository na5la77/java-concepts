package org.example.jobportal.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jobportal.entities.JobApplication;
import org.example.jobportal.models.JobApplicationDto;
import org.example.jobportal.projections.JobApplicationProjection;
import org.example.jobportal.services.JobApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job-applications")
@Slf4j
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping
    public List<JobApplicationDto> getJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }

    @PostMapping
    public ResponseEntity<JobApplication> createJobApplication(@RequestBody @Valid JobApplicationDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jobApplicationService.createJobApplication(dto));
    }

    @GetMapping("/{id}")
    public JobApplicationProjection getJobApplication(@PathVariable Long id) {
        return jobApplicationService.getJobApplicationProjection(id);
    }

}
