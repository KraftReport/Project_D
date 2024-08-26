package com.kraft.event.mapper.festival;

import com.kraft.event.DTO.FestivalRequestModal;
import com.kraft.event.entity.Festival;
import com.kraft.event.service.helper.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FestivalMapper {

    private final FileUploadService fileUploadService;

    public  Festival fromDTOToFestivalEntity(FestivalRequestModal festivalRequestModal){
        return Festival.builder()
                .name(festivalRequestModal.getName())
                .shortName(festivalRequestModal.getShortName())
                .location(festivalRequestModal.getLocation())
                .showTime(LocalDateTime.now())
                .warningMessage(festivalRequestModal.getWarningMessage())
                .startDate(festivalRequestModal.getStartDate())
                .endDate(festivalRequestModal.getEndDate())
                .photo(fileUploadService.uploadFile.apply(festivalRequestModal.getPhoto()))
                .isHidden(festivalRequestModal.isHidden())
                .termAndConditionId(festivalRequestModal.getTermAndConditionId())
                .build();
    }
}