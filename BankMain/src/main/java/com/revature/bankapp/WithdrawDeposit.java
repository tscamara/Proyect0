package com.revature.bankapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class WithdrawDeposit {
	File customerFile=null;
	

	public static void withDep(Customer newCustomer1) throws IOException {
		System.out.println("Deposit, WithDraw or quit");
		Scanner scan = new Scanner(System.in);
		File customerFile=null;
		String depOrWith = scan.next();
		
		switch(depOrWith) {
		case "deposit": System.out.println("How much would you like to deposit");
		double depAmount = scan.nextDouble();
		newCustomer1.deposit(depAmount);
		System.out.println("Thank you!");
		System.out.println("Customer Name: " + newCustomer1.getName());
		System.out.println("Current Balance: " + newCustomer1.getBalance());
		CreateFile g = new CreateFile();
		customerFile = new File("Customers/" + newCustomer1.getName() + ".txt"); 
		 FileOutputStream fos=new FileOutputStream(customerFile);
		 ObjectOutputStream oos=new ObjectOutputStream(fos);
	     oos.writeObject(newCustomer1);
	     withDep(newCustomer1);
		break;
		case "withdraw": System.out.println("How much would you like to withdraw");
		double withAmount = scan.nextDouble();
		newCustomer1.withdraw(withAmount);
		System.out.println("Thank you!");
		System.out.println("Customer Name: " + newCustomer1.getName());
		System.out.println("Current Balance: " + newCustomer1.getBalance());
		CreateFile g1 = new CreateFile();
		customerFile = new File("Customers/" + newCustomer1.getName() + ".txt"); 
		 FileOutputStream fos1=new FileOutputStream(customerFile);
		 ObjectOutputStream oos1=new ObjectOutputStream(fos1);
	     oos1.writeObject(newCustomer1);
	     withDep(newCustomer1);
		break;
		case "quit": 
			System.out.println("Goodbye");
			break;
		default: System.out.println("What are you doing");
		}
	}
}
