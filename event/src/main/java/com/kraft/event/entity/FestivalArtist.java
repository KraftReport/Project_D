package com.kraft.event.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_artist")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long festivalId;
    private Long artistId;
    private Long festivalTypeId;
    private Long orderColumn;
}
