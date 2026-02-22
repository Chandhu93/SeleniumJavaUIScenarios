package com.flipkart.genericUtility;

public class JavaUtility {
	
	public int StringToIntParse(String input) {
        String numeric = input.replaceAll("[^0-9]", "");
        return Integer.parseInt(numeric);
    }
	

}
