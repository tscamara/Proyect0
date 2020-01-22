package com.revature.bankapp;

public class Customer {
	String name;
	String password;
	String email;
	String address;
	String phoneNumber;
	
	
	double accountNumber = 0;
	
	Customer(String name, String password, String email, String address, String phoneNumber){
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	

}
