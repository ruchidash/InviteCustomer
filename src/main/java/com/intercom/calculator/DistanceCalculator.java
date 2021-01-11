package com.intercom.calculator;

import com.intercom.entity.Location;

public interface DistanceCalculator {

	double calculateDistance(Location source, Location destination);

}