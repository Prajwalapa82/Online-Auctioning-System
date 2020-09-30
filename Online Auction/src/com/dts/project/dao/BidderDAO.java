package com.dts.project.dao;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreList;
import com.dts.core.util.DateWrapper;
import com.dts.project.model.BidderForm;

import java.sql.*;

public class BidderDAO extends AbstractDataAccessObject {

	public boolean register(BidderForm aform) {
		boolean flag = false;
		Connection con = null;
		try {
			int bidderid = getSequenceID("biddingInformation", "bidderid");
			con = getConnection();
			PreparedStatement pst = con.prepareStatement("insert into biddingInformation values(?,?,?,?,?,?)");
			pst.setInt(1, bidderid);
			pst.setString(2, aform.getLoginname());
			pst.setInt(3, aform.getBamount());
			pst.setString(4, aform.getItemname());
			pst.setString(5, DateWrapper.parseDate(new java.util.Date()));
			pst.setString(6, "Pending");
			int n = pst.executeUpdate();
			if (n > 0) {
				boolean flag1 = updateStatus(aform.getItemname());
				if (flag1) {
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}

	public CoreList viewBiddingInformation(String loginname) {
		CoreList acorelist = new CoreList();
		Connection con = null;
		BidderForm aform = null;
		try {
			con = getConnection();
			PreparedStatement st = con.prepareStatement("select * from biddingInformation");
			st.setString(1, loginname);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				aform = new BidderForm();
				aform.setBidderid(rs.getInt(1));
				aform.setLoginname(rs.getString(2));
				aform.setBamount(rs.getInt(3));
				aform.setItemname(rs.getString(4));
				aform.setBidderdate(DateWrapper.parseDate(rs.getDate(5)));
				aform.setStatus(rs.getString(6));
				acorelist.add(aform);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public boolean updateStatus(String itemname) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement("update Itemmaster set bidcount=bidcount+1 where Itemname=?");
			pst.setString(1, itemname);
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

	public CoreList viewBiddings(String loginname) {
		CoreList acorelist = new CoreList();
		Connection con = null;
		BidderForm aform = null;
		try {
			con = getConnection();
			PreparedStatement st = con.prepareStatement("select * from biddingInformation where loginname=?");
			st.setString(1, loginname);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				aform = new BidderForm();
				aform.setBidderid(rs.getInt(1));
				aform.setLoginname(rs.getString(2));
				aform.setBamount(rs.getInt(3));
				aform.setItemname(rs.getString(4));
				aform.setBidderdate(DateWrapper.parseDate(rs.getDate(5)));
				aform.setStatus(rs.getString(6));
				acorelist.add(aform);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList viewAllBiddings() {
		CoreList acorelist = new CoreList();
		Connection con = null;
		BidderForm aform = null;
		try {
			con = getConnection();
			PreparedStatement st = con.prepareStatement("select * from biddingInformation");
			// st.setString(1,loginname);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				aform = new BidderForm();
				aform.setBidderid(rs.getInt(1));
				aform.setLoginname(rs.getString(2));
				aform.setBamount(rs.getInt(3));
				aform.setItemname(rs.getString(4));
				aform.setBidderdate(DateWrapper.parseDate(rs.getDate(5)));
				aform.setStatus(rs.getString(6));
				acorelist.add(aform);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CoreList viewAllBiddingsInformation(String itemname) {
		CoreList acorelist = new CoreList();
		Connection con = null;
		BidderForm aform = null;
		System.out.println("itemname" + itemname);
		try {
			con = getConnection();
			PreparedStatement st = con.prepareStatement("select * from biddingInformation where itemname=?");
			st.setString(1, itemname);
			// st.setString(1,loginname);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {

				aform = new BidderForm();
				aform.setBidderid(rs.getInt(1));
				aform.setLoginname(rs.getString(2));
				aform.setBamount(rs.getInt(3));
				aform.setItemname(rs.getString(4));
				aform.setBidderdate(DateWrapper.parseDate(rs.getDate(5)));
				aform.setStatus(rs.getString(6));
				System.out.println("this is item asdfasdf sfsdfsdf name");
				acorelist.add(aform);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public boolean updatStatusDetails(String itemname, int bidderid) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement(
					"update biddinginformation set status='Assigned' where itemname=? and BIDDERID=?");
			pst.setString(1, itemname);
			pst.setInt(2, bidderid);
			int n = pst.executeUpdate();
			if (n > 0) {
				flag = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
}
