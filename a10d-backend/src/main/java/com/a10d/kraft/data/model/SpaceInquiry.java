package com.a10d.kraft.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SpaceInquiry extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String spaceName;
	private String userName;
	private String email;
	private String phoneNo;
	private String password;
	private boolean isApproved;
}
