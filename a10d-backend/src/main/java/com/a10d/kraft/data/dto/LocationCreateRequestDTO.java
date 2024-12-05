package com.a10d.kraft.data.dto;

import java.math.BigDecimal;

import com.a10d.kraft.data.model.LocationType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class LocationCreateRequestDTO {
 
	private String name; 
	private BigDecimal lattitude; 
	private BigDecimal longitude;
	private int radius;
	private boolean isActive;
	private boolean notiStatus; 
	private LocationType locationType;
}
