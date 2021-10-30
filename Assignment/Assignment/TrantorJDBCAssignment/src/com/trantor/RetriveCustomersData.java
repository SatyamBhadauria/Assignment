package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetriveCustomersData {
	Connection connection=null;
	Statement statement=null;
	ResultSet rs=null;
	ArrayList<Customer> customerList=null;
	
	public ArrayList<Customer> findAllCustomers(){
		try {
			connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "xyz");
			statement = connection.createStatement();
			rs = statement.executeQuery("select * from CUSTOMER_DETAILS");
			customerList = new ArrayList<Customer>();
			while (rs.next()) {				
				Customer customer = new Customer();
				customer.setCid(rs.getInt("Cid"));
				customer.setFirstname(rs.getString("firstname"));
				customer.setLastname(rs.getString("Lastname"));
				customer.setStreet(rs.getString("street"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setZipcode(rs.getInt("zipcode"));
				customer.setProduct_name(rs.getString("PRODUCT_NAME"));
				customer.setCreated_on(rs.getDate("Created_on"));
				customer.setCreated_by(rs.getString("Created_by"));
				customer.setUpdated_on(rs.getDate("Updated_on"));
				customer.setUpdate_by(rs.getString("Update_by"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
				
		return customerList;
		
	}
	

}
