package com.kraft.event.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ArtistFestivalTypeModel {
    private List<Long> artistIds;
    private Long festivalTypeId;
}
