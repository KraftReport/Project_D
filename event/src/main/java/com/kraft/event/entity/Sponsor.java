package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sponsor")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Sponsor extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private String type;
}
