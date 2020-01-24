package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.filechooser.FileFilter;

public class BankMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the banking App  ");
		System.out.println("If you are costumer type login");
		System.out.println("If you want to apply for a Account type Create Account");
		System.out.println("type Employee or Administrator");
		//System.out.println("Type login or create account");
		String option1 = scan.nextLine();
		ArrayList<Customer> customerlist = null;// lista de custumer para poder buscar el custumer que esta ingresando
		File customerFile=null;
		Customer newCustomer1 = null;
		Customer  emp=new Employee();
	
			  
            
		switch (option1) {

		case "login":
			
			System.out.println("Enter your name");
			
			String custName = scan.nextLine();
			System.out.println("enter yor Password");
			String custPass = scan.nextLine();
		
				customerFile = new File("Customers/"+ custName+".txt"); 
				if (customerFile.exists()) {

					FileInputStream fis=new FileInputStream(customerFile);
					ObjectInputStream ois=new ObjectInputStream(fis);
					 newCustomer1=(Customer)ois.readObject();
					ois.close();
					//System.out.println(newCustomer1.getName());
					String cuName=newCustomer1.getName();
					String cuPass=newCustomer1.getPassword();
					if (cuName.equalsIgnoreCase(custName)&& cuPass.equalsIgnoreCase(custPass)) {
						System.out.println("You had logging to your account");
						System.out.println("this is your current Balance "+newCustomer1.getBalance());
					
						
					}
					
				}
			
			
				else System.out.println("no found");		
			
			
			WithdrawDeposit.withDep(newCustomer1);

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
			customerlist.add(newCustomer);
		
			//CreateFile g = new CreateFile();
			
			 customerFile = new File("Customers/" + name + ".txt"); 
			 FileOutputStream fos=new FileOutputStream(customerFile);
			 ObjectOutputStream oos=new ObjectOutputStream(fos);
		     oos.writeObject(newCustomer);
		     
			 
		case "employee":
			System.out.println("wat to do want to do");
			System.out.println("view customer or view all customer");
		//	Scanner scan2=new Scanner(System.in);
			// option2=scan2.nextLine();
			Employee.viewCustomerInfo(newCustomer1);
			
			break;
		
		default:
			System.out.println("boo");
			break;
		}
		
	
		
		
		
		
	
		
	}
	
	

}
