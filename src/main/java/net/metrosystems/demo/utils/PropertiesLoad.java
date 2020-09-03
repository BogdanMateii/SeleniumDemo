package net.metrosystems.demo.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoad {
	public static Properties config = loadProperties("properties/config.properties");

	private static Properties loadProperties(String filePath) {
		Properties properties = new Properties();
		try {
			FileInputStream f = new FileInputStream(filePath);
			properties.load(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	/*
	 * public static String getValue(String path, String value) { Properties
	 * loadValue = loadProperties(path); String result = ""; Set<String> key =
	 * loadValue.stringPropertyNames(); for (String element : key) { if
	 * (StringUtils.equalsIgnoreCase(element, value)) { result =
	 * loadValue.getProperty(element); break; } } return result; }
	 */

}
