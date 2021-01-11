package com.intercom.calculator.impl;

import com.intercom.calculator.DistanceCalculator;
import com.intercom.entity.Location;
import com.intercom.service.impl.AngleConverter;

public class MileCalculator implements DistanceCalculator {

	@Override
	public double calculateDistance(Location source, Location destination) {
		double dist = Double.MAX_VALUE;
		double sourceLon = source.getLongitude();
		double sourceLat = source.getLatitude();
		double destinationLon = destination.getLongitude();
		double destinationLat = destination.getLatitude();
		double theta = destinationLon - sourceLon;

		dist = Math.sin(AngleConverter.degToRad(destinationLat)) * Math.sin(AngleConverter.degToRad(sourceLat))
				+ Math.cos(AngleConverter.degToRad(destinationLat)) * Math.cos(AngleConverter.degToRad(sourceLat))
						* Math.cos(AngleConverter.degToRad(theta));

		dist = Math.acos(dist);
		dist = AngleConverter.radToDeg(dist);
		dist = dist * 60 * 1.1515;

		return dist;
	}
}
