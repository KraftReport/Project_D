package com.a10d.kraft.service;

import org.springframework.stereotype.Service;

import com.a10d.kraft.data.dto.UserCreateRequestDTO;
import com.a10d.kraft.data.model.User;
import com.a10d.kraft.data.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	private final Helper helper;

	@Override
	public boolean createUser(UserCreateRequestDTO userCreateRequestDTO) {
		return helper
				.checkExceptionForRepositoryOperations
				(()->userRepository.save(mapUserForEntityCreation(userCreateRequestDTO))!=null);
	}
	
	private User mapUserForEntityCreation(UserCreateRequestDTO userCreateRequestDTO) {
		return User.builder()
				.name(userCreateRequestDTO.getName())
				.email(userCreateRequestDTO.getEmail())
				.password(userCreateRequestDTO.getPassword())
				.staffId(userCreateRequestDTO.getStaffId())
				.phoneNumber(userCreateRequestDTO.getPhoneNumber())
				.build();
	}

}
