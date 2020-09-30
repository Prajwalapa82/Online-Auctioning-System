package com.dts.project.dao;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreList;
import com.dts.core.util.DateWrapper;
import com.dts.project.model.ItemModel;

import java.sql.*;

public class SellItemDAO extends AbstractDataAccessObject {

	public boolean register(ItemModel amodel) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into itemmaster values(?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, amodel.getItemname());
			pst.setString(2, amodel.getCategoryname());
			pst.setString(3, amodel.getItemdesc());
			pst.setString(4, amodel.getSummary());
			pst.setInt(5, amodel.getStartprice());
			pst.setInt(6, amodel.getIncrprice());
			pst.setString(7, DateWrapper.parseDate(new java.util.Date()));
			pst.setString(8, DateWrapper.parseDate(amodel.getEndingdate()));
			pst.setString(9, amodel.getLoginname());
			pst.setInt(10, 0);
			int n = pst.executeUpdate();
			if (n > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}

	public CoreList viewItems(String loginname) {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,bidcount from itemmaster where loginname='"
							+ loginname + "'");
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setBidcount(rs.getInt(9));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList viewItembyOne(String itemname) {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,enddate,bidcount from itemmaster where itemname='"
							+ itemname + "'");
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				// amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setBidcount(rs.getInt(8));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public boolean updateItems(ItemModel amodel) {
		CoreList acorelist = new CoreList();
		// ItemModel amodel=null;
		Connection con = null;
		boolean flag = false;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"update itemmaster set Categoryname=?,Itemdesc=?,summary=?,startprice=?,incrprice=?,enddate=? where itemname=? and BIDCOUNT=0 ");

			pst.setString(1, amodel.getCategoryname());
			pst.setString(2, amodel.getItemdesc());
			pst.setString(3, amodel.getSummary());
			pst.setInt(4, amodel.getStartprice());
			pst.setInt(5, amodel.getIncrprice());

			pst.setString(6, DateWrapper.parseDate(amodel.getEndingdate()));

			pst.setString(7, amodel.getItemname());

			int n = pst.executeUpdate();
			if (n > 0) {
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}

	public boolean deleteItems(String username) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement("delete from itemmaster where itemname=?");
			pst.setString(1, username);
			int n = pst.executeUpdate();
			if (n > 0) {
				flag = true;
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}

	public ItemModel viewItembyDetails(String itemname, String categoryname) {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,loginname,bidcount from itemmaster where itemname='"
							+ itemname + "' and Categoryname='" + categoryname + "'");
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setLoginname(rs.getString(9));
				amodel.setBidcount(rs.getInt(10));

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return amodel;
	}

	public CoreList viewItemsByDetails(String loginname, String categoryname) {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select itemname from itemmaster where loginname!='" + loginname
					+ "' and CATEGORYNAME='" + categoryname + "'");
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));

				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList auctionItemDetails(String loginname) {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,loginname,bidcount from itemmaster where To_char(stdate,'dd-mm-yy')=to_char(sysdate,'dd-mm-yy') and loginname!=?");
//pst.setString(1,DateWrapper.parseDate(new java.util.Date()));
			pst.setString(1, loginname);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setLoginname(rs.getString(9));
				amodel.setBidcount(rs.getInt(10));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList generalauctionItemDetails() {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,loginname,bidcount from itemmaster where To_char(stdate,'dd-mm-yy')=to_char(sysdate,'dd-mm-yy')");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setLoginname(rs.getString(9));
				amodel.setBidcount(rs.getInt(10));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList auctionItemEndDay(String loginname) {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,loginname,bidcount from itemmaster where To_char(enddate,'dd-mm-yy')=to_char(sysdate,'dd-mm-yy') and loginname!=?");
			pst.setString(1, DateWrapper.parseDate(new java.util.Date()));
			pst.setString(2, loginname);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setLoginname(rs.getString(9));
				amodel.setBidcount(rs.getInt(10));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList generalauctionItemEndDay() {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,loginname,bidcount from itemmaster where To_char(enddate,'dd-mm-yy')=to_char(sysdate,'dd-mm-yy')");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setLoginname(rs.getString(9));
				amodel.setBidcount(rs.getInt(10));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList viewAllItems() {
		CoreList acorelist = new CoreList();
		ItemModel amodel = null;
		Connection con = null;
		try {
			con = getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(
					"select itemname,Categoryname,Itemdesc,summary,startprice,incrprice,stdate,enddate,bidcount from itemmaster ");
			while (rs.next()) {
				amodel = new ItemModel();
				amodel.setItemname(rs.getString(1));
				amodel.setCategoryname(rs.getString(2));
				amodel.setItemdesc(rs.getString(3));
				amodel.setSummary(rs.getString(4));
				amodel.setStartprice(rs.getInt(5));
				amodel.setIncrprice(rs.getInt(6));
				amodel.setStartingdate(DateWrapper.parseDate(rs.getDate(7)));
				amodel.setEndingdate(DateWrapper.parseDate(rs.getDate(8)));
				amodel.setBidcount(rs.getInt(9));
				acorelist.add(amodel);

			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}
}
