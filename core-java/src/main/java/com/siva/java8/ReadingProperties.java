package com.siva.java8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ReadingProperties {

	public static void main(String[] args) {

		readFromJavaSrcFolder();
		// writeToPropertiesFile();

	}

	// Reading properties file from class path
	private static void readFromResourcesFolder() {

		try (InputStream is = ReadingProperties.class.getClassLoader().getResourceAsStream("application.properties")) {

			Properties props = new Properties();

			if (is == null) {
				System.out.println(" Unable to find properties file");
			}

			props.load(is);

			System.out.println(props.getProperty("message"));

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	private static void readFromJavaSrcFolder() {

		try (InputStream is = new FileInputStream("src/main/java/props/srcProps.properties")) {

			Properties props = new Properties();

			props.load(is);

			System.out.println(props.getProperty("message"));

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private static void writeToPropertiesFile() {

		try (OutputStream os = new FileOutputStream("src/main/java/props/config.properties")) {

			Properties props = new Properties();

			props.setProperty("message", "message from java code");

			props.store(os, null);

			System.out.println(props);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
