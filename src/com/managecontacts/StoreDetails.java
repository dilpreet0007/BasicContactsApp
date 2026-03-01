package com.managecontacts;
import java.time.*;
import java.util.ArrayList;
/*
 * Stored the info of contacts in this class
 */

public class StoreDetails {
    public String phoneNumber;
    public String email;
    public ArrayList<String> tag;
    public LocalDate date;

    public StoreDetails(String phoneNumber, String email,ArrayList<String> tag,LocalDate date) {
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
    
    public ArrayList<String> getTag() {
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

	@Override
    public String toString() {
        return phoneNumber + "," + email + "," +tag;
    }

}

