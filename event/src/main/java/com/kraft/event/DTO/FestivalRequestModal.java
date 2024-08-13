package com.kraft.event.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalRequestModal {
    private Long id;
    private String name;
    private String shortName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String location;
    private String showTime;
    private Long termAndConditionId;
    private String festivalPhotoName;
    private String warningMessage;
    private List<ArtistFestivalTypeModel> artistFestivalTypeModels;
    private List<OrganizerFestivalTypeModel> organizerFestivalTypeModels;
    private List<SponsorFestivalTypeModel> sponsorFestivalTypeModels;
}
