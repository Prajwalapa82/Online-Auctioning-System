package com.auction.profile.update;

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

import com.dts.dae.model.Profile;

/**
 * Servlet implementation class UpdateProfileBuyer
 */
@WebServlet("/upb")
public class UpdateProfileBuyer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Profile getProfile(String loginid)    
	   {
	    	Profile up=new Profile();
	    	String lid=loginid;
	        Connection con;
	        PreparedStatement ps;
	        ResultSet rs;
	        try {
	        	Class.forName("oracle.jdbc.driver.OracleDriver");
	 			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction","prajwal");
	     		ps=con.prepareStatement("select * from BUYERPROFILE where loginid=?");
	     		ps.setString(1,lid);
	 			rs=ps.executeQuery();
	 			while(rs.next()){
	 			up.setLoginid(rs.getString(1));
	 			up.setFirstname(rs.getString(3));
	 			up.setMiddlename(rs.getString(4));
	 			up.setLastname(rs.getString(5));
	 			up.setEmail(rs.getString(8));
	 			up.setPhoneNo(rs.getString(9));
	 			up.setAddress(rs.getString(11));
	 			up.setCity(rs.getString(12));
	 			up.setPincode(rs.getString(13));
	 			up.setState(rs.getString(15));
	 			}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
	     return up;   
	    }
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			String loginid =req.getParameter("lid");
			String fname =req.getParameter("fname");
			String mname =req.getParameter("mname");
			String lname =req.getParameter("lname");
			String cno =req.getParameter("cno");
			String email =req.getParameter("email");
			String addr=req.getParameter("adr");
			String city=req.getParameter("city");
			String pinc=req.getParameter("pinc");
			String state=req.getParameter("state");
			Connection con;
			PreparedStatement ps;
			ResultSet rs;
			RequestDispatcher rd;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction","prajwal");
				ps=con.prepareStatement("update BUYERPROFILE set fname=?,mname=?,lname=?,cno=?,email=?,addr=?,city=?,pinc=?,state=? where loginid=?");
				ps.setString(1, fname);
				ps.setString(2, mname);
				ps.setString(3, lname);
				ps.setString(4, cno);
				ps.setString(5, email);
				ps.setString(6, addr);
				ps.setString(7, city);
				ps.setString(8, pinc);
				ps.setString(9, state);
				ps.setString(10, loginid);
				rs=ps.executeQuery();
				if (rs.next()) {
					
					rd = req.getRequestDispatcher("UpdateSuccess.jsp");
					rd.forward(req, res);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				rd = req.getRequestDispatcher("ServerError.jsp");
				rd.forward(req, res);
			}
		}

	}
