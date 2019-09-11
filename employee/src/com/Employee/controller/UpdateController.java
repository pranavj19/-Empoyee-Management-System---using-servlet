package com.Employee.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Employee.model.Employee;
import com.Employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/updatecontroller")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		String empid=request.getParameter("empid");
		float Salary=Float.parseFloat(request.getParameter("sal"));
		emp.setEmpId(empid);
	    emp.setBasicSalary(Salary);
		
		try {
			boolean b=es.update(emp);
			   response.sendRedirect("Successful.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
