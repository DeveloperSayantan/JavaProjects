package com.hotel.management.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hotel.management.dao.HotelDbConnection;
import com.hotel.management.view.AdminVO;

public class AdminLogin {
	
	public AdminVO populateLoginData(String id, String email, String password) {
		
		Connection conn = null;
		String message = null;
		Statement st = null;
		ResultSet rs = null;
		
		AdminVO adminVO = new AdminVO();
		
		try {
			HotelDbConnection hotelDbConnection = new HotelDbConnection();
			conn = hotelDbConnection.dbConnection();
			String sqlQuery = "SELECT id,email FROM admin where id='"+id+"' and email='"+email+"' and password='"+password+"' ";
			System.out.println("query:"+sqlQuery);
			
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);
			if (rs.next()) {
				message = "Data has been successfully inserted";
				System.out.println(message);
				adminVO.setMessage(message);
				adminVO.setFlag(true);
				adminVO.setId(rs.getString("id"));
				adminVO.setEmail(rs.getString("email"));
			} else {
				message = "UserId or Password missmatched";
				System.out.println(message);
				adminVO.setMessage(message);
				adminVO.setFlag(false);
			}
		} catch (Exception e) {
			message = "UserId or Password missmatched in catch";
			System.out.println(message);
			adminVO.setMessage(message);
			adminVO.setFlag(false);
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
				st.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return adminVO;
		
	}

}
