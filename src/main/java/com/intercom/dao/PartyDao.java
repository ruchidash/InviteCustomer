package com.intercom.dao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.service.impl.ConnectionHelper;

public class PartyDao {

	public static void registerUsers(List<User> users) throws InvalidInputException, FileNotFoundException {
		try (PrintWriter output = ConnectionHelper.getOutputConnection();) {
			users.stream().forEach(user -> {
				output.println(user);
			});

		}
	}
}
