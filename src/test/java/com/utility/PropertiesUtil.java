package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env,String propertyName)  {
		
		//READ PROPERTIES FILE
		
		File propFile = new File(System.getProperty("user.dir")+"\\config\\"+ env +".properties");
		FileReader filereader = null;
		Properties properties = new Properties();
		try {
			filereader = new FileReader(propFile);
			properties.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 catch (IOException e) {
			// TODO Auto-generated catch block.tio
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;
		
	}
}
