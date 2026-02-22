package com.flipkart.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromProperties(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commanData.properties");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		
		return data;
		
	}
	

}
