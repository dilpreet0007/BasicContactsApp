package com.Auth;

import com.registration.UserRegistration;

/*
 * Session is made for a particular token
 */

public class Session {
	public static String username = UserRegistration.getUserName();
	static String token;
	
	public Session(String token) {
		Session.token = token;
	}
	
	public void createSession() {
		if(token.contains(username)) {
			System.out.println("Session Started!!");
		}
		else {
			System.out.println("Token Mismatch");
		}
	}
	
	
}
