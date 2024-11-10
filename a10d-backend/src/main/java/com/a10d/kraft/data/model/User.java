package com.a10d.kraft.data.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class User extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String staffId;
	private boolean isActive;
	private boolean isDelete;
	private boolean notiStatus;
	private LocalDateTime registerationDate;
	private boolean isFirstTimeLogin;
	private boolean isDeviceRegistered;
}
