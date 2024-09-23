package com.kraft.event.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class SponsorFestivalTypeDTO {
    private List<Long> sponsorIds;
    private Long festivalTypeId;
}
