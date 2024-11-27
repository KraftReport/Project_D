package com.a10d.kraft.data.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = {"teamMembers"})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Team extends DateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "space_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Space space;
	
	@OneToMany(mappedBy = "team",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = false)
	@JsonIgnore
	private List<TeamMember> teamMembers;
}
