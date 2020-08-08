package com.sudarshan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyConverterSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CurrencyConverterSevlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		out.println("<table align='center' style='border: 1px solid black; width:600px'> <tr><th style='border: 1px solid black'> USD (Doller) </th><th style='border: 1px solid black'>IND (Rupees)</th></tr>");
		
		for(int i=1; i<50; i++) {
			out.println("<tr align='center'> <td style='border: 1px solid black'>");
			out.println(i);
			out.println("</td> <td style='border: 1px solid black'>");
			out.println(i*45);
			out.println("</td> </tr>");
		}
		out.println("</table> ");
		out.close();
	}
}
