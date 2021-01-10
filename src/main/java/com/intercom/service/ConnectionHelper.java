package com.intercom.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.intercom.exception.InvalidInputException;

public class ConnectionHelper {

	public static Path getConnection() throws FileNotFoundException, IOException, InvalidInputException {
		Properties properties = PropertiesUtil.getProperties("test");
		String filePath = properties.getProperty("input_file_path");
		String fileName = properties.getProperty("users_input_file_name");
		return Paths.get(filePath, fileName);
	}

	public static PrintWriter getOutputConnection() throws FileNotFoundException, IOException, InvalidInputException {
		Properties properties = PropertiesUtil.getProperties("test");
		String filePath = properties.getProperty("output_file_path");
		String fileName = properties.getProperty("users_output_file_name");
		FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath + fileName));
		PrintWriter printWriter = new PrintWriter(fileOutputStream);
		return printWriter;
	}

}
