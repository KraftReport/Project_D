package com.a10d.kraft.data.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Location extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(precision = 11,scale = 8)
	private BigDecimal lattitude;
	@Column(precision = 20,scale = 8)
	private BigDecimal longitude;
	private int radius;
	private boolean isActive;
	private boolean notiStatus;
	
}
