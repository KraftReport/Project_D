package com.kraft.event.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "festival")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Festival extends BaseEntity{
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
    private String termAndConditionId;
}
