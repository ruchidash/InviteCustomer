package com.intercom.service;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.intercom.entity.Calculator;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;

public class LocationService {

	public static List<User> getUsersWithinRange(List<User> users, Calculator calculator, Location sourceLocation) {

		List<User> nearbyUsers = users.stream().filter(user -> {
			if (!isValidLocation(user.getLocation()))
				return false;
			double customerDistance = calculator.getDistanceByLatituteAndLongitude(sourceLocation, user.getLocation());
			return customerDistance <= calculator.getRange();
		}).sorted((user1, user2) -> {
			return (int) (user1.getId() - user2.getId());
		}).collect(Collectors.toList());

		return nearbyUsers;
	}

	public static boolean isValidLocation(Location location) {
		Pattern pattern = Pattern.compile("^\\(" + "[-+]?(([1-8]?[0-9]|0)(\\.\\d+)?|90(\\.0+)?),"
				+ "[-+]?((1?[1-7]?[0-9]|10[0-9]|[1-9][0-9]|0)(\\.\\d+)?|180(\\.0+)?)" + "\\)$");
		String loc = "(" + location.getLatitude() + "," + location.getLongitude() + ")";
		Matcher matcher = pattern.matcher(loc);

		return matcher.find();
	}

	public static Location getSourceLocation(String office) throws InvalidLocationException, InvalidInputException {
		try {
			office = office.toLowerCase();
			Properties properties = PropertiesUtil.getProperties("test");
			double latitude = Double.valueOf(properties.getProperty("intercom_" + office + "_office_latitude"));
			double longitude = Double.valueOf(properties.getProperty("intercom_" + office + "_office_longitude"));
			return new Location(latitude, longitude);
		} catch (IOException | NullPointerException e) {
			throw new InvalidLocationException("Intercom does not have a office at " + office);
		}

	}

}
