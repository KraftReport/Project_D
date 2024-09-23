package com.kraft.event.service.artist;

import com.kraft.event.DTO.APIResponseDTO;
import com.kraft.event.DTO.ArtistDTO;
import com.kraft.event.mapper.artist.ArtistMapper;
import com.kraft.event.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArtistServiceImpl implements ArtistService{
    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;
    @Override
    public APIResponseDTO addNewArtist(ArtistDTO artistDTO) {
        return APIResponseDTO.builder()
                .data(artistRepository.searchArtistById(artistRepository.addArtistToDatabase(artistMapper.fromDTOToArtistEntity(artistDTO))))
                .build();
    }
}
