package org.example.jobportal.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jobportal.models.JobDto;
import org.example.jobportal.services.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
@Slf4j
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping()
    public List<JobDto> getJobs(@RequestParam(required = false, value = "company") String company) {
        return jobService.getAllJobs(company);
    }

    @PostMapping
    public JobDto createUser(@RequestBody JobDto job) {
        return jobService.createJob(job);
    }

}

