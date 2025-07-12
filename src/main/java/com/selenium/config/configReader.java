package com.selenium.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/*Purpose : This class file reads key value pair present in config.properties file and makes easily available 
 * throughout the framework
 * 
 * properties is a built-in java file used for reading .properties file
 * 
 * static is declared so that it can be used without creating object of this class */



public class configReader {
	private static Properties prop;
	public static void init() throws IOException{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		prop.load(fis);
	}
	public static  String get(String key) {
		return prop.getProperty(key);
	}

}
