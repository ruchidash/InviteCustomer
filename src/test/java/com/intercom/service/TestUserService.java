package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.intercom.service.impl.UserService;

class TestUserService {

	@Test
	void testGetUsers() {
		assertNotNull(UserService.getAllUsers());
		assertEquals(32, UserService.getAllUsers().size());
	}

}
