package com.Employee.application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.StringTokenizer;

import com.Employee.model.Employee;
import com.Employee.service.EmployeeService;
import com.Employee.service.EmployeeServiceImpl;

public class EmployeeMangementApp {
	
		EmployeeService es;
		BufferedReader in;
		public EmployeeMangementApp() {
			es=new EmployeeServiceImpl() ;
			in=new BufferedReader (new InputStreamReader(System.in));
			
			}
	public void addEmplyee() throws Exception{
		String empName;
		LocalDate dob;
		float sal;
		System.out.println("Enter emplyee details(name,dob(dd-mm-yyyy,salary");
		empName=in.readLine();
		String strDate=in.readLine();
		StringTokenizer stk=new StringTokenizer(strDate,"-");
		int date=Integer.parseInt(stk.nextToken());
		int month=Integer.parseInt(stk.nextToken());
		int year=Integer.parseInt(stk.nextToken());
		dob=LocalDate.of(year, month, date);
		sal=Float.parseFloat(in.readLine());
		System.out.println(empName+sal+dob);
		Employee emp=new Employee();	
		emp.setEmpName(empName);
		emp.setBasicSalary(sal);
		emp.setDob(dob);
		System.out.println("after creating employee object");
		es.save(emp);
		
	}
public void deleteEmployee() {
}
public void showEmployee() {
}
public void displayAll() {
	
	
	}
	public void updateEmployee( ) {
		
	}
public static void main(String[] args){
	EmployeeMangementApp app=new EmployeeMangementApp();
	try {
		app.addEmplyee();
	}catch(Exception e) {
		System.out.println(e);
	}}
	
	}
