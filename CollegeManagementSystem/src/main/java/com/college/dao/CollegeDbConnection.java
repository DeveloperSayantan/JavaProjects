package com.college.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CollegeDbConnection {
	
	public Connection dbConnection() {
		
		Connection conn= null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Loaded the Database...");
			
			String url = "jdbc:mysql://localhost:3306/cms";
			String user = "root";
			String password= "123456";
			 
			 conn = DriverManager.getConnection(url, user, password);
			 
			 if(conn!=null) {
				 
				 System.out.println("Connection successfully Established with the MySql Database");
			 }
			 else {
				 
				 System.out.println("Failed to established the Connection with the Database");
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
		
		CollegeDbConnection collegeDbConnection = new CollegeDbConnection();
		collegeDbConnection.dbConnection();
		

	}

}
