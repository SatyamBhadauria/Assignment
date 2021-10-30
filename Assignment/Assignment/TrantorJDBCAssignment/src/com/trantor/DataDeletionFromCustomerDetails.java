package com.trantor;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DataDeletionFromCustomerDetails {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int count = 0;
        try {
            String sql = "delete from CUSTOMER_DETAILS where cid = ? ";
            connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "xyz");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,32);
            count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

