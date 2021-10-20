package com.locationweb1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locationweb1.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
