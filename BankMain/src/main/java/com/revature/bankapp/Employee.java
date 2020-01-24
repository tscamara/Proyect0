package com.revature.bankapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class Employee extends Customer{
	
	
	public static void viewCustomerInfo(Customer newCustomer1) throws IOException, ClassNotFoundException {
		
		Scanner scan = new Scanner(System.in);
		String option2=scan.nextLine();
		File customerFile=null;
		
		switch (option2) {
		case "view customer":
			System.out.println("Enter costumer name");
			String theName=scan.nextLine();
			
			customerFile = new File("Customers/" + theName+ ".txt"); 
			if (customerFile.exists()) {
				FileInputStream fis=new FileInputStream(customerFile);
				ObjectInputStream ois=new ObjectInputStream(fis);
				 newCustomer1=(Customer)ois.readObject();
				ois.close();
				System.out.println("Thank you!");
				System.out.println("Customer Name: " + newCustomer1.getName());
				System.out.println("Customer Password: " + newCustomer1.getPassword());
				System.out.println("Customer Email: " + newCustomer1.getEmail());
				System.out.println("Customer Address: " + newCustomer1.getAddress());
				System.out.println("customer balance  "+newCustomer1.getBalance());
				System.out.println("What else do you want to do ");
				System.out.println("view customer or view all customer or quit");
				viewCustomerInfo(newCustomer1);
			}
			break;
		
		case "quit":
			System.out.println("bye");
			break;
		default: System.out.println("What are you doing");	
				}
		
	}
	
}
				
			
								     
	
		
		
	
