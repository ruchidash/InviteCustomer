package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import com.intercom.exception.InvalidInputException;
import com.intercom.service.impl.FilePropertiesUtil;
import com.intercom.service.impl.PartyService;
import com.intercom.service.impl.UserService;

class TestPartyService {

	@Test
	void testGetUsers() throws InvalidInputException {
		PartyService.registerUsersForMeetup(UserService.getAllUsers());
		String filePath = FilePropertiesUtil.getOutputFilePath();
		String fileName = FilePropertiesUtil.getUserOutputFileName();
		long lineCount = 0;
		try (Stream<String> stream = Files.lines(Paths.get(filePath, fileName))) {
			lineCount = stream.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(32, lineCount);
	}

}
