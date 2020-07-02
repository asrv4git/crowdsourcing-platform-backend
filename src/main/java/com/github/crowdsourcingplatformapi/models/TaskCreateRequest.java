package com.github.crowdsourcingplatformapi.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class TaskCreateRequest {
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
    @NotNull
    private Map<String, String> taskDescription;
    @NotNull
    private Integer timeToComplete;
}
