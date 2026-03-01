package com.managecontacts;
import java.time.*;
/*
 * Stored the info of contacts in this class
 */

public class StoreDetails {
    public String phoneNumber;
    public String email;
    public String tag;
    public LocalDate date;

    public StoreDetails(String phoneNumber, String email,String tag,LocalDate date) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.tag = tag;
        this.date = date;
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
    public LocalDate getDate() {
    	return date;
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

}

