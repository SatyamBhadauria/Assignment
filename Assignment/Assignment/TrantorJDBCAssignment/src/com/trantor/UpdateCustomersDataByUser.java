package com.trantor;


import java.util.Scanner;

public class UpdateCustomersDataByUser {
    private static Scanner scanner;

	public static void main(String[] args) {

        Customer dataUpdate = new Customer();

        scanner = new Scanner(System.in);

        System.out.print("Enter Cid need to be update : ");
        int cid = scanner.nextInt();
        
        System.out.print("Enter New Name : ");
        String Updated_by = scanner.next();
        
        System.out.print("Enter New Street : ");
        String street = scanner.next();
        
        System.out.print("Enter Updated City : ");
        String city = scanner.next();
        
        System.out.print("Enter New State : ");
        String state = scanner.next();
        
        System.out.print("Enter New PinCode : ");
        int zipcode = scanner.nextInt();
        
        System.out.print("Enter Productname : ");
        String product_name = scanner.next();
        

        dataUpdate.setCid(cid);
        dataUpdate.setStreet(street);
        dataUpdate.setCity(city);
        dataUpdate.setState(state);
        dataUpdate.setZipcode(zipcode);
        dataUpdate.setProduct_name(product_name);
        dataUpdate.setUpdate_by(Updated_by);

    }
}

 