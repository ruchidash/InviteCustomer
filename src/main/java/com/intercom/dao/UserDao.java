package com.intercom.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.service.ConnectionHelper;

public class UserDao {

	public static List<User> getAllUsers() throws FileNotFoundException, IOException, InvalidInputException {
		List<User> users = new LinkedList<>();
		try (Stream<String> stream = Files.lines(ConnectionHelper.getConnection())) {

			ObjectMapper mapper = new ObjectMapper();

			users = stream.map(line -> {
				User user = null;
				try {
					user = mapper.readValue(line, User.class);
					Location location = mapper.readValue(line, Location.class);
					user.setLocation(location);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

				return user;
			}).collect(Collectors.toList());

		}
		return users;
	}

	public static void registerUsers(List<User> users) throws InvalidInputException {
		try (PrintWriter output = ConnectionHelper.getOutputConnection();) {
			users.stream().forEach(user -> {
				output.println(user);
			});

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
