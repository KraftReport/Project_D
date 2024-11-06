package com.a10d.kraft.data.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AttendanceHistory extends DateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String locationName;
	@Column(precision = 10,scale = 8)   
	private BigDecimal lattitude;
	@Column(precision = 11,scale = 8)
	private BigDecimal longitude;
	private String description;
	private LocalDateTime time;
}
