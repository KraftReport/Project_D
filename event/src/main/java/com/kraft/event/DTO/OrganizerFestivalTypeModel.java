package com.kraft.event.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class OrganizerFestivalTypeModel {
    private List<Long> organizerIds;
    private Long festivalTypeId;
}
