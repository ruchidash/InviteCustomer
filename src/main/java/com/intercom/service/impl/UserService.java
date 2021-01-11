package com.intercom.service.impl;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.intercom.dao.UserDao;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;

public class UserService {

	public static List<User> getAllUsers() {
		try {
			return UserDao.getAllUsers();
		} catch (IOException | InvalidInputException e) {
			e.printStackTrace();
		}
		
		return new LinkedList<User>();
	}
}
