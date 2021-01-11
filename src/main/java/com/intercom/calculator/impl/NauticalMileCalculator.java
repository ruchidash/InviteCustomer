package com.intercom.calculator.impl;

import com.intercom.calculator.DistanceCalculator;
import com.intercom.entity.Location;

public class NauticalMileCalculator implements DistanceCalculator {

	@Override
	public double calculateDistance(Location source, Location destication) {
		return 0.8684 * new MileCalculator().calculateDistance(source, destication);
	}
}