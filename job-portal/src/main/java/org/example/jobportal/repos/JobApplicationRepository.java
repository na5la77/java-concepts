package org.example.jobportal.repos;

import org.example.jobportal.entities.JobApplication;
import org.example.jobportal.projections.JobApplicationProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplicationProjection> findAllProjectedBy();
}