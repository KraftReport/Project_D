package com.kraft.event.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "organizer")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Organizer extends BaseEntity {

    private String name;
    private String email;
    private String photo;
    private String phone;
    private String type;
}
