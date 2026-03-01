package com.Main;

import java.time.LocalDate;
import java.util.*;

import com.Auth.BasicAuth;
import com.Auth.OAuth;
import com.Auth.Session;
import com.managecontacts.ManageContacts;
import com.managecontacts.StoreDetails;
import com.registration.UserRegistration;

public class Main {
	public static void main(String[] args) {
		boolean loggedIn = false;
		UserRegistration user;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("To login enter 1 || To register enter 2: ");
		int login = sc.nextInt();
		sc.nextLine();
		
		
		if(login==2) {
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
			
			System.out.print("Enter your userName: ");
			String userName = sc.nextLine();
			
			System.out.print("Enter your email: ");
			String email = sc.nextLine();
			
			System.out.print("Enter your password: ");
			String password = sc.nextLine();
			
			System.out.print("Enter type: Free || Premium ");
			String type = sc.nextLine();
			
			user = new UserRegistration(name,userName,email,password,type);
			loggedIn = true;
		}
		
		else {
			user = new UserRegistration("David","David12","David@com","David@123","Free");
			System.out.println();
			System.out.println("Please Login to Continue!! Enter 1 for basicAuth 2 for OAuth");
			
			int x = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Enter your userName: ");
			String id = sc.nextLine();
			
			System.out.print("Enter your password: ");
			String pass = sc.nextLine();
			if(x==1) {
				if(BasicAuth.checkAuth(id, pass)) {
					loggedIn=true;
					System.out.println("Login Successfull!!");
				}
				else{
					System.out.println("Login Failed!!");
				}
			}else {
				if(OAuth.checkAuth(id, pass)) {
					Session session = new Session(OAuth.token);
					session.createSession();
					loggedIn =true;
					System.out.println("Login Successfull!!");
				}
				else{
					System.out.println("Login Failed!!");
				}
			}
		}
				
		while(loggedIn) {
			System.out.println("Options: Type");
			System.out.println(" 0. Logout");
			System.out.println(" 1. Change Name");
			System.out.println(" 2. Change UserName");
			System.out.println(" 3. Change Password");
			System.out.println(" 4. Change Email");
			System.out.println(" 5. Add Contact");
			System.out.println(" 6. Contact List");
			System.out.println(" 7. Update Contact List");
			System.out.println(" 8. Delete a Contact");
			System.out.println(" 9. Filter using tag");
			System.out.println("10. Search Contact");
			System.out.println("11. Filter By Tags/Date/FreqContacted");
			
			
			System.out.println("Enter: ");
			int a = sc.nextInt();
			sc.nextLine();
			
			
			if(a==1) {
				System.out.print("Enter new Name: ");
				String newName = sc.nextLine();
				user.setName(newName);
			}
			else if(a==2) {
				System.out.print("Enter new UserName: ");
				String newUserName = sc.nextLine();
				user.setUserName(newUserName);
			}
			else if(a==3) {
				System.out.print("Enter new Password: ");
				String newPass = sc.nextLine();
				user.setPassword(newPass);
			}
			else if(a==4) {
				System.out.print("Enter new Email: ");
				String newEmail = sc.nextLine();
				user.setEmail(newEmail);
			}
			else if(a==5) {
				System.out.print("Enter Contact Name: ");
				String contactName = sc.nextLine();
				System.out.print("Enter Contact Phone Number: ");
				String contactNum = sc.nextLine();
				System.out.print("Enter Contact Email: ");
				String contactEmail = sc.nextLine();
				System.out.print("Enter Contact Tag: ");
				String contactTag = sc.nextLine();
				ManageContacts.addContact(contactName, contactNum, contactEmail,contactTag);
				
			}
			else if(a==6) {
				System.out.println(ManageContacts.map);
			}
			else if(a==7) {
				ManageContacts.addContact("David", "999900000", "david@com","Friend");
				System.out.print("Enter 1 for name || 2 for number || 3 for email: ");
				int b = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter name of current contact: ");
				String currName = sc.nextLine();
				if(b==1) {
					System.out.print("Enter new name of contact: ");
					String newName = sc.nextLine();
					ManageContacts.updateContactName(currName, newName);
				}
				else if(b==2) {
					System.out.print("Enter new number of contact: ");
					String newNum = sc.nextLine();
					ManageContacts.updateContactPhoneNumber(currName, newNum);
				}
				else if(b==3) {
					System.out.print("Enter new email of contact: ");
					String newEmail = sc.nextLine();
					ManageContacts.updateContactEmail(currName, newEmail);
				}
			}
			else if(a==8) {
				System.out.print("Enter name of contact you want to delete: ");
				String n = sc.nextLine();
				ManageContacts.deleteContact(n);
			}
			else if(a==9) {
				System.out.print("Enter tag: ");
				String t = sc.nextLine();
				
				System.out.println(ManageContacts.tagMap.get(t));
			}
			else if(a==10) {
				System.out.print("Enter Name/Number/Email/Tag: ");
				String input  = sc.nextLine();
				ManageContacts.search(input);
			}
			else if(a==11) {
				System.out.print("Enter Tag/Date/FreqContacted: ");
				String input  = sc.nextLine();
				
				if(input.equals("Tag")) {
					System.out.print("Enter Tag: ");
					String t = sc.nextLine();
					System.out.println(ManageContacts.tagMap.get(t));
				}
				
				else if(input.equals("Date")) {
					System.out.print("Enter Tag: ");
					String t = sc.nextLine();
					System.out.println(ManageContacts.dateAdded.get(LocalDate.parse(t)));
				}
				else System.out.println(ManageContacts.freqContacted);
			}
			else if(a==0) {
				loggedIn = false;
				break;
			}
		}
		
	}
}
