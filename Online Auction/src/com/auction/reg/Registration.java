package com.auction.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebService
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		int i;
		RequestDispatcher rd = null;
		Connection con;
		PreparedStatement ps;
		PrintWriter out = res.getWriter();
		String loginid = req.getParameter("loginid");
		String password = req.getParameter("password");
		String firstname = req.getParameter("firstname");
		String middlename = req.getParameter("middlename");
		String lastname = req.getParameter("lastname");
		String dob = req.getParameter("bdate");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		String cno = req.getParameter("mobnumber");
		String type = req.getParameter("type");
		String addr = req.getParameter("address");
		String city = req.getParameter("city");
		String pincode = req.getParameter("pincode");
		String country = req.getParameter("country");
		String state = req.getParameter("state");
		String status = "n";
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "eauction", "prajwal");
			if (type.equalsIgnoreCase("seller")) {
				ps = con.prepareStatement(
						"insert into SELLERPROFILE values(?,?,?,?,?,TO_DATE(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, loginid);
				ps.setString(2, password);
				ps.setString(3, firstname);
				ps.setString(4, middlename);
				ps.setString(5, lastname);
				ps.setString(6, dob);
				ps.setString(7, gender);
				ps.setString(8, email);
				ps.setString(9, cno);
				ps.setString(10, type);
				ps.setString(11, addr);
				ps.setString(12, city);
				ps.setString(13, pincode);
				ps.setString(14, country);
				ps.setString(15, state);
				ps.setString(16, status);
				i = ps.executeUpdate();
			} else {
				ps = con.prepareStatement(
						"insert into BUYERPROFILE values(?,?,?,?,?,TO_DATE(?,'yyyy-MM-dd'),?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, loginid);
				ps.setString(2, password);
				ps.setString(3, firstname);
				ps.setString(4, middlename);
				ps.setString(5, lastname);
				ps.setString(6, dob);
				ps.setString(7, gender);
				ps.setString(8, email);
				ps.setString(9, cno);
				ps.setString(10, type);
				ps.setString(11, addr);
				ps.setString(12, city);
				ps.setString(13, pincode);
				ps.setString(14, country);
				ps.setString(15, state);
				ps.setString(16, status);
				i = ps.executeUpdate();

			}
			if (i == 0) {
				rd = req.getRequestDispatcher("unsucessreg.jsp");
				rd.forward(req, res);
			}

			else {
				rd = req.getRequestDispatcher("Successreg.jsp");
				rd.forward(req, res);

			}

		} catch (Exception e) {
			// TODO: handle exception
			 rd = req.getRequestDispatcher("ServerError.jsp");
			rd.forward(req, res);
		}

	}
}
