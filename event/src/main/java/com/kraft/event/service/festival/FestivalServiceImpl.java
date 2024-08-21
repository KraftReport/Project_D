package com.kraft.event.service.festival;

import com.kraft.event.DTO.FestivalRequestModal;
import com.kraft.event.entity.Festival;
import com.kraft.event.mapper.festival.FestivalMapper;
import com.kraft.event.mapper.festival.FestivalRowMapper;
import com.kraft.event.repository.FestivalRepository;
import com.kraft.event.service.audit.AuditorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FestivalServiceImpl implements FestivalService {

    private final FestivalMapper festivalMapper;
    private final FestivalRowMapper festivalRowMapper;
    private final FestivalRepository festivalRepository;
    private final AuditorService auditorService;

    @Override
    public boolean saveFestival(FestivalRequestModal festivalRequestModal) {
        return festivalRepository.createFestival(festivalMapper.toFestivalEntity(festivalRequestModal));
    }
}
