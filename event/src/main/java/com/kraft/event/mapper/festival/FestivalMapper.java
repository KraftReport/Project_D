package com.kraft.event.mapper.festival;

import com.kraft.event.DTO.FestivalRequestDTO;
import com.kraft.event.entity.Festival;
import com.kraft.event.service.helper.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FestivalMapper {

    private final FileUploadService fileUploadService;

    public  Festival fromDTOToFestivalEntity(FestivalRequestDTO festivalRequestDTO){
        return Festival.builder()
                .name(festivalRequestDTO.getName())
                .shortName(festivalRequestDTO.getShortName())
                .location(festivalRequestDTO.getLocation())
                .showTime(LocalDateTime.now())
                .warningMessage(festivalRequestDTO.getWarningMessage())
                .startDate(festivalRequestDTO.getStartDate())
                .endDate(festivalRequestDTO.getEndDate())
                .photo(fileUploadService.uploadFile.apply(festivalRequestDTO.getPhoto()))
                .isHidden(festivalRequestDTO.isHidden())
                .termAndConditionId(festivalRequestDTO.getTermAndConditionId())
                .build();
    }
}