package com.managecontacts;

import java.util.*;

/*
 *  Create Contact feature is added in this class
 *  View Contact details is also added in this class
 *  Updating the contactDetails
 */

public class ManageContacts{
	public static HashMap<String,StoreDetails> map = new HashMap<>();
	
	public static void addContact(String name,String phoneNumber,String email) {
		map.put(name, new StoreDetails(phoneNumber,email));
		ContactFileManager.saveContacts(map);
	}
	
	public static void deleteContact(String name) {
		map.remove(name);
		System.out.println(map);
	}
	
	public static void getContact(String name) {
		StoreDetails d = map.get(name);
		System.out.println(name + " " + d.phoneNumber + " " + d.email);
	}
	
	public static void updateContactName(String name,String newName) {
		StoreDetails d = map.get(name);
		map.remove(name);
		map.put(newName, d);
		ContactFileManager.saveContacts(map);
	}
	public static void updateContactPhoneNumber(String name,String newNumber) {
		StoreDetails d = map.get(name);
		d.setPhoneNumber(newNumber);
		map.put(name, d);
		ContactFileManager.saveContacts(map);
	}
	public static void updateContactEmail(String name,String newEmail) {
		StoreDetails d = map.get(name);
		d.setEmail(newEmail);
		map.put(name, d);
		ContactFileManager.saveContacts(map);
	}
}
