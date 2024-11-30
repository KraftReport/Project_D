package com.a10d.kraft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a10d.kraft.data.dto.SpaceCreateRequestDTO;
import com.a10d.kraft.service.SpaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/space")
public class SpaceController {
	
	private final SpaceService spaceService;
	
	@PostMapping("/create-space")
	public ResponseEntity<?> createSpace(@RequestBody String name){
		return ResponseEntity.ok(spaceService.createSpace(name));
	}

}
