package com.hunt.weatherlist.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="locations")
public class Location {
	private String latitude, longitude, temperature, areaDescription;
	private String[] text;
	
	@DBRef
	private User user;
	
	@Id
	private String id;
	
	public Location() {
		
	}
	
	private Location( Builder builder ) {
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
		this.temperature = builder.temperature;
		this.text = builder.text;
		this.areaDescription = builder.areaDescription;
		this.user = builder.user;
	}
	
	@Override
	public String toString() {
		return "[ areaDescription : " + areaDescription + 
				", latitude : "	+ latitude + 
				", longitude : " + longitude +
				", user : " + user.getFirstName() + " "  + user.getLastName();
	}
	
	@Override
	public boolean equals(Object object) {
		 if( object instanceof Location) {
			Location location = (Location) object;
			
			return this.getLatitude() == location.getLatitude() &&
					this.getLongitude() == location.getLongitude();
		 }
		 return false;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




	public static class Builder{
		private String latitude, longitude, temperature, areaDescription;
		String[] text;
		private User user;
		
		@Id
		private String id;
		
		public Builder id( String id) {
			this.id = id;
			return this;
		}
		
		public Builder latitude(String latitude) {
			this.latitude = latitude;
			return this;
		}
		
		public Builder longitude(String longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public Builder temperature( String temp) {
			this.temperature = temp;
			return this;
		}
		
		public Builder text( String[] text ) {
			this.text = text;
			return this;
		}
		
		public Builder areaDescription( String areaDescription ) {
			this.areaDescription = areaDescription;
			return this;
		}
		
		public Builder user(User user) {
			this.user = user;
			return this;
		}
		
		public Location build() {
			return new Location(this);
		}
	}
	
}
