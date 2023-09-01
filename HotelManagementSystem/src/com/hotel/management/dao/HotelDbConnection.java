package com.hotel.management.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HotelDbConnection {
	
	public Connection dbConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded the Database");
			
			String url = "jdbc:mysql://localhost:3306/cms";
			String user = "root";
			String password= "123456";
			
			conn = DriverManager.getConnection(url, user, password);
			
			if (conn!=null){
				
				System.out.println("Connection Established with Database");
				
			} else {
				
				System.out.println("Failed to Established the Connection with Database");
			}
				
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public static void main(String[] args) {
		HotelDbConnection hotelDbConnection = new HotelDbConnection();
		hotelDbConnection.dbConnection();
	}

}
