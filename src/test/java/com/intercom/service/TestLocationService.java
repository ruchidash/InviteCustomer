package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.intercom.entity.Location;
import com.intercom.entity.User;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;
import com.intercom.service.impl.LocationService;
import com.intercom.service.impl.UserService;

class TestLocationService {

	@Test
	void testGetSourceLocation() throws InvalidLocationException, InvalidInputException {
		assertNotNull(LocationService.getOfficeLocation("dublin"));
	}

	@Test
	void testGetInvalidSourceLocation() {
		assertThrows(InvalidLocationException.class, () -> {
			LocationService.getOfficeLocation("mars");
		}, "Intercom does not have a office at mars");
	}

	@Test
	void testIsValidLocation() throws InvalidLocationException {
		assertNotNull(new Location(52.986375, -6.043701));
		assertNotNull(new Location(54.1225, -8.143333));
		assertNotNull(new Location(054.1225, -8.143333));
		assertNotNull(new Location(-090.00000, -180.0000));

	}

	@Test
	void testInValidLocation() {
		assertThrows(InvalidLocationException.class, () -> {
			new Location(-100.00000, -180.0000);
		});

		assertThrows(InvalidLocationException.class, () -> {
			new Location(-90.00000, -200.0000);
		});

	}

	@Test
	void testGetUsersWithinRange() throws InvalidLocationException, InvalidInputException {
		List<User> users = LocationService.getUsersWithinRange(UserService.getAllUsers(), 'K',
				LocationService.getOfficeLocation("dublin"), 100);
		assertNotNull(users);

		assertEquals(16, users.size());

		users = LocationService.getUsersWithinRange(UserService.getAllUsers(), 'K',
				LocationService.getOfficeLocation("dublin"), 50);
		assertNotNull(users);

		assertEquals(8, users.size());
	}

	@Test
	void testGetUsersWithinRangeFromInvalidOffice() {
		assertThrows(InvalidLocationException.class, () -> {
			LocationService.getUsersWithinRange(UserService.getAllUsers(), 'K',
					LocationService.getOfficeLocation("jupiter"), 100);
		});
	}

	@Test
	void testGetUsersExactlyAtOfficeLocation() throws InvalidLocationException, InvalidInputException {
		List<User> users = LocationService.getUsersWithinRange(UserService.getAllUsers(), 'K',
				LocationService.getOfficeLocation("dublin"), 0);

		assertEquals(0, users.size());
	}

}
