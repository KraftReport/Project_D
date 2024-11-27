package com.a10d.kraft.data.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor

public class RefreshToken extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String token;
	
	@OneToOne(fetch = FetchType.LAZY,targetEntity = User.class)
	@JoinColumn(nullable = false,name = "user_id")
	private User user;
	private LocalDateTime expireTime;
	
	public RefreshToken(User user) {
		this.user = user;
		token = UUID.randomUUID().toString();
		expireTime = LocalDateTime.now().plusMinutes(10);
	}
}
