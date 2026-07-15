package com.api.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConfigUtility {

	private final Properties PROPERTY;
	private FileInputStream fis;
	
	static{
		try {
			fis = new FileInputStream("src/test/resources/Properties/Config.properties");
			PROPERTY = new Properties();
			PROPERTY.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load Config.Properties" ,e);
		}
	}
	
	public String getProperty(String key)
	{
		return PROPERTY.getProperty(key);
	}
	
	
}
