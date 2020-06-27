package com.github.crowdsourcingplatformapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Min;
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
