package com.Employee.model;

import java.time.LocalDate;

public class Employee {
	String empId;
	String empName;
	LocalDate dob;
	float basicSalary;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empId, String empName, LocalDate dob, float basicSalary) {
		
		this.empId = empId;
		this.empName = empName;
		this.dob = dob;
		this.basicSalary = basicSalary;
	}
//	public Employee() {
//
//	}
	public String getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	
	
	
	
}
