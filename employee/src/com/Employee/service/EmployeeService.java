package com.Employee.service;

import java.util.List;

import com.Employee.model.Employee;

public interface EmployeeService {
	
	public boolean validateEmployee(Employee emp)  throws Exception ;
	public  String  genearateId(String empname)throws Exception;
	public boolean  save(Employee emp)throws Exception;
	public  boolean  delete (String empid) throws Exception;
	public  boolean update (Employee emp)throws Exception;
	public Employee  getEmployee( String empId)throws Exception;
	public  List<Employee> display() throws Exception;
	public void save1(Employee emp);

}
