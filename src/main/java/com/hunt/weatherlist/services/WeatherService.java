package com.hunt.weatherlist.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hunt.weatherlist.models.Location;
import com.hunt.weatherlist.models.Result;
import com.hunt.weatherlist.models.ResultCurrentObservation;
import com.hunt.weatherlist.models.ResultData;

import reactor.core.publisher.Mono;


@Service
public class WeatherService {
	public Location getLocation(String longitude, String latitude) {
		String url = "https://forecast.weather.gov/MapClick.php?lat=" + latitude + "&lon=" + longitude + "&FcstType=json";
		
		WebClient client = WebClient.builder()
									.baseUrl(url)
									.build();
		
		Mono<Result> response = client
				.get()
				.retrieve()
				.bodyToMono( Result.class );
				
		Result result = response.block();
		
		if( result.getCurrentobservation() == null ) {
			return new Location();
		} else {					
			return new Location.Builder().latitude(result.getCurrentobservation().getLatitude())
											.longitude(result.getCurrentobservation().getLongitude())
											.temperature(result.getCurrentobservation().getTemp())
											.text(result.getData().getText())
											.areaDescription(result.getCurrentobservation().getName())
											.build();
		}
	}
}
