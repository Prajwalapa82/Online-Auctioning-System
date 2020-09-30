/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.dts.project.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dts.project.dao.BidderDAO;
import com.dts.project.model.BidderForm;

/**
 * MyEclipse Struts Creation date: 03-01-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action
 * @struts.action-forward name="success" path="/Success.jsp"
 * @struts.action-forward name="fail" path="/Fail.jsp"
 */
public class RegisterBidderAction extends Action {
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
			BidderForm aform = (BidderForm) form;
			BidderDAO adao = new BidderDAO();
			boolean flag = adao.register(aform);
			if (flag) {
				return mapping.findForward("success");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return mapping.findForward("fail");
	}
}