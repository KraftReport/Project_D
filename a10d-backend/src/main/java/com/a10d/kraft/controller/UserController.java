package com.a10d.kraft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.a10d.kraft.data.dto.UserCreateRequestDTO;
import com.a10d.kraft.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<?> createUser(@RequestBody UserCreateRequestDTO userCreateRequestDTO){
		return ResponseEntity.ok(userService.createUser(userCreateRequestDTO));
	}

}
