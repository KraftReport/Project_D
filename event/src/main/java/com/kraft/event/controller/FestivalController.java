package com.kraft.event.controller;

import com.kraft.event.DTO.FestivalRequestDTO;
import com.kraft.event.service.festival.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/festival")
public class FestivalController {
    private final FestivalService festivalService;

    @PostMapping("/createNewFestival")
    public ResponseEntity<Boolean> createNewFestival(@RequestBody FestivalRequestDTO festivalRequestDTO){
        return ResponseEntity.ok(festivalService.saveFestival(festivalRequestDTO));
    }
}
