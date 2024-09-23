package com.kraft.event.DTO;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class ArtistDTO {
    private String artistName;
    private MultipartFile artistPhoto;
}
