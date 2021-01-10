package com.intercom.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.intercom.exception.InvalidInputException;

class TestPropertiesUtil {

	@Test
	void testInvalidPropertyType() {
		assertThrows(InvalidInputException.class, () -> {
			PropertiesUtil.getProperties("Invalid");
		});
	}

	@Test
	void testValidPropertyType() throws FileNotFoundException, IOException, InvalidInputException {
		assertNotNull(PropertiesUtil.getProperties("test"));
	}

}
