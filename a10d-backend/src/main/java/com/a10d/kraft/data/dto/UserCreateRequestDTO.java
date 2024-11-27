package com.a10d.kraft.data.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserCreateRequestDTO {

	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String staffId;      
}
