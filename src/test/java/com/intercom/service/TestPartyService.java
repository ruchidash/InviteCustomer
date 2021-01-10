package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.intercom.exception.InvalidInputException;

class TestPartyService {

	@Test
	void testGetUsers() {
		PartyService.registerUsersForMeetup(UserService.getAllUsers());
		Properties properties = null;
		try {
			properties = PropertiesUtil.getProperties("test");
		} catch (IOException | InvalidInputException e1) {
			e1.printStackTrace();
		}
		String filePath = properties.getProperty("output_file_path");
		String fileName = properties.getProperty("users_output_file_name");
		long lineCount = 0;
		try (Stream<String> stream = Files.lines(Paths.get(filePath, fileName))) {
			lineCount = stream.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(32, lineCount);
	}

}
