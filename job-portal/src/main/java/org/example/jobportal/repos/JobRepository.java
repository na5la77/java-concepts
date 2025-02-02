package org.example.jobportal.repos;

import org.example.jobportal.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyIgnoreCase(String company);
}
