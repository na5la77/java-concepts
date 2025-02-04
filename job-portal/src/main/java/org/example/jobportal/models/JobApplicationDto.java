package org.example.jobportal.models;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobApplicationDto {
    private Long id;
    @NotNull(message = "UserID cannot be empty")
    private Long userId;
    @NotNull(message = "JobID cannot be empty")
    private Long jobId;


}

