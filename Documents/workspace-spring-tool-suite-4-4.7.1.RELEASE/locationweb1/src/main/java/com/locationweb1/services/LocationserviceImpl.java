package com.locationweb1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationweb1.entity.Location;
import com.locationweb1.repositories.LocationRepository;

@Service
public class LocationserviceImpl implements LocationService {

	
	@Autowired
	private LocationRepository locationRepo;
	
	
	
	@Override
	public void saveLocation(Location location) {
		locationRepo.save(location);

	}



	@Override
	public List<Location> getLocations() {
		List<Location> locations = locationRepo.findAll();
		return locations;
	}


	@Override
	public void deleteregistrationById(long id) {
		locationRepo.deleteById(id);
		
	}



	@Override
	public Location getregistrationById(long id) {
		Location location = locationRepo.getById(id);
		return location;
		
	}



	@Override
	public void updateLocation(Location location) {
		locationRepo.save(location);
		
	}

}
