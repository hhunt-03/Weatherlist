package com.hunt.weatherlist.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class ResultCurrentObservation {
	private String id, name, elev, latitude, longitude, Dewp, Relh, Winds, Windd, Gust, 
					Weather, Weatherimage, Visibility, Altimeter, SLP, timezone, state, WindChill, Date;
	
	@JsonProperty("Temp")
	private String temp;
	
	@Override
	public String toString () {
		return "[ name: " + name +
				", Temp: " + temp +
				" ]";
	}
	
	public ResultCurrentObservation() {}
	
	public ResultCurrentObservation(Builder builder) {
		this.setId(builder.id);
		this.setName(builder.name);
		this.setElev(builder.elev);
		this.setLatitude(builder.latitude);
		this.setLongitude(builder.longitude);
		this.setTemp(builder.Temp);
		this.setDewp(builder.Dewp);
		this.setRelh(builder.Relh);
		this.setWinds(builder.Winds);
		this.setWindd(builder.Windd);
		this.setGust(builder.Gust);
		this.setWeather(builder.Weather);
		this.setWeatherimage(builder.Weatherimage);
		this.setVisibility(builder.Visibility);
		this.setAltimeter(builder.Altimeter);
		this.setSLP(builder.SLP);
		this.setTimezone(builder.timezone);
		this.setState(builder.state);
		this.setWindChill(builder.WindChill);
		this.setDate(builder.Date);
	}	

	public String getElev() {
		return elev;
	}

	public void setElev(String elev) {
		this.elev = elev;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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



	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}



	public String getDewp() {
		return Dewp;
	}

	public void setDewp(String dewp) {
		this.Dewp = dewp;
	}



	public String getRelh() {
		return Relh;
	}

	public void setRelh(String relh) {
		this.Relh = relh;
	}



	public String getWinds() {
		return Winds;
	}

	public void setWinds(String winds) {
		this.Winds = winds;
	}



	public String getWindd() {
		return Windd;
	}

	public void setWindd(String windd) {
		this.Windd = windd;
	}



	public String getGust() {
		return Gust;
	}

	public void setGust(String gust) {
		this.Gust = gust;
	}



	public String getWeather() {
		return Weather;
	}

	public void setWeather(String weather) {
		this.Weather = weather;
	}



	public String getWeatherimage() {
		return Weatherimage;
	}

	public void setWeatherimage(String weatherimage) {
		this.Weatherimage = weatherimage;
	}



	public String getVisibility() {
		return Visibility;
	}

	public void setVisibility(String visibility) {
		this.Visibility = visibility;
	}



	public String getAltimeter() {
		return Altimeter;
	}

	public void setAltimeter(String altimeter) {
		this.Altimeter = altimeter;
	}



	public String getSLP() {
		return SLP;
	}

	public void setSLP(String sLP) {
		this.SLP = sLP;
	}



	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}



	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}



	public String getWindChill() {
		return WindChill;
	}

	public void setWindChill(String windChill) {
		this.WindChill = windChill;
	}



	public String getDate() {
		return Date;
	}
	
	public void setDate(String date) {
		this.Date = date;
	}

	public class Builder{
		private String id, name, elev, latitude, longitude, Temp, Dewp, Relh, Winds, Windd, Gust, 
		Weather, Weatherimage, Visibility, Altimeter, SLP, timezone, state, WindChill;

		private String Date;
		
		public Builder id( String id) {
			this.id = id;
			return this;
		}
		
		public Builder name( String n) {
			this.name = n;
			return this;
		}
		
		public Builder elev( String e) {
			this.elev = e;
			return this;
		}
		
		public Builder latitude(String l) {
			this.latitude = l;
			return this;
		}
		
		public Builder longitude(String l) {
			this.longitude = l;
			return this;
		}
		
		public Builder temp(String t) {
			this.Temp = t;
			return this;
		}
		
		public Builder Dewp(String d) {
			this.Dewp = d;
			return this;
		}
		
		public Builder relh(String r) {
			this.Relh = r;
			return this;
		}
		
		public Builder winds(String w) {
			this.Winds = w;
			return this;
		}
		
		public Builder windd( String w) {
			this.Windd = w;
			return this;
		}
		
		public Builder gust( String g) {
			this.Gust = g;
			return this;
		}
		
		public Builder weather( String w) {
			this.Weather = w;
			return this;
		}
		
		public Builder weatherImage( String w) {
			this.Weatherimage = w;
			return this;
		}
		
		public Builder visibility( String v) {
			this.Visibility = v;
			return this;
		}
		
		public Builder altimeter(String a) {
			this.Altimeter = a;
			return this;
		}
		
		public Builder slp(String s) {
			this.SLP = s;
			return this;
		}
		
		public Builder timezone(String t) {
			this.timezone = t;
			return this;
		}
		
		public Builder state(String s) {
			this.state = s;
			return this;
		}
		
		public Builder windChill(String w) {
			this.WindChill = w;
			return this;
		}
		
		public ResultCurrentObservation build() {
			return new ResultCurrentObservation(this);
		}
		
	}

}
