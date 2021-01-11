package com.intercom.factory;

import java.util.HashMap;
import java.util.Map;

import com.intercom.calculator.DistanceCalculator;
import com.intercom.calculator.impl.MileCalculator;
import com.intercom.calculator.impl.KilometerCalculator;
import com.intercom.calculator.impl.NauticalMileCalculator;

public class CalculatorFactory {
	private static Map<Character, DistanceCalculator> map = new HashMap<>();

	public static DistanceCalculator getCalculator(char unit) {
		if (map.size() == 0) {
			map.put('M', new MileCalculator());
			map.put('K', new KilometerCalculator());
			map.put('N', new NauticalMileCalculator());
		}

		return map.get(unit);
	}
}
