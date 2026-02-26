package com.Main;

import java.util.*;

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
		
		user.printUserDetails();
	}
}
