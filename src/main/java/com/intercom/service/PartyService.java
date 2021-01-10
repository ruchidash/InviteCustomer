package com.intercom.service;

import java.util.List;

import com.intercom.dao.UserDao;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;

public class PartyService {

	public static void registerUsersForMeetup(List<User> users) {
		try {
			UserDao.registerUsers(users);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
	}

}
