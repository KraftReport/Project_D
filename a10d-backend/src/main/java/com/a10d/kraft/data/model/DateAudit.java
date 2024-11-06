package com.a10d.kraft.data.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate","lastModifiedDate"},allowGetters = true)
@Getter
@Setter
public class DateAudit implements Serializable {

	@CreatedDate
	@Column(nullable = false,updatable = false)
	private LocalDateTime createdDate;
	@LastModifiedDate
	@Column(nullable = false)
	private LocalDateTime lastModifiedDate;
}
