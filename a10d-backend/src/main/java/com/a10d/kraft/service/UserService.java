package com.a10d.kraft.service;

import com.a10d.kraft.data.dto.UserCreateRequestDTO;
import com.a10d.kraft.data.model.Space;

public interface UserService {

	 public boolean createUser(UserCreateRequestDTO userCreateRequestDTO);
	 public boolean addUserIntoASpace(Long spaceId,Long userId);
}
