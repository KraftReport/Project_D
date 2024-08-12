package com.kraft.event.entity;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String type;
}
