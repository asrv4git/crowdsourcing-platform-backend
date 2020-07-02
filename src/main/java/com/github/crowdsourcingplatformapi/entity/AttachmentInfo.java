package com.github.crowdsourcingplatformapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Attachment_Info")
public class AttachmentInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "attachment_id", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @Column(name = "attachment_name")
    @NotBlank(message = "Please provide a name for attachment")
    private String name;
    @Column(name = "attachment_type")
    @NotNull
    @Enumerated(EnumType.STRING)
    private AttachmentType attachmentType;

    public enum AttachmentType {
        File, URL
    }
}
