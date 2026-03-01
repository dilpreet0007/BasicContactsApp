package com.managecontacts;

import java.util.*;
import java.time.*;
/*
 *  Create Contact feature is added in this class
 *  View Contact details is also added in this class
 *  Updating the contactDetails
 *  Delete Contact feature added to it
 *  Tags added in contacts
 *  search option is added in list
 *  Filter by TAG/DATE/FREQCONTACTED
 *  CUSTOM Tags
 */

public class ManageContacts{
	public static HashMap<String,StoreDetails> map = new HashMap<>();
	public static HashMap<String,ArrayList<String>> tagMap = new HashMap<>();
	public static HashMap<LocalDate,ArrayList<String>> dateAdded = new HashMap<>();
	public static HashSet<String> freqContacted = new HashSet<>();
	
	public static void addContact(String name,String phoneNumber,String email,String tag) {
		LocalDate currentDate = LocalDate.now();
		StoreDetails d = new StoreDetails(phoneNumber,email,tag,currentDate);
		map.put(name, d);
		if(!tagMap.containsKey(tag)) {
			tagMap.put(tag,new ArrayList<>());
		}
		tagMap.get(tag).add(name);
		
		if(!dateAdded.containsKey(currentDate)) {
			dateAdded.put(currentDate,new ArrayList<>());
		}
		dateAdded.get(currentDate).add(name);
		
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
	}
	public static void updateContactPhoneNumber(String name,String newNumber) {
		if(!map.containsKey(name)) System.out.println("Contact not available in list");
		StoreDetails d = map.get(name);
		d.setPhoneNumber(newNumber);
		map.put(name, d);
	}
	public static void updateContactEmail(String name,String newEmail) {
		if(!map.containsKey(name)) System.out.println("Contact not available in list");
		StoreDetails d = map.get(name);
		d.setEmail(newEmail);
		map.put(name, d);
	}
	
	public static void search(String s) {
		freqContacted.add(s);
		for(String str : map.keySet()) {
			if(str.equals(s)) {
				System.out.println(str + " " + map.get(str));
			}
			else {
				StoreDetails d = map.get(str);
				if(s.equals(d.getPhoneNumber())) {
					System.out.println(str + " " + map.get(str));
				}
				if(s.equals(d.getEmail())) {
					System.out.println(str + " " + map.get(str));
				}
				if(s.equals(d.getTag())) {
					System.out.println(str + " " + map.get(str));
				}
			}
		}
	}
}
