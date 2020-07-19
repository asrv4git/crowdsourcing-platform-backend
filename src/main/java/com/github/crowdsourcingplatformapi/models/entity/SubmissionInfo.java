package com.github.crowdsourcingplatformapi.models.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Submission_Info")
public class SubmissionInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "submission_id", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "user_id")
    @NotBlank
    private UUID userId;

    @Column(name = "task_id")
    @NotBlank
    private UUID taskId;
    //    Comments added by the submitter
    @Column(name = "comments", columnDefinition = "text")
    @NotEmpty
    private String comments;

    @Column(name = "submission_status")
    @Enumerated(EnumType.STRING)
    @NotNull
    private SubmissionStatus submissionStatus;

    @Column(name = "submission_created_at")
    @NotNull
    private LocalDate createdAt;

    //    Review submitted by the requester
    @Column(name = "review", columnDefinition = "text")
    @NotEmpty
    private String review;

    public enum SubmissionStatus {
        AvaitingReview, Accepted, Rejected
    }

}
