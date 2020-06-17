/**
 * 
 */
package com.koatchy.configGenerator.tools;

import java.io.*;
import java.util.*;

/**
 * @author alfredo.barrios
 *
 */
public class ReadProperties {

	String propertiesFile;
	InputStream inputStream;

	
	public ReadProperties(String propertiesFile) {
		this.propertiesFile = "C:\\configGenerator\\" + propertiesFile + ".properties";
	}
	
	public String getValue(String key) {
		String result;
		try {
			result = readPropertiesFile().getProperty(key);
		} catch(Exception ex) {
			result = "";
		}
		return result;
	}
	
	public String getPropValue(String key) throws IOException {
		String result = "";
		
		try {
			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFile);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propertiesFile + "' not found in the classpath");
			}
 
			// get the property value and print it out
			result = prop.getProperty(key);
			System.out.println("getPropValue: " + result + "\n");
		} catch (Exception err) {
			System.err.println("Exception FileNotFoundException ReadProperties.getPropValue thrown: " + err.getMessage() + ", " + propertiesFile + "\n");
		} finally {
			inputStream.close();
		}
		return result;
	}
	
	private Properties readPropertiesFile() throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(propertiesFile);
			prop = new Properties();
			prop.load(fis);
		} catch(FileNotFoundException fnfe) {
			System.err.println("Exception FileNotFoundException ReadProperties.readPropertiesFile thrown: " + fnfe.getMessage() + ", " + propertiesFile + "\n");
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			System.err.println("Exception IOException ReadProperties.readPropertiesFile thrown: " + ioe.getMessage() + ", " + propertiesFile + "\n");
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}
	
}
