package com.a10d.kraft.service;

import org.springframework.stereotype.Service;

import com.a10d.kraft.data.dto.UserCreateRequestDTO;
import com.a10d.kraft.data.model.Space;
import com.a10d.kraft.data.model.User;
import com.a10d.kraft.data.repository.SpaceRepository;
import com.a10d.kraft.data.repository.UserRepository;
import com.a10d.kraft.service.helper.Helper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final SpaceRepository spaceRepository;
	private final UserRepository userRepository;
	private final Helper helper;

	@Override
	public boolean createUser(UserCreateRequestDTO userCreateRequestDTO) { 
		return helper
				.checkExceptionForRepositoryOperations
				(()->userRepository.save(helper.mapDtoForEntityCreation(userCreateRequestDTO,new User()))!=null);
	}

	@Override
	public boolean addUserIntoASpace(Long spaceId, Long userId) {
		var user = userRepository.findById(userId).orElse(null);
		Space space = spaceRepository.findById(spaceId).orElse(null);
		user.setSpace(space);
		return helper.checkExceptionForRepositoryOperations(()->userRepository.save(user)!=null);
	}
 
 

}
