package com.Employee.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.naming.InvalidNameException;

import com.Employee.dao.EmployeeDao;
import com.Employee.dao.EmployeedaoImpl;
import com.Employee.model.Employee;
import com.Employee.util.InvalidDoaException;
import com.Employee.util.InvalidSalaryException;

public class EmployeeServiceImpl implements EmployeeService {
EmployeeDao Dao;
	public EmployeeServiceImpl(){
		Dao = new EmployeedaoImpl();}
	
	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		String empName=emp.getEmpName();
		LocalDate dob=emp.getDob();
		float salary =emp.getBasicSalary();
		System.out.println("inside validation");
		if(empName.length()<4 || empName.length()>15) {
			throw new InvalidNameException("name must be between 4 to 15 character");
			
			}
		if(dob.isAfter(LocalDate.of(1996, 12, 31)) || dob.isBefore(LocalDate.of(1990, 1, 1)))
		// TODO Auto-generated method stub
		{
			throw new InvalidDoaException("Enter invalid ");
			
		}
		if(salary<=0)
		{
			throw new InvalidSalaryException("Salary must be greater than 0");
		}
		return true;
	}
	@Override
	public String genearateId(String empname) throws Exception {
		
		// TODO Auto-generated method stub
		String namechar=empname.substring(0,2).toUpperCase();
		Random rand= new Random();
		int dgt=(int) (rand.nextDouble()*1000);
		return namechar+dgt;
	}
	@Override
	public boolean save(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(emp.getEmpName());
		System.out.println(emp.getDob());
		System.out.println(emp.getBasicSalary());
		System.out.println(emp.getEmpName());
		if(validateEmployee(emp))
		{
			emp.setEmpId(genearateId(emp.getEmpName()));
			System.out.println(emp.getEmpId()+emp.getEmpName()+emp.getDob()+emp.getBasicSalary());
			return Dao.save(emp);
		}
		return false;
	}
	@Override
	public boolean delete(String empid) throws Exception {
		// TODO Auto-generated method stub
		
		return Dao.delete(empid);
	}
	@Override
	public boolean update(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		float sal=emp.getBasicSalary();
		if(sal>0)
		return Dao.update(emp);
		
		return false;
	}
	@Override
	public Employee getEmployee(String empId) throws Exception {
		// TODO Auto-generated method stub
		
		return Dao.getEmployee(empId);
	}
	@Override
	public List<Employee> display() throws Exception {
		// TODO Auto-generated method stub
		return Dao.getAllEmployees();
	}
	@Override
	public void save1(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	public boolean validatEmployee(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
	