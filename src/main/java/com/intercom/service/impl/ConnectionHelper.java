package com.intercom.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.intercom.exception.InvalidInputException;

public class ConnectionHelper {

	public static Path getConnection() throws InvalidInputException {
		String filePath = FilePropertiesUtil.getInputFilePath();
		String fileName = FilePropertiesUtil.getUserInputFileName();
		return Paths.get(filePath, fileName);
	}

	public static PrintWriter getOutputConnection() throws InvalidInputException, FileNotFoundException {
		String filePath = FilePropertiesUtil.getOutputFilePath();
		String fileName = FilePropertiesUtil.getUserOutputFileName();
		FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath + fileName));
		PrintWriter printWriter = new PrintWriter(fileOutputStream);
		return printWriter;
	}

}
