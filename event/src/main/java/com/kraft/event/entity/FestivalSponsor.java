package com.kraft.event.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_sponsor")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalSponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long festivalId;
    private Long sponsorId;
    private Long orderColumn;
    private Long festivalTypeId;
}
