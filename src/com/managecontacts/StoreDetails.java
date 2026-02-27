package com.managecontacts;

/*
 * Stored the info of contacts in this class
 */

public class StoreDetails {
    public static String phoneNumber;
    public static String email;
    public static String tag;

    public StoreDetails(String phoneNumber, String email,String tag) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tag = tag;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    
    public String getTag() {
    	return tag;
    }

    public static void setPhoneNumber(String phoneNumber) {
		StoreDetails.phoneNumber = phoneNumber;
	}

	public static void setEmail(String email) {
		StoreDetails.email = email;
	}
	
	public static void setTag(String tag) {
		StoreDetails.tag = tag;
	}

	@Override
    public String toString() {
        return phoneNumber + "," + email + "," +tag;
    }

    public static StoreDetails fromString(String line) {
        String[] parts = line.split(",");
        return new StoreDetails(parts[0], parts[1],parts[2]);
    }
}

