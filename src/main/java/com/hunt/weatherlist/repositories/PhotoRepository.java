package com.hunt.weatherlist.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hunt.weatherlist.models.Photo;
import com.hunt.weatherlist.models.User;

public interface PhotoRepository extends MongoRepository<Photo, String> {
	public Photo findByOwner( String user );
}