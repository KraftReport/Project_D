package com.a10d.kraft.data.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ConfirmationToken extends DateAudit{

	private static final int EXPIRATION = 60 * 24;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String token;
	private LocalDateTime expireDateTime;
	
	@OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false,name = "user_id" )
	private User user;
	
	public ConfirmationToken(User user) {
		this.user = user;
		this.token = UUID.randomUUID().toString();
		this.expireDateTime = LocalDateTime.now().plusMinutes(EXPIRATION);
	}
	
	public ConfirmationToken extendExpiryTime() {
		this.token = UUID.randomUUID().toString();
		this.setExpireDateTime(LocalDateTime.now().plusMinutes(EXPIRATION)); 
		return this;
	}
}
