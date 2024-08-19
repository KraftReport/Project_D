package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_sponsor")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalSponsor extends BaseEntity {

    private Long festivalId;
    private Long sponsorId;
    private Long orderColumn;
    private Long festivalTypeId;
}
