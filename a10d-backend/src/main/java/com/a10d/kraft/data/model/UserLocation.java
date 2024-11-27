package com.a10d.kraft.data.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
public class UserLocation {
	
	@EmbeddedId
	private UserLocationId id;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userId")
	private User user;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("locationId")
	private Location location;
	
	public UserLocation(User user,Location location) {
		this.user = user;
		this.location = location;
		this.id = new UserLocationId(user.getId(),location.getId());
	}
	
	

}
