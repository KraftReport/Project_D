package com.a10d.kraft.data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"space","userLocations","teams","attendances"})
@JsonIgnoreProperties({"hibernateLzayInitializer","hadler"})
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String staffId;
	private boolean isActive = true;
	private boolean isDelete = false;
	private boolean notiStatus = true;
	private LocalDateTime registerationDate;
	private boolean isFirstTimeLogin = true;
	private boolean isDeviceRegistered = true;
	
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "space_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Space space; 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<UserLocation> userLocations = new ArrayList<>(); 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TeamMember> teamMembers = new ArrayList<>(); 
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Attendance> attendances = new ArrayList<>();
    
    public void addLocation(Location location) {
    	var userLocation = new UserLocation(this, location);
    	userLocations.add(userLocation);
    	location.getUserLocations().add(userLocation);
    }
}
