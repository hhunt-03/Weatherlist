package com.hunt.weatherlist.models;

public class ResultTime{
	private String layoutKey;
	private String[] startPeriodName, startValidTime, tempLabel;
	
	public ResultTime() {}
	
	public ResultTime( Builder builder) {
		this.layoutKey = builder.layoutKey;
		this.startPeriodName = builder.startPeriodName;
		this.startValidTime = builder.startValidTime;
		this.tempLabel = builder.tempLabel;
	}
	
	public String getLayoutKey() {
		return layoutKey;
	}
	public void setLayoutKey(String layoutKey) {
		this.layoutKey = layoutKey;
	}
	public String[] getStartPeriodName() {
		return startPeriodName;
	}
	public void setStartPeriodName(String[] startPeriodName) {
		this.startPeriodName = startPeriodName;
	}
	public String[] getStartValidTime() {
		return startValidTime;
	}
	public void setStartValidTime(String[] startValidTime) {
		this.startValidTime = startValidTime;
	}
	public String[] getTempLabel() {
		return tempLabel;
	}
	public void setTempLabel(String[] tempLabel) {
		this.tempLabel = tempLabel;
	}
	
	public class Builder {
		private String layoutKey;
		private String[] startPeriodName, startValidTime, tempLabel;
		
		public Builder layoutKey(String l) {
			this.layoutKey = l;
			return this;
		}
		
		public Builder startPeriodName( String[] s) {
			this.startPeriodName = s;
			return this;
		}
		
		public Builder startValidTime( String[] s) {
			this.startValidTime = s;
			return this;
		}
		
		public Builder tempLabel( String[] t) {
			this.tempLabel = t;
			return this;
		}
		
		public ResultTime build(){
			return new ResultTime(this);
		}
	}
}