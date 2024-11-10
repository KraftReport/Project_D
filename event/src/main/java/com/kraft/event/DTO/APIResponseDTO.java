package com.kraft.event.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class APIResponseDTO {
    private String description;
    private Object data;
    private List<Object> dataList;
}
