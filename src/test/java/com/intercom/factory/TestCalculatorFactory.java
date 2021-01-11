package com.intercom.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.intercom.calculator.impl.MileCalculator;
import com.intercom.calculator.impl.KilometerCalculator;
import com.intercom.calculator.impl.NauticalMileCalculator;

class TestCalculatorFactory {

	@Test
	void testGetKmCalculator() {
		assertNotNull(CalculatorFactory.getCalculator('K'));
		assertEquals(KilometerCalculator.class, CalculatorFactory.getCalculator('K').getClass());
	}

	@Test
	void testGetMileCalculator() {
		assertNotNull(CalculatorFactory.getCalculator('M'));
		assertEquals(MileCalculator.class, CalculatorFactory.getCalculator('M').getClass());
	}

	@Test
	void testGetNauticalMileCalculator() {
		assertNotNull(CalculatorFactory.getCalculator('N'));
		assertEquals(NauticalMileCalculator.class, CalculatorFactory.getCalculator('N').getClass());
	}

	@Test
	void testGetInvalidCalculator() {
		assertNull(CalculatorFactory.getCalculator('O'));
	}

}
