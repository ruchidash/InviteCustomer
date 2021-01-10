package com.intercom.controller;

import java.util.List;

import com.intercom.entity.Calculator;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;
import com.intercom.factory.CalculatorFactory;
import com.intercom.service.LocationService;
import com.intercom.service.PartyService;
import com.intercom.service.UserService;

public class Socialise {
	public static void main(String[] args) {
		try {
			Location sourceLocation = LocationService.getSourceLocation("Dublin");
			List<User> users = getUsersByDistance(sourceLocation, 100, 'K');
			PartyService.registerUsersForMeetup(users);
		} catch (InvalidLocationException | InvalidInputException e) {
			e.printStackTrace();
		}
	}

	private static List<User> getUsersByDistance(Location sourceLocation, double distance, char unit) {
		Calculator distanceCalculator = CalculatorFactory.getCalculator(unit);
		distanceCalculator.setRange(100);

		return LocationService.getUsersWithinRange(UserService.getAllUsers(), distanceCalculator, sourceLocation);
	}
}
