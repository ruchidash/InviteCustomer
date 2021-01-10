package com.intercom.factory;

import java.util.HashMap;
import java.util.Map;

import com.intercom.entity.Calculator;
import com.intercom.entity.KilometerCalculator;
import com.intercom.entity.NauticalMileCalculator;

public class CalculatorFactory {
	private static Map<Character, Calculator> map = new HashMap<>();

	public static Calculator getCalculator(char unit) {
		if (map.size() == 0) {
			map.put('M', new Calculator());
			map.put('K', new KilometerCalculator());
			map.put('N', new NauticalMileCalculator());
		}

		return map.get(unit);
	}

}
