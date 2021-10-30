package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class UpdateCustomersDataHardWay {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int count = 0;
        try {
            String sql = "update Customer_Details set firstname = ?,lastname = ?,street = ?,city = ?,state = ?,zipcode = ?,product_name = ?,created_on = ?,created_by = ?,updated_on = ?,updated_by = ? where cid = ? ";
            connection =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "xyz");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"Shivam");
            preparedStatement.setString(2,"Tyagi");
            preparedStatement.setString(3,"Gali no. 7");
            preparedStatement.setString(4,"Etawah");
            preparedStatement.setString(5,"Uttar Pradesh");
            preparedStatement.setInt(6,206001);
            preparedStatement.setString(7,"AirPods");
            preparedStatement.setDate(8,date);
            preparedStatement.setString(9,"Satya");
            preparedStatement.setDate(10,date);
            preparedStatement.setString(11,"Satya");
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