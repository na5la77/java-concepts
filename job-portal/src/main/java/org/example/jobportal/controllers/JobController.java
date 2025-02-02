package org.example.jobportal.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.jobportal.entities.Job;
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
    public List<Job> getJobs(@RequestParam(required = false,value = "company") String company) {
        return jobService.getAllJobs(company);
    }

    @PostMapping
    public Job createUser(@RequestBody Job job) {
        return jobService.createJob(job);
    }

}

