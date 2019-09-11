package com.Employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Employee.model.Employee;
import com.Employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class GetEmployee
 */
@WebServlet("/getemployee")
public class GetEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeServiceImpl es=new EmployeeServiceImpl();
		Employee emp=new Employee();
	String empid=request.getParameter("name1");
	Employee emp1;
	emp.setEmpId(empid);
	System.out.println(emp.getEmpName());
	try {
		emp1=es.getEmployee(empid);
		HttpSession ssn=request.getSession();
		System.out.println("\n1"+emp1.getEmpName());
		ssn.setAttribute("empid",empid);
		ssn.setAttribute("ename",emp1.getEmpName());
		ssn.setAttribute("sal",emp1.getBasicSalary());
		ssn.setAttribute("Dob",emp1.getDob());
		response.sendRedirect("Showdata.jsp");
		
		
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	

}
}
