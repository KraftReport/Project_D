package com.kraft.event.entity;

import jakarta.persistence.Entity;
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
    private Long id;
    private String name;
}
