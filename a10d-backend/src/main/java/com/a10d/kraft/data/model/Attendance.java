package com.a10d.kraft.data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@ToString(exclude = {"histories"})
public class Attendance extends DateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime checkInTime;
	private LocalDateTime checkOutTime;
	private Long workingMinute = 0L;
	
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "check_in_location_id",nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	private Location checkInLocation;
	@ManyToOne(fetch = FetchType.LAZY,optional = true)
	@JoinColumn(name = "check_out_location_id",nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	private Location checkOutLocation;
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<AttendanceHistory> attendanceHistories = new ArrayList<>();
	@ManyToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "user_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	private User user;
	
	
}
