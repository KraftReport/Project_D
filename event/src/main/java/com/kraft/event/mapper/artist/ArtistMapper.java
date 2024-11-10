package com.kraft.event.mapper.artist;

import com.kraft.event.DTO.ArtistDTO;
import com.kraft.event.entity.Artist;
import com.kraft.event.service.helper.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArtistMapper {
    private final FileUploadService fileUploadService;

    public Artist fromDTOToArtistEntity(ArtistDTO artistDTO) {
        return Artist.builder()
                .name(artistDTO.getArtistName())
                .photo(fileUploadService.uploadFile.apply(artistDTO.getArtistPhoto()))
                .build();
    }
}
