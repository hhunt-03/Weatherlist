package com.hunt.weatherlist.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.User;
import com.hunt.weatherlist.repositories.LocationRepository;
import com.hunt.weatherlist.repositories.UserRepository;

@Service
public class MockData {
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	private List<User> mockUsers(){
		String tomPassword = (this.encoder.encode("123"));
		String suePassword = (this.encoder.encode("abc"));
		String finPassword = (this.encoder.encode("xyz"));

		return Arrays.asList(
				new User.Builder().firstName("Tom")
									.lastName("Smith")
									.email("jsmith@list.org")
									.username("tom")
									.password(tomPassword)
									.enabled(true)
									.build(),
				new User.Builder().firstName("Sue")
									.lastName("Hunt")
									.email("goop@list.org")
									.username("sue")
									.password(suePassword)
									.enabled(true)
									.build(),
				new User.Builder().firstName("Fin")
									.lastName("Seat")
									.email("frog@list.org")
									.username("fin")
									.password(finPassword)
									.enabled(true)
									.build()
		).stream().map( user -> {
				return userRepository.save(user);
		}).collect( Collectors.toList());
	};
	
	private void mockLocations(List<User> users){
		String[] locations = {"Scattered showers", "Sunny", "Thunderstorms"};
		users.stream().forEach(user -> {
				Location l1 = new Location.Builder().longitude("-91.239578")
										.latitude("43.801357")
										.temperature("45.2")
										.text(locations)
										.areaDescription("La Crosse, Grandad's Bluff, WI")
										.user(user)
										.build();
				Location l2 = new Location.Builder().longitude("-97.437500")
										.latitude("28.831741")
										.temperature("101.9")
										.text(locations)
										.areaDescription("Great Mountains Airport, Oregon")
										.user(user)
										.build();
				Location l3 = new Location.Builder().longitude("-117.300781")
										.latitude("36.797463")
										.temperature("71.8")
										.text(locations)
										.areaDescription("VISITORS CENTER AT FURNACE CREEK DEATH VALLEY")
										.user(user)
										.build();
				locationRepository.save(l1);
				locationRepository.save(l2);
				locationRepository.save(l3);				
		});
	}
	
	@PostConstruct
	public void mockData() {
		if (this.userRepository.findAll().isEmpty()) {
			mockLocations(mockUsers());
		}
	}
	
}
