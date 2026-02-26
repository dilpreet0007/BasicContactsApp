package com.Auth;

import com.registration.Operations;
import com.registration.UserRegistration;

public class BasicAuth {
	public static String username = UserRegistration.getUserName();
	public static String pass = UserRegistration.getPassword();
	
	public static boolean checkAuth(String userName,String password) {
		String hashPassword = Operations.hashPassword(password);
		if(username.equals(userName) && pass.equals(hashPassword)) {
			return true;
		}
		else if(!username.equals(userName)) {
			System.out.println("Wrong UserName");
		}
		else if(!pass.equals(hashPassword)) {
			System.out.println("Wrong Password");
		}
		return false;
	}
}
