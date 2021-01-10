package com.intercom.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.intercom.exception.InvalidInputException;

public class PropertiesUtil {

	public static Properties getProperties(String propType) throws FileNotFoundException, IOException, InvalidInputException {
		String propFile = propType+".properties";
		try (InputStream inStream = 	Thread.currentThread().getContextClassLoader().getResourceAsStream(propFile)) {
			if(inStream == null)
				throw new InvalidInputException("There is no property of type " + propType);
			
			Properties properties = new Properties();
			properties.load(inStream);
			return properties;
		}
	}
}
