package com.intercom.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.intercom.calculator.impl.KilometerCalculator;
import com.intercom.exception.InvalidLocationException;

class TestEntity {

	@Test
	void testGetDistanceByLatituteAndLongitude() {
		try {
			assertEquals(0, new KilometerCalculator().calculateDistance(new Location(0, 0), new Location(0, 0)));
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testSecondGetDistanceByLatituteAndLongitude() {
		try {
			assertEquals(265.5185873477439, new KilometerCalculator()
					.calculateDistance(new Location(53.339428, -6.257664), new Location(53.339428, -10.257664)));
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetDistanceByInvalidLatituteAndLongitude() {
		try {
			assertEquals(1.609344 * Double.MAX_VALUE, new KilometerCalculator()
					.calculateDistance(new Location(53.339428, -6.257664), new Location(93.339428, -10.257664)));
		} catch (InvalidLocationException e) {
			e.printStackTrace();
		}
	}

}
