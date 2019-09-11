package com.Employee.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Employee.model.Employee;

public class EmployeedaoImpl implements EmployeeDao{
	Connection con=null;
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	

	@Override
	public Connection getConnection() throws Exception {
	      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sakhadb","root" ,"root");
		
		// TODO Auto-generated method stub
		return con;
	}

	@Override
	public boolean save(Employee emp) throws Exception {
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");
		ps.setString(1,emp.getEmpId());
		ps.setString(2, emp.getEmpName());
		LocalDate dobRaw=emp.getDob();
		ps.setDate(3,new java.sql.Date(dobRaw.getYear()-1900,dobRaw.getMonthValue()-1,dobRaw.getDayOfMonth()));
		ps.setFloat(4, emp.getBasicSalary());
		
		int r=ps.executeUpdate();
		
		// TODO Auto-generated method stub
		return r>0?true:false;
	}

	@Override
	public boolean delete(String empId) throws Exception {
		// TODO Auto-generated method stub
		con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where empid=?");
		ps.setString(1,empId);
		
		int r=ps.executeUpdate();
		 		return r>0?true:false;
	}

	@Override
	public boolean update(Employee emp) throws Exception {
		// TODO Auto-generated method stub
		con=getConnection();
	    String empid1=emp.getEmpId();
	    float sal=emp.getBasicSalary();
	    PreparedStatement ps=con.prepareStatement("update employee set sal=? where empid=?");
		ps.setFloat(1,sal);
		ps.setString(2, empid1);
		
		
		int r=ps.executeUpdate();
	return r>0?true:false;}
	
	@Override
	public Employee getEmployee(String empId) throws Exception {
		
		con=getConnection();
		PreparedStatement ps= con.prepareStatement("select * from employee where empid=?");

		ps.setString(1,empId);
		ResultSet rs = ps.executeQuery();	
		
			while(rs.next())
			{
				java.sql.Date rowdate=rs.getDate(3);
				Employee emp= new Employee(rs.getString(1),rs.getString(2),LocalDate.of(rowdate.getYear(),rowdate.getMonth(),rowdate.getDate()), rs.getFloat(4));
				return emp;
			}
			System.out.println("12");
			return null;
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		con = getConnection();
		PreparedStatement ps = null;
		List<Employee> emp = new ArrayList<>();
		Employee e= null;
		ps = con.prepareStatement("select * from employee");
		//System.out.println("hello");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{

		e = new Employee();
		e.setEmpId(rs.getString(1));
		e.setEmpName(rs.getString(2));
		//LocalDate dob = e.getDob();
		//String strDate = dob.getYear()+"-"+dob.getMonthValue()+"-"+dob.getDayOfMonth();
		//ps.setString(3,strDate);
		//ps.setDate(3, new java.sql.Date(dob.getYear()-1900,dob.getMonthValue()-1,dob.getDayOfMonth()));
		//e.setDob(dob);
		//e.setSalary(rs.getFloat(4));
		Date dob1 = rs.getDate(3);
		//LocalDate.of(dob1.getYear(), dob1.getMonth(), dob1.getDate());
		e.setDob(((java.sql.Date) dob1).toLocalDate());
		//ps.setDate(3, new java.sql.Date(dob1.getYear()-1900,dob1.getMonthValue()-1,dob1.getDayOfMonth()));
		//e.setDOB(dob1.toLocalDate());
		e.setBasicSalary(rs.getFloat(4));
		//System.out.println("hello");
		emp.add(e);

		}
		return emp;
		
	
	// TODO Auto-generated method stub
	
		
		// TODO Auto-generated method stub
	
	
		
	}

	public static void main(String[] args) {
	
	}
	

}
