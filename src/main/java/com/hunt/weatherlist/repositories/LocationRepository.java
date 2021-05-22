package com.hunt.weatherlist.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.User;

@Repository
public interface LocationRepository extends MongoRepository<Location, String>{
	List<Location> findByUser(User user);
	Location findByLongitudeAndLatitude(String longitude, String latitude);	
}
