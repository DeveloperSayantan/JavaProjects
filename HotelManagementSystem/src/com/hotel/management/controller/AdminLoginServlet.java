package com.hotel.management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.management.impl.AdminLogin;
import com.hotel.management.view.AdminVO;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password"); 
		
		System.out.println(id);
		System.out.println(email);
		System.out.println(password);
		
		AdminLogin adminLogin = new AdminLogin();
		AdminVO adminVO = adminLogin.populateLoginData(id, email, password);
		
		HttpSession session = request.getSession();
		if(adminVO.isFlag()!=false ) {
			session.setAttribute("userEmail", adminVO.getEmail());
			//session.setAttribute("userName", adminVO.getFirstname());
			getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
		}	
		 else {
			 request.setAttribute("fail", adminVO.getMessage());
			 getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
