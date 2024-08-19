package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "festival_registration")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class FestivalRegistration extends BaseEntity {

    private Long serialNumber;
    private String buyerName;
    private String buyerContact;
    private String qrCode;
    private LocalDateTime buyDate;
    private String plateType;
    private Long ticketId;
    private Long ticketDetailId;
    private Long buyerId;
    private Long ticketPrice;
    private Long festivalId;
}
