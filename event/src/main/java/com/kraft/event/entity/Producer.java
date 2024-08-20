package com.kraft.event.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producer")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Producer extends BaseEntity{

    private String myanmarName;
    private String englishName;
    private String otherName;
    @Column(length = 255)
    private String description;
    private String email;
    private String address;
    private Long companyId;
    private String contactPhone;
}
