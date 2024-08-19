package com.example.msppj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "ticket_role")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class TicketRole extends BaseEntity{

    private String name;
}
