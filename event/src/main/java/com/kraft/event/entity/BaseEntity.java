package com.kraft.event.entity;

import org.apache.catalina.User;

import java.time.LocalDateTime;

public class BaseEntity {
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String createdUserId;
    private String updatedUserId;
    private boolean isDeleted;
}
