package com.hunt.weatherlist.controllers;

import java.awt.Image;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hunt.weatherlist.models.User;
import com.hunt.weatherlist.services.LocationService;
import com.hunt.weatherlist.services.UserService;
import com.hunt.weatherlist.configurations.WebSecurityConfig;
import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.Photo;


@RestController
@RequestMapping("api/v1")
public class ApiController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;
	
//	@Autowired
//	private WebSecurityConfig webSecurityConfig;
	
//	GETS ==================================================================================================
	
//	GETIING USER BY ID --------------------------------------
	
	@RequestMapping( value="/users/{userid}", method=RequestMethod.GET )
	public User getUserById(@PathVariable String userid) {
		User user = userService.findUserById(userid);
		return user;
	}
	
//  GETTING LOCATION BY COORDINATES ----------------------------
	
	@RequestMapping( value="/location", method=RequestMethod.GET )
	public Location getLocationByLongitudeAndLatitude(@RequestParam(required=true) String longitude, @RequestParam(required=true) String latitude) {
		return locationService.findByLongitudeAndLatitude(longitude, latitude);
	}
	
//	GETTING A USERS SAVED LOCATIONS -------------------------------
	
	@RequestMapping(value="/users/{userid}/locations", method=RequestMethod.GET)
	public List<Location> getUsersLocations(@PathVariable String userid){
		return locationService.findByUser(userService.findUserById(userid));
	}
	
//	GETTING A USERS PROFILE PICTURE	
	@RequestMapping(value="/users/{userid}/photo", method=RequestMethod.GET)
    public ResponseEntity<byte[]> getPhoto (Principal p, HttpServletResponse response) {  
    	System.out.println("getting photo");
    	try {
    		User user = userService.getByUsername( p.getName() );
    		System.out.println(user);
    		Photo photo = userService.getPhoto( user );
    		System.out.println(photo);
            return ResponseEntity
                	.ok()
                	.contentType(MediaType.valueOf("image/" + photo.getType()))
                	.body( photo.getImage().getData());
    	} catch ( Exception e ) {
    		return null;
    	}

    }

	
//	POSTS =======================================================================================
	
//	SAVING A LOCATION TO USER 
	
	@RequestMapping(value="/users/{userid}/locations", method=RequestMethod.POST)
	public Location addLocation (@RequestBody Location location) {	
		return locationService.save(location);
	}
	
// 	PUTS ==========================================================================================
	
//	UPLOADING NEW PROFILE PIC 
	@RequestMapping(value="/users/{userid}/photo", method=RequestMethod.PUT)
	public User setPhoto( @PathVariable(name="userid", required=true) String userid,
					      @RequestParam(name="photo", required=true) MultipartFile file, 
						  HttpServletResponse response ) {
		try {
			User user = userService.findUserById(userid);
			
			return userService.setPhoto( user, file);
		} catch( Exception e ) {
			System.out.println(e);
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        return null;
		}
	}
	
//	DELETING locations
	
	@RequestMapping(value="/locations/{locationid}", method=RequestMethod.DELETE)
	public boolean deleteLocationById(@PathVariable String locationid) {
		return locationService.deleteLocationFromLocations(locationid);
	}

}
