package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class CreateNewCustomerInDB {
	
	public int save(Customer customer) {
		Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		
		int count=0;
		try {
			String sql = "insert into CUSTOMER_DETAILS values(?,?,?,?,?,?,?,?,?,?,?,?)";
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "xyz");
			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, customer.getCid());
            preparedStatement.setString(2, customer.getFirstname());
            preparedStatement.setString(3, customer.getLastname());
            preparedStatement.setString(4, customer.getStreet());
            preparedStatement.setString(5, customer.getCity());
            preparedStatement.setString(6, customer.getState());
            preparedStatement.setInt(7, customer.getZipcode());
            preparedStatement.setString(8, customer.getProduct_name());
            preparedStatement.setDate(9, ourJavaDateObject);
            preparedStatement.setString(10, customer.getCreated_by());
            preparedStatement.setDate(11, ourJavaDateObject);
            preparedStatement.setString(12, customer.getUpdate_by());
            
            count = preparedStatement.executeUpdate();
            
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				preparedStatement.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return count;
		
	}

}
