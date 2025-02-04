package org.example.jobportal.services;

import lombok.RequiredArgsConstructor;
import org.example.jobportal.entities.Job;
import org.example.jobportal.mappers.JobMapper;
import org.example.jobportal.models.JobDto;
import org.example.jobportal.repos.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final JobMapper jobMapper;
    public List<JobDto> getAllJobs(String company) {
        List<Job> jobs = (company != null) ?
                jobRepository.findByCompanyIgnoreCase(company) :
                jobRepository.findAll();

        return jobs.stream()
                .map(jobMapper::jobToJobDto)
                .collect(Collectors.toList());
    }

    public JobDto createJob(JobDto job) {
        return jobMapper.jobToJobDto(jobRepository.save(jobMapper.jobDtoToJob(job)));
    }

}

