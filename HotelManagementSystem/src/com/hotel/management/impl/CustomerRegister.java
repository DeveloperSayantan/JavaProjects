package com.hotel.management.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotel.management.dao.HotelDbConnection;
import com.hotel.management.view.CustomerRegistrationVO;

public class CustomerRegister {
	
public boolean insertCustomerData(CustomerRegistrationVO customerRegistrationVO) {
		
		Connection conn = null;
		String message = null;
		Statement st = null;
		boolean flag = false;
		
		String cust_id = customerRegistrationVO.getCust_id();
		String firstname = customerRegistrationVO.getFirstname();
		String lastname = customerRegistrationVO.getLastname();
		String email = customerRegistrationVO.getEmail();
		String mobile = customerRegistrationVO.getMobile();
		String occupation = customerRegistrationVO.getOccupation();
		String address = customerRegistrationVO.getAddress();
		String holiday = customerRegistrationVO.getHoliday();
		String roomtype = customerRegistrationVO.getRoomtype();
//		
		try {
			 HotelDbConnection hotelDbConnection = new HotelDbConnection();
			conn = hotelDbConnection.dbConnection();
			String sqlQuery = "Insert INTO registration(cust_id,firstname,lastname,email,mobile,occupation,address,holiday,roomtype)VALUES('"+cust_id+"','"+firstname+"','"+lastname+"','"+email+"','"+mobile+"','"+occupation+"','"+address+"','"+holiday+"','"+roomtype+"')";
			System.out.println("query:"+sqlQuery);
			
			st = conn.createStatement();
			int row = st.executeUpdate(sqlQuery);
			if(row>0) {
				message = "Data Successfully Inserted in the Database";
				System.out.println(message);
				flag = true;
			}else {
				message = "Data insertion failed";
				System.out.println(message);
			}
		}
		catch (Exception e) {
			message = "Data inserion failed in catch";
			e.printStackTrace();
		}
		finally {
				try {
					conn.close();
					st.close();
				}
				catch (SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
	}
	
	return flag;
	}
	
	public static void main(String[] args) {
		
		HotelDbConnection hotelDbConnection = new HotelDbConnection();
		hotelDbConnection.dbConnection();
	}
	
}

