package com.kraft.event.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class SponsorFestivalTypeModel {
    private List<Long> sponsorIds;
    private Long festivalTypeId;
}
