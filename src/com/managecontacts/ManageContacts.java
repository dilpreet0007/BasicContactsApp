package com.managecontacts;

import java.util.*;

/*
 *  Create Contact feature is added in this class
 *  View Contact details is also added in this class
 *  Updating the contactDetails
 *  Delete Contact feature added to it
 */

public class ManageContacts{
	public static HashMap<String,StoreDetails> map = new HashMap<>();
	public static HashMap<String,ArrayList<String>> tagMap = new HashMap<>();
	
	public static void addContact(String name,String phoneNumber,String email,String tag) {
		map.put(name, new StoreDetails(phoneNumber,email,tag));
		if(!tagMap.containsKey(tag)) {
			tagMap.put(tag,new ArrayList<>());
		}
		tagMap.get(tag).add(name);
		ContactFileManager.saveContacts(map);
	}
	
	public static void deleteContact(String name) {
		if(!map.containsKey(name)) System.out.println("Contact not available in list");
		map.remove(name);
		System.out.println(map);
	}
	
	public static void getContact(String name) {
		StoreDetails d = map.get(name);
		System.out.println(name + " " + d.phoneNumber + " " + d.email);
	}
	
	public static void updateContactName(String name,String newName) {
		if(!map.containsKey(name)) System.out.println("Contact not available in list");
		StoreDetails d = map.get(name);
		map.remove(name);
		map.put(newName, d);
		ContactFileManager.saveContacts(map);
	}
	public static void updateContactPhoneNumber(String name,String newNumber) {
		if(!map.containsKey(name)) System.out.println("Contact not available in list");
		StoreDetails d = map.get(name);
		d.setPhoneNumber(newNumber);
		map.put(name, d);
		ContactFileManager.saveContacts(map);
	}
	public static void updateContactEmail(String name,String newEmail) {
		if(!map.containsKey(name)) System.out.println("Contact not available in list");
		StoreDetails d = map.get(name);
		d.setEmail(newEmail);
		map.put(name, d);
		ContactFileManager.saveContacts(map);
	}
}
