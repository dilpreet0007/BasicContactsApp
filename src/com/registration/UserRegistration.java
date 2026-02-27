package com.registration;

/*
 * User profile information is stored using objects getter and setters are also made 
 * for any further modifications
 */

public class UserRegistration {
	private String name;
	private static String userName;
	private String email;
	private static String password;
	private String type;
	
	public UserRegistration(String name, String userName, String email, String password, String type) {
		this.name = name;
		this.userName = userName;
		if(Operations.isValidEmail(email)) this.email = email;
		if(Operations.isValidPassword(password)) this.password = Operations.hashPassword(password);
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(Operations.isValidEmail(email)) this.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if(Operations.isValidPassword(password)) this.password = Operations.hashPassword(password);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void printUserDetails() {
		System.out.println("[ " + getName() + ", " + getUserName() + ", " + getEmail() + ", " + getType() + "]");
	}
	
	
}