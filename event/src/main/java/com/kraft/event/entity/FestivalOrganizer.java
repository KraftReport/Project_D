package com.kraft.event.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_organizer")
@Setter
@AllArgsConstructor
@Getter
@RequiredArgsConstructor
@Builder
public class FestivalOrganizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long festivalId;
    private Long organizerId;
    private Long orderColumn;
    private Long festivalTypeId;
}
