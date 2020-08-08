package com.sudarshan.domain;

public class Employee {
	private long id;
	private String name;
	private double salary;
	private String department;
	public Employee(long id, String name, double salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public double getSalary() {
		return salary;
	}
	public String getDepartment() {
		return department;
	}
	
	
}
