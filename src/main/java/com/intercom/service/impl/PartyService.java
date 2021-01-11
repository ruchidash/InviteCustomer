package com.intercom.service.impl;

import java.io.FileNotFoundException;
import java.util.List;
import com.intercom.dao.PartyDao;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;

public class PartyService {

	public static void registerUsersForMeetup(List<User> users) {
		try {
			PartyDao.registerUsers(users);
		} catch (InvalidInputException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
