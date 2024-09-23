package com.kraft.event.service.artist;

import com.kraft.event.DTO.APIResponseDTO;
import com.kraft.event.DTO.ArtistDTO;

public interface ArtistService {
    public APIResponseDTO addNewArtist(ArtistDTO artistDTO);
}
