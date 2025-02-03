package org.example.jobportal.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDto {
    private Long id;
    private String jobTitle;
    private String companyName;
    private String jobDescription;
}
