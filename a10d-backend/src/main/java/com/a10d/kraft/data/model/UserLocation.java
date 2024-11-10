package com.a10d.kraft.data.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class UserLocation {
	
	@EmbeddedId
	private UserLocationId id;

}
