package com.intercom.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

class TestEntity {

	@Test
	void testGetDistanceByLatituteAndLongitude() {
		assertEquals(0,
				new KilometerCalculator().getDistanceByLatituteAndLongitude(new Location(0, 0), new Location(0, 0)));
	}

	@Test
	void testSecondGetDistanceByLatituteAndLongitude() {
		assertEquals(265.5185873477439, new KilometerCalculator().getDistanceByLatituteAndLongitude(
				new Location(53.339428, -6.257664), new Location(53.339428, -10.257664)));
	}

	@Test
	void testGetDistanceByInvalidLatituteAndLongitude() {
		assertEquals(1.609344 * Double.MAX_VALUE, new KilometerCalculator().getDistanceByLatituteAndLongitude(
				new Location(53.339428, -6.257664), new Location(93.339428, -10.257664)));
	}

}
