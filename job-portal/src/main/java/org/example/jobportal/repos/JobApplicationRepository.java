package org.example.jobportal.repos;

import org.example.jobportal.entities.JobApplication;
import org.example.jobportal.models.JobApplicationDto;
import org.example.jobportal.projections.JobApplicationProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    @Query("SELECT j.id AS id, j.user.id AS userId, j.job.id AS jobId FROM job_applications j WHERE j.id = :id")
    JobApplicationProjection findProjectedById(@Param("id") Long id);

    @Query("SELECT new org.example.jobportal.models.JobApplicationDto(j.id, j.user.id, j.job.id) FROM job_applications j")
    List<JobApplicationDto> findAllJobApplications();
}