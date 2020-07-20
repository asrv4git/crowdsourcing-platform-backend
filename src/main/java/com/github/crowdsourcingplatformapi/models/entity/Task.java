package com.github.crowdsourcingplatformapi.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Task")
public class Task {

    //    taskId
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "task_id", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

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
    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "skills")
    private List<String> skills;

    @ElementCollection
    @CollectionTable(name="task_description", joinColumns=@JoinColumn(name="task_id"))
    @MapKeyColumn(name="description_key")
    @Column(name="description_value")
    private Map<String, String> taskDescription = new LinkedHashMap<>();

    @NotNull
    private Integer timeToComplete;

    //  user who created this task
    @NotNull
    private UUID userId;

    @NotNull
    private TaskStatus status;

    //  Comes from UserRegistration table (latest entry for this task)
    private UUID currentWorkerId;

    public enum TaskStatus {
        Idle, InProgress, AwaitingReview, Finished
    }
}
