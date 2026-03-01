package com.managecontacts;

/*
 * Stored the info of contacts in this class
 */

public class StoreDetails {
    public String phoneNumber;
    public String email;
    public String tag;

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

    public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
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

