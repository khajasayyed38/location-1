package com.locationweb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locationweb1.entity.Location;
import com.locationweb1.repositories.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController1 {
	
	@Autowired
	private LocationRepository locationRepo;
	
	@GetMapping
	public List<Location> getLocations() {
		List<Location>  location = locationRepo.findAll();
		return location;
	}
	
	@PostMapping
	public void saveLocation(@RequestBody Location location) {
		locationRepo.save(location);
	}
	
	@PutMapping
	public void updateLocation(@RequestBody Location location) {
		locationRepo.save(location);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLocation(@PathVariable("id") long id) {
		locationRepo.deleteById(id);
	}
}
