package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DataUpdate {
    @SuppressWarnings("finally")
	public int UpdatedData(Customer customer){

        Calendar calendar = Calendar.getInstance();
        java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int count = 0;

        try {
            String sql = "update Customer_Details set customer = ? ,street = ?,city = ?,state = ?,zipcode = ?,product_name = ?,updated_on = ?,updated_by = ? where cid = ?";
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "xyz");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getStreet());
            preparedStatement.setString(2, customer.getStreet());
            preparedStatement.setString(3, customer.getCity());
            preparedStatement.setString(4, customer.getState());
            preparedStatement.setInt(5, customer.getZipcode());
            preparedStatement.setString(6, customer.getProduct_name());
            preparedStatement.setDate(7, ourJavaDateObject);
            preparedStatement.setString(8, customer.getUpdate_by());
            preparedStatement.setInt(9, customer.getCid());

            count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (final SQLException e) {
                e.printStackTrace();
            }


            return count;
    }
}
}

