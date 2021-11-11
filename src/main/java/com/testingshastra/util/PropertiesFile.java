package com.testingshastra.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	public static String getProperty(String fileName,String key)
	{
		
		String value="";
		String dir=System.getProperty("user.dir");
		try {
			FileInputStream fis=new FileInputStream(dir+fileName);
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
		
	}

	public static String getObject(String key)
	{
	     return getProperty("/src/main/resources/ObjectRepository.properties",key);
	
	}
}
