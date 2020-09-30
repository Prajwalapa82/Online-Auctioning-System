package com.auction.approve;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class ApproveSeller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	 String lid=req.getParameter("lid");
	 String pwd=req.getParameter("pwd");
	 String fname=req.getParameter("fname");
	 String mname=req.getParameter("mname");
	 String lname=req.getParameter("lname");
	 String ltype=req.getParameter("ltype");
	 Connection con;
	 PreparedStatement ps;
	 ResultSet rs;
	 RequestDispatcher rd;
	 String st="y";

	 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction","prajwal");
		ps=con.prepareStatement("update SELLERPROFILE set STATUS=? where LOGINID=?");
	    ps.setString(1, st);
	    ps.setString(2,lid);
		rs=ps.executeQuery();
     if (rs.next()) {
    	 ps=con.prepareStatement("insert into LOGINDETAILS values(?,?,?,?,?,?,?)");
    	 ps.setString(1,lid);
    	 ps.setString(2,pwd);
    	 ps.setString(3,fname);
    	 ps.setString(4,mname);
    	 ps.setString(5,lname);
    	 ps.setString(6,ltype);
    	 ps.setNull(7,java.sql.Types.DATE);
    	 rs=ps.executeQuery();
    	 if (rs.next()) {
    	 rd = req.getRequestDispatcher("AdminHome.jsp");
			rd.forward(req, res);
	}		
     }		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	}

