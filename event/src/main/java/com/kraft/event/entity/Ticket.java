package com.example.msppj.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Ticket extends BaseEntity {

    private LocalDateTime saleStart;
    private LocalDateTime saleEnd;
    private String photo;
    private String description;
    private boolean isEarlyBird;
    private Long festivalId;
    private Long packageId;
    private Long ticketRoleId;
    private Long ticketTypeId;

}
