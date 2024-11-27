package com.a10d.kraft.data.model;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"checkInAttendances", "checkOutAttendances","userLocations","space"})
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	
	@Enumerated(EnumType.STRING)
	private LocationType locationType;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "location",orphanRemoval = true)
	@JsonIgnore
	private List<UserLocation> userLocations;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "checkInLocation",orphanRemoval = true)
	@JsonBackReference
	private List<Attendance> checkInAttendances;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "checkOutLocation",orphanRemoval = true)
	@JsonBackReference
	private List<Attendance> checkOutAttendances;
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "space_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Space space;
	
	public void addUser(User user) {
		 var userLocation = new UserLocation(user, this);
		 this.userLocations.add(userLocation);
		 user.getUserLocations().add(userLocation);
	}
	
	public void removeUser(User user) {
		for(Iterator<UserLocation> iterator = userLocations.iterator();iterator.hasNext();) {
			var userLocation = iterator.next();
			if(userLocation.getLocation().equals(this) && userLocation.getUser().equals(user)) {
				iterator.remove();
				userLocation.getUser().getUserLocations().remove(userLocation);
				userLocation.setUser(null);
				userLocation.setLocation(null);
			}
		}
	}
	
	
	
	
}
