package com.backend.boiler.plate.Utils;

public class Constants {
	
private static Constants instance = null;
	
	private Constants() {
		
	}
	
	public static Constants getInstance() {
		if (instance == null) {
			instance = new Constants();
		}
		return instance;
	}

	public static String ROLE_SUPER_ADMIN = "SUPER_ADMIN";
	public static String ROLE_ADMIN = "ADMIN";
	public static String ROLE_USER = "USER";
	
	//USERN API MAP KEYS
	public static String USERS_API_MAP_KEY = "users";
}
