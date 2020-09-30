/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.dts.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dts.core.util.CoreList;
import com.dts.dae.dao.ProfileDAO;
import com.dts.dae.model.Profile;

/**
 * MyEclipse Struts Creation date: 02-22-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action
 */
public class ViewCustomer extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			// HttpSession session=request.getSession();
			// String loginname=(String)session.getAttribute("user");
			CoreList acorelist = new ProfileDAO().getProfile();
			int size = acorelist.size();
			if (size != 0) {
				request.setAttribute("CoreList", acorelist);
				return mapping.findForward("ViewCustomers");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		return mapping.findForward("norecords");
	}
}