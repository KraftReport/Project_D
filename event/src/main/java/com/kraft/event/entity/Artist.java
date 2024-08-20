package com.kraft.event.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "artist")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Artist extends BaseEntity{


    private String name;
    private String photo;
}
