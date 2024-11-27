package com.a10d.kraft.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.a10d.kraft.data.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
