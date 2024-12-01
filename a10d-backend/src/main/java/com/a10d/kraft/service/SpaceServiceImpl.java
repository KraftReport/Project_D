package com.a10d.kraft.service;

import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.a10d.kraft.data.model.Space;
import com.a10d.kraft.data.model.User;
import com.a10d.kraft.data.repository.SpaceRepository;
import com.a10d.kraft.service.helper.Helper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {
	
	private final SpaceRepository spaceRepository;
	private final Helper helper;

	@Override
	public boolean createSpace(String spaceName) {
		var space = Space.builder().name(spaceName)
				.isActive(true).build();
		return helper.checkExceptionForRepositoryOperations(() -> 
		spaceRepository.save(space) != null);
	}
 
 

}
