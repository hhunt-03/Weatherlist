package com.hunt.weatherlist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.User;
import com.hunt.weatherlist.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private WeatherService weatherService;

	public Location findById(String id){
		return locationRepository.findById(id).orElse(null);
	}
	
	public Location findByLongitudeAndLatitude(String longitude, String latitude) {
		return weatherService.getLocation(longitude, latitude);
		
	}

	public List<Location> findByUser(User user) {
		return locationRepository.findByUser(user);
	}
	
	public Location save(Location location) {
		List<Location> savedLocations = findByUser(location.getUser());
		for( Location savedLocation : savedLocations) {
				if(savedLocation.equals(location)) {
					return location;
				}
		}
		return locationRepository.save(location);
	}
	
	public boolean deleteLocationFromLocations(String locationid) {
		Location location = findById(locationid);
		if( location != null) {		
			locationRepository.delete(location);
			return true;
		}
		return false;
	}
}
