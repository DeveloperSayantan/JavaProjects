package com.hotel.management.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLogoutServlet")
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessions = request.getSession();
		System.out.println(sessions.getAttribute("userName"));
		System.out.println(sessions.getAttribute("userEmail"));
		System.out.println("Logout servlet");
		if (sessions != null) {

			sessions.removeAttribute("userName");
			sessions.removeAttribute("userEmail");

			request.setAttribute("Logoutmessage", "Successfully logout");
			ServletContext ctx = getServletContext();
			RequestDispatcher rd = ctx.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
//			response.sendRedirect("index.jsp");
		}
	}

}
