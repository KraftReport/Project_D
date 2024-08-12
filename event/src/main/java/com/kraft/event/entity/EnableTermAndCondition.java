package com.kraft.event.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "enable_term_and_condition")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class EnableTermAndCondition {
    private Long festivalId;
    private Long applicationUserId;
    private boolean isEnable;
}
