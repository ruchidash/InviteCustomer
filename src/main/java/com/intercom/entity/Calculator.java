package com.intercom.entity;

import com.intercom.service.Converter;
import com.intercom.service.LocationService;

public class Calculator {
	protected double range;

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}

	public Calculator() {
	}

	public Calculator(double range) {
		this.range = range;
	}

	public double getDistanceByLatituteAndLongitude(Location sourceLocation, Location destination) {
		double dist = Double.MAX_VALUE;

		if (!LocationService.isValidLocation(sourceLocation) || !LocationService.isValidLocation(destination))
			return dist;

		double sourceLon = sourceLocation.getLongitude();
		double sourceLat = sourceLocation.getLatitude();

		double destinationLon = destination.getLongitude();
		double destinationLat = destination.getLatitude();

		double theta = destinationLon - sourceLon;
		dist = Math.sin(Converter.degToRad(destinationLat)) * Math.sin(Converter.degToRad(sourceLat))
				+ Math.cos(Converter.degToRad(destinationLat)) * Math.cos(Converter.degToRad(sourceLat))
						* Math.cos(Converter.degToRad(theta));
		dist = Math.acos(dist);
		dist = Converter.radToDeg(dist);

		dist = dist * 60 * 1.1515;

		return dist;

	}

}
