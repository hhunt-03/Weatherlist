package com.hunt.weatherlist.models;

public class ResultData {
	private String[] temperature, pop, weather, iconLink, hazard, hazardUrl, text;

	
	public ResultData() {}
	
	private ResultData(Builder builder) {
		this.setTemperature(builder.temperature);
		this.setPop(builder.pop);
		this.setWeather(builder.weather);
		this.setIconLink(builder.iconLink);
		this.setHazard(builder.hazard);
		this.setHazardUrl(builder.hazardUrl);
		this.setText(builder.text);
	}

	public String[] getTemperature() {
		return temperature;
	}

	public void setTemperature(String[] temperature) {
		this.temperature = temperature;
	}

	public String[] getPop() {
		return pop;
	}

	public void setPop(String[] pop) {
		this.pop = pop;
	}

	public String[] getWeather() {
		return weather;
	}

	public void setWeather(String[] weather) {
		this.weather = weather;
	}

	public String[] getIconLink() {
		return iconLink;
	}

	public void setIconLink(String[] iconLink) {
		this.iconLink = iconLink;
	}

	public String[] getHazard() {
		return hazard;
	}

	public void setHazard(String[] hazard) {
		this.hazard = hazard;
	}

	public String[] getHazardUrl() {
		return hazardUrl;
	}

	public void setHazardUrl(String[] hazardUrl) {
		this.hazardUrl = hazardUrl;
	}

	public String[] getText() {
		return text;
	}

	public void setText(String[] text) {
		this.text = text;
	}


	public class Builder {
		private String[] temperature, pop, weather, iconLink, hazard, hazardUrl, text;
		
		public Builder temperature(String[] t) {
			this.temperature = t;
			return this;
		}
		
		public Builder pop(String[] p) {
			this.pop = p;
			return this;
		}
		
		public Builder weather(String[] w) {
			this.weather = w;
			return this;
		}
		
		public Builder iconLink(String[] i) {
			this.iconLink = i;
			return this;
		}
		
		public Builder hazard(String[] h) {
			this.hazard = h;
			return this;
		}
		
		public Builder hazardUrl(String[] h) {
			this.hazardUrl = h;
			return this;
		}
		
		public Builder text(String[] t) {
			this.text = t;
			return this;
		}
		
		
		public ResultData build() {
			return new ResultData(this);
		}
	}
}