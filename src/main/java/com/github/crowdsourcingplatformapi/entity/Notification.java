package com.github.crowdsourcingplatformapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Notification")
public class Notification {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "notif_id", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "user_id")
    @NotBlank
    private UUID userId;

    @Column(name = "message")
    private String message;

    @Column(name= "url")
    private URL Uri;

    @Column(name= "seen_status")
    private boolean seen;

    @Column(name= "created_at")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name= "type")
    private String type;

    @Column(name= "task_id")
    @NotBlank
    private UUID taskId;
}
