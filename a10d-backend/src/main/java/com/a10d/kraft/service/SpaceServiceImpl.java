package com.a10d.kraft.service;

import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.a10d.kraft.data.model.Space;
import com.a10d.kraft.data.repository.SpaceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpaceServiceImpl implements SpaceService {
	
	private final SpaceRepository spaceRepository;
	private final Helper helper;

	@Override
	public boolean createSpace(String spaceName) {
		return helper.checkExceptionForRepositoryOperations(() -> 
		spaceRepository.save(Space.builder().name(spaceName).build()) != null);
	}
 

}
