package com.hunt.weatherlist.models;

public class Result {
	private String operationalMode, srsName, productionCenter, credit, moreInformation;
	private String creationDate, creationDateLocal;
	private ResultLocation location;
	private ResultTime time;
	private ResultData data;
	private ResultCurrentObservation currentobservation;
	
	private Result() {}
	
	private Result(Builder builder) {
		this.operationalMode = builder.operationalMode;
		this.setSrsName(builder.srsName);
		this.setProductionCenter(builder.productionCenter);
		this.setCredit(builder.credit);
		this.setMoreInformation(builder.moreInformation);
		
		this.setCreationDate(builder.creationDate);
		this.setCreationDateLocal(builder.creationDateLocal);
		
		this.setLocation(builder.location);
		this.setTime(builder.time);
		this.setData(builder.data);
		
		this.setCurrentobservation(builder.currentobservation);		
	}
	
	@Override
	public String toString() {
		return "[ operationMode: " + operationalMode + 
				",\n srsName: " + srsName + 
				",\n productionCenter: " + productionCenter +
				",\n credit: " + credit + 
				",\n moreInformation: " + moreInformation + 
				",\n creationDate: " + creationDate + 
				",\n creationDateLocal: " + creationDateLocal + 
				",\n location: " + location + 
				",\n time: " + time + 
				",\n data: " + data +
				" ]";
	}
	
	public String getOperationalMode() {
		return operationalMode;
	}
	public void setOperationalMode(String operationalMode) {
		this.operationalMode = operationalMode;
	}

	public String getSrsName() {
		return srsName;
	}

	public void setSrsName(String srsName) {
		this.srsName = srsName;
	}

	public String getProductionCenter() {
		return productionCenter;
	}

	public void setProductionCenter(String productionCenter) {
		this.productionCenter = productionCenter;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getMoreInformation() {
		return moreInformation;
	}

	public void setMoreInformation(String moreInformation) {
		this.moreInformation = moreInformation;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getCreationDateLocal() {
		return creationDateLocal;
	}

	public void setCreationDateLocal(String creationDateLocal) {
		this.creationDateLocal = creationDateLocal;
	}

	public ResultLocation getLocation() {
		return location;
	}

	public void setLocation(ResultLocation location) {
		this.location = location;
	}

	public ResultTime getTime() {
		return time;
	}

	public void setTime(ResultTime time) {
		this.time = time;
	}

	public ResultData getData() {
		return data;
	}

	public void setData(ResultData data) {
		this.data = data;
	}
	
	public ResultCurrentObservation getCurrentobservation() {
		return currentobservation;
	}

	public void setCurrentobservation(ResultCurrentObservation currentobservation) {
		this.currentobservation = currentobservation;
	}

	public class Builder {
		private String operationalMode, srsName, productionCenter, credit, moreInformation;
		private String creationDate;
		private String creationDateLocal;
		private ResultLocation location;
		private ResultTime time;
		private ResultData data;
		private ResultCurrentObservation currentobservation;

		
		public Builder operationalMode(String mode) {
			this.operationalMode = mode;
			return this;
		}
		
		public Builder srsName( String s) {
			this.srsName = s;
			return this;
		}
		
		public Builder productionCenter(String p) {
			this.productionCenter = p;
			return this;
		}
		
		public Builder credit( String credit ) {
			this.credit = credit;
			return this;
		}
		
		public Builder moreInformation( String more) {
			this.moreInformation = more;
			return this;
		}
		
		public Builder location( ResultLocation l) {
			this.location = l;
			return this;
		}
		
		public Builder time( ResultTime time) {
			this.time = time;
			return this;
		}
		
		public Builder data( ResultData d) {
			this.data = d;
			return this;
		}
		
		public Builder currentobservation(ResultCurrentObservation c) {
			this.currentobservation = c;
			return this;
		}
		
		public Result build() {
			return new Result(this);
		}


		
	}
}