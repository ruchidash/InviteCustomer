package com.intercom.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.intercom.calculator.DistanceCalculator;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;

public class LocationService {

	public static List<User> getUsersWithinRange(List<User> users, DistanceCalculator calculator, Location sourceLocation, double distance) {

		List<User> nearbyUsers = users.stream().filter(user -> {
			double customerDistance = calculator.calculateDistance(sourceLocation, user.getLocation());
			return customerDistance <= distance;
		}).sorted((user1, user2) -> {
			return (int) (user1.getId() - user2.getId());
		}).collect(Collectors.toList());

		return nearbyUsers;
	}

	public static Location getOfficeLocation(String office) throws InvalidLocationException, InvalidInputException {
		return FilePropertiesUtil.getOfficeLocation(office);

	}

}
