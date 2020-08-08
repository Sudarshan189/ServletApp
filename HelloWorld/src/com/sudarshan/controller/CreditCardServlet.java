package com.sudarshan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/credit")
public class CreditCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreditCardServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		

		String cardNum = request.getParameter("cardnumber");

		String cvv = request.getParameter("cvv");

		String name = request.getParameter("username");

		
		
		String mm = request.getParameter("mm");
		
		String yyyy = request.getParameter("yyyy");
		out.println(
				"<table border='1' align='center'> <tr> <th>Card Number</th><th>CVV</th><th>Name</th><th>Expiry</th> </tr>");
		out.println("<tr><td>" + cardNum + "</td><td>" + cvv + "</td><td>"
				+ name + "</td><td>" + mm+"/"+yyyy + "</td></tr></table>");
		
		
		
	}

}
