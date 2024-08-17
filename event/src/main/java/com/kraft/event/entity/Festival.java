package com.kraft.event.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@Entity
@Table(name = "festival")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Festival {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String shortName;
    private String photo;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime showTime;
    private String warningMessage;
    private boolean isHidden;
    private Long termAndConditionId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Long createdUserId;
    private Long updatedUserId;
    private boolean isDeleted;
}