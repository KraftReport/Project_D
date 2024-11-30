package com.a10d.kraft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a10d.kraft.data.dto.LocationCreateRequestDTO;
import com.a10d.kraft.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
	
	private final LocationService locationService;
	 
	@PostMapping("/create-location")
	public ResponseEntity<?> createLocation(@RequestBody LocationCreateRequestDTO locationCreateRequestDTO){
		return ResponseEntity.ok(locationService.createLocation(locationCreateRequestDTO));
	}
}
