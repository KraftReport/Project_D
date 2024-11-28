package com.a10d.kraft.service;

import org.springframework.stereotype.Service;

import com.a10d.kraft.data.dto.LocationCreateRequestDTO;
import com.a10d.kraft.data.model.Location;
import com.a10d.kraft.data.repository.LocationRepository;
import com.a10d.kraft.service.helper.Helper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

	private final Helper helper;
	private final LocationRepository locationRepository;

	@Override
	public boolean createLocation(LocationCreateRequestDTO locationCreateRequestDTO) {
		var location = helper.mapDtoForEntityCreation(locationCreateRequestDTO, new Location());
		return helper.checkExceptionForRepositoryOperations(()->locationRepository.save(location)!=null); 
	}

}
