package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.intercom.entity.KilometerCalculator;
import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;

class TestLocationService {

	@Test
	void testGetSourceLocation() throws InvalidLocationException, InvalidInputException {
		assertNotNull(LocationService.getSourceLocation("dublin"));
	}

	@Test
	void testGetInvalidSourceLocation() {
		assertThrows(InvalidLocationException.class, () -> {
			LocationService.getSourceLocation("mars");
		}, "Intercom does not have a office at mars");
	}

	@Test
	void testIsValidLocation() {
		assertTrue(LocationService.isValidLocation(new Location(52.986375, -6.043701)));
		assertTrue(LocationService.isValidLocation(new Location(54.1225, -8.143333)));
		assertTrue(LocationService.isValidLocation(new Location(054.1225, -8.143333)));
		assertTrue(LocationService.isValidLocation(new Location(-090.00000, -180.0000)));
		assertFalse(LocationService.isValidLocation(new Location(-100.00000, -180.0000)));
		assertFalse(LocationService.isValidLocation(new Location(-90.00000, -200.0000)));
	}

	@Test
	void testGetUsersWithinRange() throws InvalidLocationException, InvalidInputException {
		List<User> users = LocationService.getUsersWithinRange(UserService.getAllUsers(), new KilometerCalculator(100),
				LocationService.getSourceLocation("dublin"));
		assertNotNull(users);

		assertEquals(16, users.size());

		users = LocationService.getUsersWithinRange(UserService.getAllUsers(), new KilometerCalculator(50),
				LocationService.getSourceLocation("dublin"));
		assertNotNull(users);

		assertEquals(8, users.size());
	}

	@Test
	void testGetUsersWithinRangeFromInvalidOffice() {
		assertThrows(InvalidLocationException.class, () -> {
			LocationService.getUsersWithinRange(UserService.getAllUsers(), new KilometerCalculator(100),
					LocationService.getSourceLocation("jupiter"));
		});
	}

	@Test
	void testGetUsersExactlyAtOfficeLocation() throws InvalidLocationException, InvalidInputException {
		List<User> users = LocationService.getUsersWithinRange(UserService.getAllUsers(), new KilometerCalculator(0),
				LocationService.getSourceLocation("dublin"));

		assertEquals(0, users.size());
	}

}
