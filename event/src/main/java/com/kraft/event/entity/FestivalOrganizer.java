package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_organizer")
@Setter
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
@Builder
public class FestivalOrganizer extends BaseEntity {


    private Long festivalId;
    private Long organizerId;
    private Long orderColumn;
    private Long festivalTypeId;
}
