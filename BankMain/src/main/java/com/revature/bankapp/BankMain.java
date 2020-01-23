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
       File [] files = null;
		switch (option1) {
		
		case "login":System.out.println("Enter your name" );
			//System.out.println("You're logging in");
			String custName=scan.nextLine();
			System.out.println("enter yor Password");
			String custPass=scan.nextLine();
			FileReader readFile= new FileReader(files.toString());
			for (int i = 0; i < files.length; i++) {
				
				if (files[i].getName()==custName) {
					
					FileReader fread= new FileReader(files[i]);
					BufferedReader bread = new BufferedReader(fread);
					//while ((fread = bread.readLine()) != null) {
						System.out.println(fread);
					//}
					
				}
				else System.out.println("your are not a customer please create a account");
			}
			
			break;
		case "create account":
			System.out.println("Enter your name");
			String name = scan.nextLine();
			System.out.println("Enter your password");
			String password = scan.nextLine();
			System.out.println("Enter your email");
			String email = scan.nextLine();
			System.out.println("Enter your address");
			String address = scan.nextLine();
			System.out.println("Enter your phone number");
			String phoneNumber = scan.nextLine();
			System.out.println("Enter your account balance");
			double acctBalance = scan.nextDouble();
			
			Customer newCustomer = new Customer();
			newCustomer.setName(name);
			newCustomer.setPassword(password);
			newCustomer.setEmail(email);
			newCustomer.setAddress(address);
			newCustomer.setPhoneNumber(phoneNumber);
			newCustomer.setBalance(acctBalance);


			String nextLine;
			CreateFile g = new CreateFile();
			g.openFile(name);
			g.addRecords(newCustomer.getName(), newCustomer.getPassword(), newCustomer.getEmail(), newCustomer.getAddress(),
					newCustomer.getPhoneNumber(), newCustomer.getBalance());
			g.closeFile();
			File customerFile = new File("Customers/" + name + ".txt");
			files=customerFile.listFiles();
			FileReader fr = new FileReader(customerFile);
			BufferedReader br = new BufferedReader(fr);
			while ((nextLine = br.readLine()) != null) {
				System.out.println(nextLine);
			}
			String checker = br.readLine();
			System.out.println(checker);
			break;
		default:
			System.out.println("Booo");
		}
	}

}
