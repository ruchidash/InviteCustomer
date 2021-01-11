package com.intercom.controller;

import java.util.List;

import com.intercom.calculator.DistanceCalculator;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;
import com.intercom.factory.CalculatorFactory;
import com.intercom.service.impl.LocationService;
import com.intercom.service.impl.PartyService;
import com.intercom.service.impl.UserService;

public class Socialise {
	public static void main(String[] args) {
		try {
			Location sourceLocation = LocationService.getOfficeLocation("Dublin");
			List<User> users = getUsersByDistance(sourceLocation, 100, 'K');
			PartyService.registerUsersForMeetup(users);
		} catch (InvalidLocationException | InvalidInputException e) {
			e.printStackTrace();
		}
	}

	private static List<User> getUsersByDistance(Location sourceLocation, double range, char unit) {
		DistanceCalculator distanceCalculator = CalculatorFactory.getCalculator(unit);

		return LocationService.getUsersWithinRange(UserService.getAllUsers(), distanceCalculator, sourceLocation, range);
	}
}
