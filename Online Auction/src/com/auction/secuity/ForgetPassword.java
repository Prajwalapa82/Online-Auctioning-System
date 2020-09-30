package com.auction.secuity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/for")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String lid=req.getParameter("lid");
		String email=req.getParameter("email");
		Connection con;
		PreparedStatement ps;
		RequestDispatcher rd;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction", "prajwal");
			ps=con.prepareStatement("select * from logindetails");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
