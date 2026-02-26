package com.Main;

import java.util.*;

import com.Auth.BasicAuth;
import com.Auth.OAuth;
import com.Auth.Session;
import com.registration.UserRegistration;

public class Main {
	public static void main(String[] args) {
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
				System.out.println("Login Successfull!!");
			}
			else{
				System.out.println("Login Failed!!");
			}
		}else {
			if(OAuth.checkAuth(id, pass)) {
				Session session = new Session(OAuth.token);
				session.createSession();
				System.out.println("Login Successfull!!");
			}
			else{
				System.out.println("Login Failed!!");
			}
		}
		
	}
}
