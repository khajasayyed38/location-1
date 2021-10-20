package com.locationweb1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb1.dto.GetLocationData;
import com.locationweb1.entity.Location;
import com.locationweb1.services.LocationService;
import com.locationweb1.util.Email;

@Controller
public class locationController {
	
	@Autowired
	private Email email;

	@Autowired
	private LocationService locationService;

	@RequestMapping("/showlocation")
	public String showLocationPage() {
		return "saveLocation";
	}

 	@RequestMapping("/saveLocation")
	public String getLocationData(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.saveLocation(location);
		email.sendEmail("khajasayyed10@gmail.com", "Location saved", "Congratulation location details is saved");
		modelMap.addAttribute("msg", "Location is saved!!!");
		return "saveLocation";
	} 
	
 	@RequestMapping("/getalllocations")
 	public String getAllLocations(ModelMap modelMap) {
 		List<Location> locations = locationService.getLocations();
 		modelMap.addAttribute("locations", locations);
 		return "displayLocations";
 	}
 	
 	@RequestMapping("/deleteReg")
 	public String deleteRegistration(@RequestParam("id") long id,ModelMap modelMap) {
 		locationService.deleteregistrationById(id);
 		List<Location> locations = locationService.getLocations();
 		modelMap.addAttribute("locations", locations);
 		return "displayLocations";
 	}
	@RequestMapping("/updateReg")
 	public String updateRegistration(@RequestParam("id") long id, ModelMap modelMap) {
		Location location = locationService.getregistrationById(id);
		modelMap.addAttribute("location", location);
 		return "updateLocation";
 	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(GetLocationData locationdata, ModelMap modelMap) {
		Location location = new Location();
		location.setId(locationdata.getId());
		location.setCode(locationdata.getCode());
		location.setName(locationdata.getName());
		location.setType(locationdata.getType());
		locationService.updateLocation(location);
		List<Location> locations = locationService.getLocations();
 		modelMap.addAttribute("locations", locations);
 		return "displayLocations";
	}
}
