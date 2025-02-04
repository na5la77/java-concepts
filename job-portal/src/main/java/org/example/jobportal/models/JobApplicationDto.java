package org.example.jobportal.models;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDto {
    private Long id;
    @NotBlank(message = "UserID cannot be empty")
    private Long userId;
    @NotBlank(message = "JobID cannot be empty")
    private Long jobId;
}

