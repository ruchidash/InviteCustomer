package com.intercom.service;

public class Converter {
	public static double degToRad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public static double radToDeg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
