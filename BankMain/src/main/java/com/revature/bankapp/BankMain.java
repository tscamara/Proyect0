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
		System.out.println("Welcome to the banking app");
		System.out.println("What would you like to do");
		System.out.println("Type login or create account");
		String option1 = scan.nextLine();
		ArrayList<Customer> customerlist = null;// lista de custumer para poder buscar el custumer que esta ingresando
		File customerFile=null;
		// FileNameFilter filter = new FileNameFilter() 
			  
            
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
					Customer newCustomer1=(Customer)ois.readObject();
					ois.close();
					//System.out.println(newCustomer1.getName());
					String cuName=newCustomer1.getName();
					String cuPass=newCustomer1.getPassword();
					if (cuName.equalsIgnoreCase(custName)&& cuPass.equalsIgnoreCase(custPass)) {
						System.out.println("You had logging to your account");
						System.out.println("this is your current Balance "+newCustomer1.getBalance());
						System.out.println("you want to deposit or Withdraw");
						
					}
					
				}
			
			
				else System.out.println("no found");		
			
			
			

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

		
			CreateFile g = new CreateFile();
			/*g.openFile(name);
			g.addRecords(newCustomer.getName(), newCustomer.getPassword(), newCustomer.getEmail(),
					newCustomer.getAddress(), newCustomer.getPhoneNumber(), newCustomer.getBalance());
			g.closeFile();*/
			 customerFile = new File("Customers/" + name + ".txt"); 
			 FileOutputStream fos=new FileOutputStream(customerFile);
			 ObjectOutputStream oos=new ObjectOutputStream(fos);
		     oos.writeObject(newCustomer);
			 
			/*files = customerFile.listFiles();
			FileReader fr = new FileReader(customerFile);
			BufferedReader br = new BufferedReader(fr);
			while ((nextLine = br.readLine()) != null) {
				System.out.println(nextLine);
			}
			String checker = br.readLine();
			System.out.println(checker);*/
			break;
		default:
			System.out.println("Booo");
		}
	}

}
