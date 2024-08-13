package com.kraft.event.entity;

import jakarta.persistence.EntityListeners;
import lombok.*;
import org.apache.catalina.User;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdUserId;
    private String updatedUserId;
    private boolean isDeleted;
}
