package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festival_artist")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalArtist extends BaseEntity {

    private Long festivalId;
    private Long artistId;
    private Long festivalTypeId;
    private Long orderColumn;
}
