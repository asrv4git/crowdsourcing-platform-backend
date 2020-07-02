package com.github.crowdsourcingplatformapi.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Data
public class TaskUpdateRequest {
    private String title;
    private LocalDate createdAt;
    private LocalDate deadline;
    private Integer rewardPoints;
    private Boolean isActive;
    private List<String> skills;
    private Map<String, String> taskDescription;
    private Integer timeToComplete;
}
