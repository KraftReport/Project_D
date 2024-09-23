package com.kraft.event.service.festival;

import com.kraft.event.DTO.FestivalRequestDTO;
import com.kraft.event.mapper.festival.FestivalMapper;
import com.kraft.event.mapper.festival.FestivalRowMapper;
import com.kraft.event.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FestivalServiceImpl implements FestivalService {

    private final FestivalMapper festivalMapper;
    private final FestivalRowMapper festivalRowMapper;
    private final FestivalRepository festivalRepository; 

    @Override
    public boolean saveFestival(FestivalRequestDTO festivalRequestDTO) {
        return festivalRepository.createFestival(festivalMapper.fromDTOToFestivalEntity(festivalRequestDTO));
    }
}
