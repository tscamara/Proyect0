package com.revature.bankapp;

import java.io.*;
import java.lang.*;
import java.util.*;

public class CreateFile {

	private Formatter x;

	public void openFile(String name) {
		try {
			x = new Formatter("Customers/" + name + ".txt");
		} catch (Exception e) {
			System.out.println("You have an error");
		}

	}

	public void addRecords(String name, String password, String email, String address, String phoneNumber, double acctBalance) {
		x.format("Name: %s%nPassword: %s%nEmail: %s%nAddress: %s%nPhone Number: %s%nAccount Balance: %s", name, password, email, address,
				phoneNumber, acctBalance);
	}

	public void closeFile() {
		x.close();
	}
}
