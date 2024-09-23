package com.kraft.event.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class APIRequestDTO {
    private String description;
    private ArtistDTO data;
}
