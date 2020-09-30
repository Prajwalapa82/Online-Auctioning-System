package com.auction.secuity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dts.core.util.DateWrapper;

@WebServlet
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String lid = req.getParameter("lid");
		String opw = req.getParameter("opassword");
		String npw = req.getParameter("newpwd");
		ResultSet rs;
		Connection con;
		RequestDispatcher rd;
		PreparedStatement ps;
		try {
			String newdate = DateWrapper.parseDate(new Date());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "eauction", "prajwal");
			ps = con.prepareStatement("select * from logindetails where loginname=? and password=? ");
			ps.setString(1, lid);
			ps.setString(2, opw);
			rs = ps.executeQuery();
			if (rs.next()) {
				ps = con.prepareStatement("update logindetails set password=? , passmodifieddate=?  where loginname=?");
				ps.setString(1,npw );
				ps.setString(2,newdate);
				ps.setString(3, lid);
				rs = ps.executeQuery();
				if (rs.next()) {
				 rd = req.getRequestDispatcher("UpdateSuccess.jsp");
					rd.forward(req, res);
				}
			} else {
				 rd = req.getRequestDispatcher("UpdateUnsuccess.jsp");
				rd.forward(req, res);
			}

		} catch (Exception e) {
			e.printStackTrace();
			 rd = req.getRequestDispatcher("ServerError.jsp");
			rd.forward(req, res);
		}

	}

}
