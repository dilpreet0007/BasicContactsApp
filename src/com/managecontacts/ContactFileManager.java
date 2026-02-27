package com.managecontacts;

import java.io.*;
import java.util.*;

/*
 * Contact details is stored in File format using this class
 */

public class ContactFileManager {
    private static final String FILE_NAME = "contacts.txt";

    // Save all contacts to file
    public static void saveContacts(Map<String, StoreDetails> contacts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Map.Entry<String, StoreDetails> entry : contacts.entrySet()) {
                writer.println(entry.getKey() + "," + entry.getValue().getPhoneNumber() + "," + entry.getValue().getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load contacts from file
    public static Map<String, StoreDetails> loadContacts() {
        Map<String, StoreDetails> contacts = new HashMap<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return contacts;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    contacts.put(parts[0], new StoreDetails(parts[1], parts[2],parts[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    // Print contacts from file
    public static void printContacts() {
        Map<String, StoreDetails> contacts = loadContacts();
        for (Map.Entry<String, StoreDetails> entry : contacts.entrySet()) {
            System.out.println("Name: " + entry.getKey() +
                               ", Phone: " + entry.getValue().getPhoneNumber() +
                               ", Email: " + entry.getValue().getEmail());
        }
    }
}
