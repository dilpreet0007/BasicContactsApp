package com.managecontacts;

import java.util.*;

public class ManageContacts{
	public static HashMap<String,StoreDetails> map = new HashMap<>();
	
	public static void addContact(String name,String phoneNumber,String email) {
		map.put(name, new StoreDetails(phoneNumber,email));
	}
	
	public static void deleteContact(String name) {
		map.remove(name);
	}
	
	public static void getContact(String name) {
		StoreDetails d = map.get(name);
		System.out.println(name + " " + d.phoneNumber + " " + d.email);
	}
	
	public static void updateContactName(String name,String newName) {
		StoreDetails d = map.get(name);
		map.remove(name);
		map.put(newName, d);
	}
	public static void updateContactPhoneNumber(String name,String newNumber) {
		StoreDetails d = map.get(name);
		d.setPhoneNumber(newNumber);
		map.put(name, d);
	}
	public static void updateContactEmail(String name,String newEmail) {
		StoreDetails d = map.get(name);
		d.setEmail(newEmail);
		map.put(name, d);
	}
}
