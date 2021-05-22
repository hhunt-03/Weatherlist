package com.hunt.weatherlist.services;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.Photo;
import com.hunt.weatherlist.models.User;
import com.hunt.weatherlist.repositories.PhotoRepository;
import com.hunt.weatherlist.repositories.UserRepository;

import org.apache.commons.io.FilenameUtils;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PhotoRepository photoRepository;
		
	public User findUserById(String id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userRepository
				.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));	
		
		System.out.println(user.toString());
		return user;
	}
	
	private static String imageType( String filename ) throws IllegalArgumentException {
		String extension = FilenameUtils.getExtension( filename ).toUpperCase();
		
		switch(extension) {
		case "PNG": 
		case "JPEG":
		case "JPG":
		case "GIF":	return extension;
		}
		
		throw new IllegalArgumentException();
	}
	
	 public Photo getPhoto(User user) {
	        return photoRepository.findByOwner( user.getId() );
	  }
	
	public User setPhoto(User user, MultipartFile file) throws IOException, IllegalArgumentException {
		String type = imageType( file.getOriginalFilename());	
        Photo photo = new Photo.Builder()
        		.owner( user.getId() )
        		.type(type)
        		.image(new Binary(BsonBinarySubType.BINARY, file.getBytes()))
        		.build();
        
        Photo oldPhoto = photoRepository.findByOwner(user.getId());
		if( oldPhoto != null) {		
			photoRepository.delete(oldPhoto);
		}

        user.setProfilePicture(photo);
        
        photo = photoRepository.save(photo);        
        return userRepository.save(user);
	}

	public User getByUsername(String username) {
		return userRepository.getByUsername(username);
	}
}
