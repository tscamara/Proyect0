package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BankMain {
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the banking app");
		System.out.println("What would you like to do");
		System.out.println("Type login or create account");
		String option1 = scan.nextLine();
		
		switch(option1) {
		case "login": System.out.println("You're logging in");
		break;
		case "create account": System.out.println("Enter your name");
		String name = scan.nextLine();
		System.out.println("Enter your password");
		String password = scan.nextLine();
		System.out.println("Enter your email");
		String email = scan.nextLine();
		System.out.println("Enter your address");
		String address = scan.nextLine();
		System.out.println("Enter your phone number");
		String phoneNumber = scan.nextLine();
		Customer newCustomer = new Customer(name, password, email, address, phoneNumber);
		File customerFile = new File("customer.txt");
		FileReader fr = new FileReader(customerFile);
		BufferedReader br = new BufferedReader(fr);
		String checker = br.readLine();
		System.out.println(checker);
		break;
		default : System.out.println("Booo");
		}
	}

}
