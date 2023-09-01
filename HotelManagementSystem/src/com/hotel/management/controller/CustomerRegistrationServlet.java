package com.hotel.management.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.management.impl.CustomerRegister;
import com.hotel.management.view.CustomerRegistrationVO;

/**
 * Servlet implementation class CustomerRegistrationServlet
 */
@WebServlet("/CustomerRegistrationServlet")
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerRegister customerRegister = new CustomerRegister();
    
    public CustomerRegistrationServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cust_id = request.getParameter("cust_id");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String occupation = request.getParameter("occupation");
		String address =request.getParameter("address");
		String holiday = request.getParameter("holiday");
		String roomtype = request.getParameter("roomtype");
		
		CustomerRegistrationVO customerRegistrationVO = new CustomerRegistrationVO();
		PrintWriter out = response.getWriter();
		
		customerRegistrationVO.setCust_id(cust_id);
		customerRegistrationVO.setFirstname(firstname);
		customerRegistrationVO.setLastname(lastname);
		customerRegistrationVO.setEmail(email);
		customerRegistrationVO.setMobile(mobile);
		customerRegistrationVO.setOccupation(occupation);
		customerRegistrationVO.setAddress(address);
		customerRegistrationVO.setHoliday(holiday);
		customerRegistrationVO.setRoomtype(roomtype);
		
		HttpSession session = request.getSession();
		try {
			boolean flag =  customerRegister.insertCustomerData(customerRegistrationVO);
			if(flag != false){
				session.setAttribute("userEmail", email);
				session.setAttribute("userName", firstname);
				request.setAttribute("succcess", "Registration successful");
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}else{
				request.setAttribute("failuremsg", "Registration un-successful");
				getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		}
}