package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.catalina.User;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public abstract class BaseEntity {

    @Id
    @SequenceGenerator(name = "primary_key_seq",sequenceName = "primary_key_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "primary_key_seq")
    @Column(name = "id",updatable = false)
    private Long id;

    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdDate;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime updatedDate;

    private Long createdUserId;
    private Long updatedUserId;
    private boolean isDeleted;

    @PrePersist
    public void beforePersist(){
        setCreatedDate(LocalDateTime.now());
        setUpdatedDate(LocalDateTime.now());
    }

    @PreUpdate
    public void beforeUpdate(){
        setUpdatedDate(LocalDateTime.now());
    }
}
