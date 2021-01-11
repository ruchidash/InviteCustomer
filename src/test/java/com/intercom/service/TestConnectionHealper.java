package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.intercom.exception.InvalidInputException;
import com.intercom.service.impl.ConnectionHelper;

class TestConnectionHealper {

	@Test
	void testInputConnection() throws FileNotFoundException, IOException, InvalidInputException {
		assertNotNull(ConnectionHelper.getConnection());
	}

	@Test
	void testOutputConnection() throws FileNotFoundException, IOException, InvalidInputException {
		assertNotNull(ConnectionHelper.getConnection());
	}

}
