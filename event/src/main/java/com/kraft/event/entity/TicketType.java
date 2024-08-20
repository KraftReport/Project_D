package com.example.msppj.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ticket_type")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class TicketType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
