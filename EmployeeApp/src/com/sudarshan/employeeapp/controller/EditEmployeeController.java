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
import com.sudarshan.employeeapp.domain.Employee;

@WebServlet("/editEmployee")
public class EditEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Employee employee;
	private ServletContext context;
	private EmployeeDao employeeDao;

	public EditEmployeeController() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");

		employee = employeeDao.findEmployeeById(id);

		request.setAttribute("editEmployee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long employeeId = Long.parseLong(request.getParameter("empId"));
		String employeeName = request.getParameter("empName");
		double employeeSalary = Double.parseDouble(request.getParameter("empSalary"));
		String employeeDepartment = request.getParameter("empDepartment");

		employeeDao = (EmployeeDao) context.getAttribute("employeeDao");

		employee = employeeDao
				.updateEmployee(new Employee(employeeId, employeeName, employeeSalary, employeeDepartment));
		request.setAttribute("edited", true);
		request.setAttribute("editEmployee", employee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployee.jsp");
		dispatcher.forward(request, response);

	}

}
