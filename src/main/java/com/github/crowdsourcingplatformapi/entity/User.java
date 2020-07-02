package com.github.crowdsourcingplatformapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "App_User")
//table name "user" is not allowed in postgres
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(name = "user_name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "user_email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    //    Current point balance of the user
    @Column(name = "points")
    private int points;

    @ElementCollection
    @Column(name = "skills")
    @NotEmpty
    private List<String> skills = new ArrayList();

}
