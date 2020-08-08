package com.sudarshan.employeeapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.sudarshan.employeeapp.dao.EmployeeDao;
import com.sudarshan.employeeapp.domain.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	private List<Employee> employees = new ArrayList<>();

	@Override
	public List<Employee> findAllEmployees() {
		return employees;
	}

	@Override
	public Employee findEmployeeById(long employeeId) {
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == employeeId) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(long employeeId) {
		for (Employee employee : employees) {
			if (employee.getEmployeeId() == employeeId) {
				employees.remove(employee);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if (employees.size() == 0) {
			return employees.add(employee);
		}
		for (Employee emp : employees) {
			if (employee.getEmployeeId() == emp.getEmployeeId()) {
				return false;
			} else {
				return employees.add(employee);
			}
		}
		return false;

	}

	@Override
	public Employee updateEmployee(Employee employee) {
		for (Employee employ : employees) {
			if (employ.getEmployeeId() == employee.getEmployeeId()) {
				employ.setEmployeeName(employee.getEmployeeName());
				employ.setEmployeeSalary(employee.getEmployeeSalary());
				employ.setEmployeeDepartment(employee.getEmployeeDepartment());
			}
			return employ;
		}
		return null;
	}

}
