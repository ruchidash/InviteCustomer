package com.intercom.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intercom.exception.InvalidLocationException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	@JsonProperty("latitude")
	private double latitude;

	@JsonProperty("longitude")
	private double longitude;

	public Location() {
	}

	public Location(double latitude, double longitude) throws InvalidLocationException {

		if (isValidLocation(latitude, longitude)) {
			this.latitude = latitude;
			this.longitude = longitude;
		}
	}

	private boolean isValidLocation(double latitude, double longitude) throws InvalidLocationException {
		if (latitude >= -90 && latitude <= 90 && longitude >= -180 && longitude <= 180) {
			return true;
		}
		throw new InvalidLocationException("");

	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
