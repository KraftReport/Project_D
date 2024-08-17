package com.kraft.event.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.User;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long createdUserId;
    private Long updatedUserId;
    private boolean isDeleted;
}
