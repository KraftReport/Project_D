package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_ownership")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalOwnership extends BaseEntity{

    private Long festivalId;
    private Long organizerId;
    private Long orderColumn;
    private Long festivalTypeId;
}
