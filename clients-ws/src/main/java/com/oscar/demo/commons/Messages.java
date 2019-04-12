package com.oscar.demo.commons;

import java.util.ResourceBundle;

public class Messages {

	private static ResourceBundle rb = ResourceBundle.getBundle("com.oscar.messages.messages");
	
	public static String getMessage(String key) {
		return rb.getString(key);
	}
	
}
