package com.kraft.event.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class OrganizerFestivalTypeDTO {
    private List<Long> organizerIds;
    private Long festivalTypeId;
}
