package com.kraft.event.entity;


import com.kraft.event.entity.enums.TOKEN_TYPE;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String token;
    @Enumerated(EnumType.STRING)
    private TOKEN_TYPE tokenType = TOKEN_TYPE.BEARER;
    private boolean isRevoked;
    private boolean isExpired;
    private Long applicationUserId;
}
