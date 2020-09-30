
package com.dts.dae.dao;

import com.dts.dae.model.Profile;
import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.DateWrapper;
import com.dts.core.util.LoggerManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class SecurityDAO extends AbstractDataAccessObject {
	Connection con;
	private String desc;
	private boolean flag;

	/** Creates a new instance of SecurityDAO */
	public SecurityDAO() {
		// getting Database Connection
		con = getConnection();

	}

	// Compare Password
	public boolean checkPassword(Profile regbean) {
		String loginid = regbean.getLoginid();
		String oldpassword = regbean.getPassword();

		try {
			PreparedStatement pst = con.prepareStatement("select * from logindetails where password=? and loginid=?");
			pst.setString(1, oldpassword);
			pst.setString(2, loginid);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
				LoggerManager.writeLogInfo("Login Success");
			} else {
				flag = false;
			}
		} catch (SQLException ex) {
			LoggerManager.writeLogSevere(ex);
			LoggerManager.writeLogInfo("Database Connection problem");
			flag = false;
		}
		return flag;
	}

	// Compare Password
	public int checkFirstLogin(String loginname) {
		int fstatus = 2;
		try {

			con.setAutoCommit(true);
			PreparedStatement pst = con.prepareStatement("select firstlogin from logindetails where loginid=?");
			pst.setString(1, loginname);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				fstatus = rs.getInt(1);
			}
			con.close();
		} catch (SQLException ex) {
			LoggerManager.writeLogSevere(ex);
			LoggerManager.writeLogInfo("Database Connection problem");
			flag = false;
		}
		return fstatus;
	}

	// Login Check
	public String loginCheck(String loginid, String password) {
		// String loginid=regbean.getLoginID();
		// String password=regbean.getPassword();
		String role = "";
		ResultSet rs = null;
		try {
			con = getConnection();

			PreparedStatement pst = con
					.prepareStatement("select logintype from logindetails where password=? and loginname=? ");
			pst.setString(2, loginid);
			pst.setString(1, password);

			rs = pst.executeQuery();
			if (rs.next()) {
				/*
				 * Statement st=con.createStatement();
				 * st.executeUpdate("Update login_details set firstlogin=1 where loginname='"
				 * +loginid+"'");
				 */
				role = rs.getString(1);
				desc = "Login Success";
			} else {
				flag = false;
				desc = "Entered Invalid password";
				role = rs.getString(0);
			}

		} catch (SQLException ex) {
			LoggerManager.writeLogSevere(ex);
			desc = "Database Connection problem";
			flag = false;
			role = "invalid";
		}
		loginaudit(loginid, desc);
		return role;
	}

	// Method for login audit
	public void loginaudit(String loginid, String desc) {
		try {
			String newdate = DateWrapper.parseDate(new Date());
			PreparedStatement pst = con.prepareStatement("insert into loginaudit values(?,?,?)");
			pst.setString(1, loginid);
			pst.setString(2, newdate);
			pst.setString(3, desc);
			int i = pst.executeUpdate();
			if (i == 1)
				con.commit();
			else
				con.rollback();
			con.close();
		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException ex) {
				LoggerManager.writeLogSevere(ex);
			}
			e.printStackTrace();
		}
	}

	// Change Password
	public boolean changePassword(Profile regbean) {
		String loginid = regbean.getLoginid();
		String oldpassword = regbean.getPassword();
		String newpassword = regbean.getNewpassword();
		try {
			con.setAutoCommit(false);
			String newdate = DateWrapper.parseDate(new Date());
			PreparedStatement pst = con.prepareStatement(
					"UPDATE logindetails SET password=?,passmodifieddate=? WHERE loginname=? and password=?");

			pst.setString(1, newpassword);
			pst.setString(2, newdate);
			pst.setString(3, loginid);
			pst.setString(4, oldpassword);

			int i = pst.executeUpdate();
			if (i == 1) {
				flag = true;
				con.commit();
			} else {
				flag = false;
				con.rollback();
			}
			con.close();
		} catch (SQLException ex) {
			LoggerManager.writeLogSevere(ex);
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			try {
				con.rollback();
			} catch (SQLException sex) {
				LoggerManager.writeLogSevere(sex);
			}
		}
		return flag;
	}

	
}
