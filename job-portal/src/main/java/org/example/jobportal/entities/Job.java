package org.example.jobportal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "jobs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String description;

    @ManyToOne
    @JoinColumn(name = "created_by", nullable = false)
    private User createdBy;
}

