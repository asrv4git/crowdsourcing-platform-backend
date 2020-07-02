package com.github.crowdsourcingplatformapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {

    @NotNull
    private String title;
    @NotNull
    private LocalDate createdAt;
    @NotNull
    private LocalDate deadline;
    @NotNull
    private Integer rewardPoints;
    @NotNull
    private Boolean isActive;
    @NotNull
    private List<String> skills;
    @Autowired
    @NotNull
    private Map<String, String> taskDescription;
    @NotNull
    private Integer timeToComplete;
    //    taskId
    private UUID id;
    //  user who created this task
    private UUID userId;
    private TaskStatus status;
    //  Comes from UserRegistration table (latest entry for this task)
    private UUID currentWorkerId;

    public enum TaskStatus {
        Idle, InProgress, AvaitingReview, Finished
    }
}
