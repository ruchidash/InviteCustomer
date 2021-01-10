package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestConverter {

	@Test
	void testDegToRad() {
		double actual = Converter.degToRad(450);
		assertEquals(7.853981633974483, actual);
	}

	@Test
	void testRadToDeg() {
		double actual = Converter.radToDeg(7.853981633974483);
		assertEquals(450, actual);
	}

	@Test
	void testDegToRadNegativeInput() {
		double actual = Converter.degToRad(-1);
		assertEquals(-0.017453292519943295, actual);
	}

	@Test
	void testRadToDegNegativeInput() {
		double actual = Converter.radToDeg(-0.017453292519943295);
		assertEquals(-1, actual);
	}
}
