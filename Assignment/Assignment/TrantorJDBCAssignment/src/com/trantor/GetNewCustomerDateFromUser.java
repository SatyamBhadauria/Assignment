package com.trantor;

import java.util.Scanner;

public class GetNewCustomerDateFromUser {

	public static void main(String[] args) {

		
		
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Cid");
			int cid = scanner.nextInt();
			
			System.out.println("FirstName");
			String FirstName = scanner.next();
			
			System.out.println("LastName");
			String LastName = scanner.next();
			
			System.out.println("Street");
			String street = scanner.next();
			
			System.out.println("City");
			String city = scanner.next();
			
			System.out.println("State");
			String state = scanner.next();
			
			System.out.println("Zipcode");
			int zipcode = scanner.nextInt();
			
			System.out.println("Product_Name");
			String product_name = scanner.next();		
			
			System.out.println("Created_by");
			String created_by = scanner.next();
			
			System.out.println("Update_by");
			String update_by = scanner.next();
			
			
			Customer customer = new Customer();
			customer.setCid(cid);
			customer.setFirstname(FirstName);
			customer.setLastname(LastName);
			customer.setStreet(street);
			customer.setCity(city);
			customer.setState(state);
			customer.setZipcode(zipcode);
			customer.setProduct_name(product_name);
			customer.setCreated_by(created_by);
			customer.setUpdate_by(update_by);
		}

		
		
	}

}
