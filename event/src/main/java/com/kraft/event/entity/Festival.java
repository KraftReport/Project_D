package com.example.msppj.entity;

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
public class Festival extends BaseEntity{

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
    private boolean isDeleted;
}