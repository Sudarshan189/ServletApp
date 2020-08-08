package com.sudarshan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sudarshan.domain.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Employee> employees = new ArrayList<>();

	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		employees.add(new Employee(12345, "Sudarshan", 5000, "Java"));
		employees.add(new Employee(45233, "Sandeep", 5000, "C++"));
		employees.add(new Employee(524, "Sharath", 5000, "C"));
		employees.add(new Employee(1112, "Harini", 5000, ".Net"));
		employees.add(new Employee(8596, "Shri", 5000, "Facebook"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		boolean found = false;
		for (Employee employee : employees) {
			if (employee.getId() == Long.parseLong(id)) {
				out.println(
						"<table border='1' align='center'> <tr> <th>ID</th><th>Name</th><th>Salary</th><th>Department</th> </tr>");
				out.println("<tr><td>" + employee.getId() + "</td><td>" + employee.getName() + "</td><td>"
						+ employee.getSalary() + "</td><td>" + employee.getDepartment() + "</td></tr></table>");
				found = true;
			}
		}
		if (!found) {
			out.println("<div align='center'><h3>Not Found</h3></div>");
		}

	}

}
