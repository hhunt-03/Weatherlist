package com.hunt.weatherlist.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.User;

@Repository 
public interface UserRepository extends MongoRepository<User, String>{
	Optional<User> findById(String id);
	Optional<User> findByFirstName(String firstName);
	Optional<User> findByUsername(String username);
	User getByUsername(String username);
}
