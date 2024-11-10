package com.kraft.event.controller;

import com.kraft.event.DTO.APIRequestDTO;
import com.kraft.event.DTO.APIResponseDTO;
import com.kraft.event.service.artist.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/artist")
public class ArtistController {
    private final ArtistService artistService;

    @PostMapping("/createArtist")
    public ResponseEntity<APIResponseDTO> createArtist(@RequestBody APIRequestDTO apiRequestDTO){
        return ResponseEntity.ok(artistService.addNewArtist(apiRequestDTO.getData()));
    }
}
