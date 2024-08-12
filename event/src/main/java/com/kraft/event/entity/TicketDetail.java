package com.kraft.event.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_detail")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class TicketDetail {
    private Long id;
    private Long goldPlate;
    private Long silverPlate;
    private Long countLimit;
    private Long buyCount;
    private LocalDateTime date;
    private boolean isDeleted;
    private Long collaborationFestivalId;
    private String description;
    private Long ticketId;
}
