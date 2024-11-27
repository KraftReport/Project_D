package com.a10d.kraft.data.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@Entity
@ToString(exclude = {"users","locations","teams"})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Space extends DateAudit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private boolean isActive;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "space")
	@JsonIgnore
	private List<User> users;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "space")
	@JsonIgnore
	private List<Location> locations;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "space")
	@JsonIgnore
	private List<Team> teams;
}
