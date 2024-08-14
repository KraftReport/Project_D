package com.kraft.event.entity;

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
@NoArgsConstructor
@SuperBuilder
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long createdUserId;
    private Long updatedUserId;
    private boolean isDeleted;
    protected BaseEntity(LocalDateTime createdDate, LocalDateTime updatedDate, Long createdUserId, Long updatedUserId, boolean isDeleted) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.createdUserId = createdUserId;
        this.updatedUserId = updatedUserId;
        this.isDeleted = isDeleted;
    }
}
