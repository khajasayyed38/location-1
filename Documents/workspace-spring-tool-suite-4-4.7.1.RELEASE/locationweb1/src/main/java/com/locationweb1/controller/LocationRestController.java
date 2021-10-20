package com.locationweb1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locationweb1.entity.Location;
import com.locationweb1.repositories.LocationRepository;

@RestController
public class LocationRestController {
	
	@Autowired
	private LocationRepository locationRepo;
	
	@RequestMapping("/location/{id}")
	public Location GetLocation(@PathVariable("id") long id) {
		Optional<Location> findById = locationRepo.findById(id);
		Location location = findById.get();
		return location;
	}
}
