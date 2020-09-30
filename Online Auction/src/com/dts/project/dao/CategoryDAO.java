package com.dts.project.dao;

import com.dts.core.dao.AbstractDataAccessObject;
import com.dts.core.util.CoreList;
import com.dts.project.model.CategoryModel;

import java.sql.*;

public class CategoryDAO extends AbstractDataAccessObject {

	public boolean register(CategoryModel amodel) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();

			PreparedStatement pst = con.prepareStatement("insert into  categorymaster values(?,?,?)");
			pst.setString(1, amodel.getCategoryname());
			pst.setString(2, amodel.getCategoryabbr());
			pst.setString(3, amodel.getCategorydesc());
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

	public CoreList viewCategorys() {
		CoreList acorelist = new CoreList();
		Connection con = null;
		CategoryModel amodel = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from categorymaster");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				amodel = new CategoryModel();
				amodel.setCategoryname(rs.getString(1));
				amodel.setCategoryabbr(rs.getString(2));
				amodel.setCategorydesc(rs.getString(3));
				acorelist.add(amodel);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return acorelist;
	}

	public CategoryModel viewCategorys(String categoryname) {
		CoreList acorelist = new CoreList();
		Connection con = null;
		CategoryModel amodel = null;
		try {
			con = getConnection();
			PreparedStatement pst = con.prepareStatement("select * from categorymaster where Categoryname=?");
			pst.setString(1, categoryname);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				amodel = new CategoryModel();
				amodel.setCategoryname(rs.getString(1));
				amodel.setCategoryabbr(rs.getString(2));
				amodel.setCategorydesc(rs.getString(3));

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return amodel;
	}

	public boolean update(CategoryModel amodel) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();

			PreparedStatement pst = con
					.prepareStatement("update categorymaster set Categoryabbr=?,Categorydesc=? where Categoryname=?");
			pst.setString(1, amodel.getCategoryabbr());
			pst.setString(2, amodel.getCategorydesc());
			pst.setString(3, amodel.getCategoryname());

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

	public boolean delete(String categoryname) {
		boolean flag = false;
		Connection con = null;
		try {
			con = getConnection();

			PreparedStatement pst = con.prepareStatement("delete from categorymaster  where Categoryname=?");
			pst.setString(1, categoryname);

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
}
