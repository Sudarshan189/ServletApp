package com.sudarshan.employeeapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sudarshan.employeeapp.dao.EmployeeDao;
import com.sudarshan.employeeapp.dao.impl.EmployeeDaoImpl;
import com.sudarshan.employeeapp.domain.Employee;

@WebServlet("/addEmployee")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;
	private ServletContext context;
	

	public AddEmployeeController() {
		super();
		employeeDao= new EmployeeDaoImpl();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long employeeId = Long.parseLong(request.getParameter("empId"));
		String employeeName = request.getParameter("empName");
		double employeeSalary = Double.parseDouble(request.getParameter("empSalary"));
		String employeeDepartment = request.getParameter("empDepartment");
		request.setAttribute("exits", false);
		Employee employee = new Employee(employeeId, employeeName, employeeSalary, employeeDepartment);
		context.setAttribute("employeeDao", employeeDao);
		if (employeeDao.addEmployee(employee)) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("displayEmployees");
//			
//			dispatcher.forward(request, response);
			response.sendRedirect("displayEmployees");

		} else {
			request.setAttribute("exists", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addEmployee.jsp");
			dispatcher.forward(request, response);
		}
	}

}
