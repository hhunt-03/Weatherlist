package com.hunt.weatherlist.models;

public class ResultLocation {
	private String region, latitude, longitude, elevation, wfo, timezone, 
					areaDescription, radar, zone, county, firezone, metar;
	
	public ResultLocation() {}
	
	private ResultLocation(Builder builder) {
		this.setRegion(builder.region);
		this.setLatitude(builder.latitude);
		this.setLongitude(builder.longitude);
		this.setElevation(builder.elevation);
		this.setWfo(builder.wfo);
		this.setTimezone(builder.timezone);
		this.setAreaDescription(builder.areaDescription);
		this.setRadar(builder.radar);
		this.setZone(builder.zone);
		this.setCounty(builder.county);
		this.setFirezone(builder.firezone);
		this.setMetar(builder.metar);
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getWfo() {
		return wfo;
	}

	public void setWfo(String wfo) {
		this.wfo = wfo;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	public String getRadar() {
		return radar;
	}

	public void setRadar(String radar) {
		this.radar = radar;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getFirezone() {
		return firezone;
	}

	public void setFirezone(String firezone) {
		this.firezone = firezone;
	}

	public String getMetar() {
		return metar;
	}

	public void setMetar(String metar) {
		this.metar = metar;
	}

	public class Builder{
		private String region, latitude, longitude, elevation, wfo, timezone, 
		areaDescription, radar, zone, county, firezone, metar;
		
		public Builder region(String r) {
			this.region = r;
			return this;
		}
		
		public Builder latitude(String l) {
			this.latitude = l;
			return this;
		}
		
		public Builder longitude( String l) {
			this.longitude = l;
			return this;
		}
		
		public Builder elevation( String e) {
			this.elevation = e;
			return this;
		}
		
		public Builder wfo(String w) {
			this.wfo = w;
			return this;
		}
		
		public Builder timezone(String t) {
			this.timezone = t;
			return this;
		}
		
		public Builder areaDescription(String a) {
			this.areaDescription = a;
			return this;
		}
		
		public Builder radar(String r) {
			this.radar = r;
			return this;
		}
		
		public Builder zone(String z) {
			this.zone = z;
			return this;
		}
		
		public Builder county(String c) {
			this.county = c;
			return this;
		}
		
		public Builder firezone(String f) {
			this.firezone = f;
			return this;
		}
		
		public Builder metar(String m) {
			this.metar = m;
			return this;
		}
		
		public ResultLocation build() {
			return new ResultLocation(this);
		}
	}

}
