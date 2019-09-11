package com.Employee.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Employee.model.Employee;

import com.Employee.service.EmployeeServiceImpl;

/**
 * Servlet implementation class GetallEmployee
 */
@WebServlet("/GetallEmployee")
public class GetallEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetallEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeServiceImpl s = new EmployeeServiceImpl();
		try {
		List<Employee> l = s.display();
		if(l!=null) {
		System.out.println("ehllo");
		request.getSession().setAttribute("list", l);
		}
		else
		{
		request.getSession().setAttribute("error", "No data");
		}
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		HttpSession ssn = request.getSession();
		//ssn.setAttribute("List", l);
		response.sendRedirect("Viewall.jsp");
		response.getWriter().append("Served at: ").append(request.getContextPath());

	
	
	
	}

}
