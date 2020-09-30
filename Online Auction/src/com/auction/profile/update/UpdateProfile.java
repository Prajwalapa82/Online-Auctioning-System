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
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.websocket.Session;

import com.dts.dae.model.Profile;

@WebServlet("/upp")

public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private boolean flag;
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
     		ps=con.prepareStatement("select * from Admin where loginid=?");
     		ps.setString(1,lid);
 			rs=ps.executeQuery();
 			while(rs.next()){
 			up.setLoginid(rs.getString(1));
 			up.setFirstname(rs.getString(3));
 			up.setMiddlename(rs.getString(4));
 			up.setLastname(rs.getString(5));
 			up.setBdate(rs.getString(6));
 			up.setEmail(rs.getString(7));
 			up.setPhoneNo(rs.getString(8));
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
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		RequestDispatcher rd;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction","prajwal");
			ps=con.prepareStatement("update admin set loginid=?,fname=?,mname=?,lname=?,cno=?,email=?");
			ps.setString(1, loginid);
			ps.setString(2, fname);
			ps.setString(3, mname);
			ps.setString(4, lname);
			ps.setString(5, cno);
			ps.setString(6, email);
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
