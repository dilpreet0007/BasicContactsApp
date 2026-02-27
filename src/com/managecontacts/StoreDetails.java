package com.managecontacts;

public class StoreDetails {
	public static String phoneNumber;
	public static String email;
	
	public StoreDetails(String phoneNumber,String email) {
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public static void setPhoneNumber(String phoneNumber) {
		StoreDetails.phoneNumber = phoneNumber;
	}

	public static void setEmail(String email) {
		StoreDetails.email = email;
	}
	
	
}
