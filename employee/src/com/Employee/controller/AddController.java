package com.Employee.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee.model.Employee;
import com.Employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/addcontroller")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddController() {
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
		String date=request.getParameter("setDate");
		String ename=request.getParameter("name1");
		StringTokenizer stk=new StringTokenizer(date,"-");
		int date1=Integer.parseInt(stk.nextToken());
		int month=Integer.parseInt(stk.nextToken());
		int year=Integer.parseInt(stk.nextToken());
		LocalDate dob=LocalDate.of(year, month, date1);
	    float Salary=Float.parseFloat(request.getParameter("sal"));
	    emp.setBasicSalary(Salary);
	    emp.setDob(dob);
	    emp.setEmpName(ename);
	    try {
			boolean b=es.save(emp);
			if(b==true)
		 	response.sendRedirect("Successful.jsp");
			else
				response.sendRedirect("Failure.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		
	}

}
