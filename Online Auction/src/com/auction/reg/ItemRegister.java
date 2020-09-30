package com.auction.reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ireg")
public class ItemRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		int i;
		RequestDispatcher rd = null;
		Connection con;
		PreparedStatement ps;
		PrintWriter out = res.getWriter();
		String itemname = req.getParameter("iname");
		String itemdsc = req.getParameter("idsc");
		String icateg = req.getParameter("category");
		String ipr = req.getParameter("isr");
		String bicr = req.getParameter("icr");
		String img = req.getParameter("image");
		String status = "n";
		String bid = "";

	}

}
