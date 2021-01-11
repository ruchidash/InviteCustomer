package com.intercom.calculator.impl;

import com.intercom.calculator.DistanceCalculator;
import com.intercom.entity.Location;

public class KilometerCalculator implements DistanceCalculator {

	@Override
	public double calculateDistance(Location source, Location destination) {
		return 1.609344 * new MileCalculator().calculateDistance(source, destination);
	}

}
