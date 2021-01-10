package com.intercom.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.intercom.entity.Calculator;
import com.intercom.entity.KilometerCalculator;
import com.intercom.entity.NauticalMileCalculator;

class TestCalculatorFactory {

	@Test
	void testGetKmCalculator() {
		assertNotNull(CalculatorFactory.getCalculator('K'));
		assertEquals(KilometerCalculator.class, CalculatorFactory.getCalculator('K').getClass());
	}

	@Test
	void testGetMileCalculator() {
		assertNotNull(CalculatorFactory.getCalculator('M'));
		assertEquals(Calculator.class, CalculatorFactory.getCalculator('M').getClass());
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
