package com.intercom.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.intercom.entity.Location;
import com.intercom.exception.InvalidInputException;
import com.intercom.exception.InvalidLocationException;

/**
 * @author ruchismita.dash
 * @Description FilePropertiesUtil is a singleton class which is used to read
 *              properties from Properties file
 */
public class FilePropertiesUtil {
	private static Properties properties = null;

	private FilePropertiesUtil() {
	}

	private static Properties getProperties() throws InvalidInputException {
		if (properties == null) {
			String propType = getPropertyType();
			String propFile = propType + ".properties";
			try (InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFile)) {
				if (inStream == null)
					throw new InvalidInputException("No properties file found with name " + propFile);

				properties = new Properties();
				properties.load(inStream);

			} catch (InvalidInputException | IOException e) {
				throw new InvalidInputException("Fail to retrieve property type " + propType);
			}

		}
		return properties;
	}

	private static String getPropertyType() {
		String propType = "";
		propType = System.getenv().get("PROPERTY_TYPE");
		if (propType == null || propType.isEmpty())
			propType = System.getProperty("PROPERTY_TYPE");
		if (propType == null || propType.isEmpty())
			propType = "test";
		return propType;
	}

	public static Location getOfficeLocation(String office) throws InvalidLocationException, InvalidInputException {
		try {
			String normalized_office = office.toLowerCase();
			Properties properties = FilePropertiesUtil.getProperties();
			double latitude = Double
					.valueOf(properties.getProperty("intercom_" + normalized_office + "_office_latitude"));
			double longitude = Double
					.valueOf(properties.getProperty("intercom_" + normalized_office + "_office_longitude"));
			return new Location(latitude, longitude);
		} catch (Exception e) {
			throw new InvalidLocationException(e.getMessage());
		}
	}

	public static String getInputFilePath() throws InvalidInputException {
		Properties properties = FilePropertiesUtil.getProperties();
		return properties.getProperty("input_file_path");
	}

	public static String getOutputFilePath() throws InvalidInputException {
		Properties properties = FilePropertiesUtil.getProperties();
		return properties.getProperty("output_file_path");
	}

	public static String getUserInputFileName() throws InvalidInputException {
		Properties properties = FilePropertiesUtil.getProperties();
		return properties.getProperty("users_input_file_name");
	}

	public static String getUserOutputFileName() throws InvalidInputException {
		Properties properties = FilePropertiesUtil.getProperties();
		return properties.getProperty("users_output_file_name");
	}
}
