package com.intercom.entity;

public class NauticalMileCalculator extends Calculator {

	public NauticalMileCalculator() {
	}

	public NauticalMileCalculator(double range) {
		this.range = range;
	}

	public double getDistanceByLatituteAndLongitude(Location source, Location destication) {
		return 0.8684 * getDistanceByLatituteAndLongitude(source, destication);
	}
}
