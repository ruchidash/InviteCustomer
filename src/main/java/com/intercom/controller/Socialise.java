package com.intercom.controller;

import java.util.List;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;
import com.intercom.service.impl.LocationService;
import com.intercom.service.impl.PartyService;
import com.intercom.service.impl.UserService;

public class Socialise {
	public static void main(String[] args) {
		try {
			Location sourceLocation = LocationService.getOfficeLocation("Dublin");
			List<User> allUsers = UserService.getAllUsers();
			List<User> users = LocationService.getUsersWithinRange(allUsers, 'K', sourceLocation, (double) 100);
			PartyService.registerUsersForMeetup(users);
		} catch (InvalidLocationException | InvalidInputException e) {
			e.printStackTrace();
		}
	}
}
