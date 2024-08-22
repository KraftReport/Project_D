package com.kraft.event.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile photo;
    private String photoUrl;
    private boolean isHidden;
    private List<ArtistFestivalTypeModel> artistFestivalTypeModels;
    private List<OrganizerFestivalTypeModel> organizerFestivalTypeModels;
    private List<SponsorFestivalTypeModel> sponsorFestivalTypeModels;
}
