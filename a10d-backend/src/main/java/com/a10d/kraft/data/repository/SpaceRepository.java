package com.a10d.kraft.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a10d.kraft.data.model.Space;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Long> {

	
}
