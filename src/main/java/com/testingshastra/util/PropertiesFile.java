package com.testingshastra.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	public void getProperty(String fileName, String key) {
	}
	
	/**
	 * this mthod returns the value of locator mention in object repository
	 * @param key
	 * @return 
	 * 
	 */
	
	public static String getObject(String key) {
		String dir = System.getProperty("user.dir");
		String value="";
		try {
		FileInputStream fis = new FileInputStream(dir+"/src/test/resources/ObjectRepositories.properties");
		Properties prop = new Properties();
		prop.load(fis);
		prop.getProperty(key);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		return value;
	}

}
