package com.source;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class TestJdbc
 */
@WebServlet("/TestJdbc")
public class TestJdbc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String url = "jdbc:mysql://localhost:3306/project?setSSl=False";
		String driver = "com.mysql.jdbc.Driver";
		
		try
		{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,"root","root");
			
			PrintWriter out = response.getWriter();
			
			out.println("success");
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
	}

}
