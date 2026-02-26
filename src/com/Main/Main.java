package com.Main;

import java.util.*;

import com.Auth.BasicAuth;
import com.Auth.OAuth;
import com.Auth.Session;
import com.registration.UserRegistration;

public class Main {
	public static void main(String[] args) {
		boolean loggedIn = false;
		Scanner sc = new Scanner(System.in);
		
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
		
		UserRegistration user = new UserRegistration(name,userName,email,password,type);
		
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
		
		if(loggedIn) {
			System.out.println("Options: Type");
			System.out.println("1. Change Name");
			System.out.println("2. Change UserName");
			System.out.println("3. Change Password");
			System.out.println("4. Change Email");
			
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
			
			
			user.printUserDetails();
		}
		
	}
}
