package com.managecontacts;

/*
 * Stored the info of contacts in this class
 */

public class StoreDetails {
    public static String phoneNumber;
    public static String email;

    public StoreDetails(String phoneNumber, String email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public static void setPhoneNumber(String phoneNumber) {
		StoreDetails.phoneNumber = phoneNumber;
	}

	public static void setEmail(String email) {
		StoreDetails.email = email;
	}

	@Override
    public String toString() {
        return phoneNumber + "," + email;
    }

    public static StoreDetails fromString(String line) {
        String[] parts = line.split(",");
        return new StoreDetails(parts[0], parts[1]);
    }
}

