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

import com.dts.project.dao.CategoryDAO;
import com.dts.project.model.CategoryModel;

/**
 * MyEclipse Struts Creation date: 02-28-2009
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/updateCategoryAction" name="categorymodel"
 *                scope="request"
 * @struts.action-forward name="success" path="/Success.jsp?status=Category
 *                        Updated Successfully"
 * @struts.action-forward name="fail" path="/Success.jsp?status=Category Updated
 *                        Failed"
 */
public class UpdateCategoryAction extends Action {
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
		try {
			CategoryModel categorymodel = (CategoryModel) form;// TODO Auto-generated method stub
			CategoryDAO adao = new CategoryDAO();
			boolean flag = adao.update(categorymodel);
			if (flag) {
				return mapping.findForward("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO: handle exception
		return mapping.findForward("fail");
	}
}