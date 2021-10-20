package com.locationweb1.services;

import java.util.List;

import com.locationweb1.entity.Location;

public interface LocationService {
	public void saveLocation(Location location);
	public List<Location> getLocations();
	public void deleteregistrationById(long id);
	public Location getregistrationById(long id);
	public void updateLocation(Location location);

}
