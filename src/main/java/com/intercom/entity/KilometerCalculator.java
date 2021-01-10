package com.intercom.entity;

public class KilometerCalculator extends Calculator {

	public KilometerCalculator() {
	}

	public KilometerCalculator(double range) {
		this.range = range;
	}

	public double getDistanceByLatituteAndLongitude(Location source, Location destication) {
		return 1.609344 * super.getDistanceByLatituteAndLongitude(source, destication);
	}
}
