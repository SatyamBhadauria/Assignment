package com.trantor;

import java.util.ArrayList;

public class DisplayCustomerData {

	public static void main(String[] args) {
		RetriveCustomersData retriveCustomersData = new RetriveCustomersData();
		ArrayList<Customer> findAllCustomers = retriveCustomersData.findAllCustomers();
		
		findAllCustomers.forEach(customer ->{
			System.out.println(customer.getCid());
			System.out.println(customer.getFirstname());
			System.out.println(customer.getLastname());
			System.out.println(customer.getStreet());
			System.out.println(customer.getCity());
			System.out.println(customer.getState());
			System.out.println(customer.getZipcode());
			System.out.println(customer.getProduct_name());
			System.out.println(customer.getCreated_on());
			System.out.println(customer.getCreated_by());
			System.out.println(customer.getUpdated_on());
			System.out.println(customer.getUpdate_by());
			
		}	);

	}

}
