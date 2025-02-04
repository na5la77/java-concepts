package org.example.jobportal.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "job_applications")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    public JobApplication(User user, Job job) {
        this.user = user;
        this.job = job;
    }
}