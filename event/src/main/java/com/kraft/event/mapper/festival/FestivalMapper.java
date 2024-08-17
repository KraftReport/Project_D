package com.kraft.event.mapper.festival;

import com.kraft.event.DTO.FestivalRequestModal;
import com.kraft.event.entity.Festival;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface FestivalMapper {
    FestivalMapper INSTANCE = Mappers.getMapper(FestivalMapper.class);

    Festival toFestivalEntity(FestivalRequestModal dto);
    FestivalRequestModal toFestivalDTO(Festival entity);
}