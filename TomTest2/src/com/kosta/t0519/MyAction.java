package com.kosta.t0519;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author kosta
 *
 * @컨트롤러의 역할 1 2 3 4
 */
public class MyAction extends Action {// 이제부터 컨트롤러 역할
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EmpDAO3 dao = new EmpDAO3();
		request.setAttribute("list" ,dao.selectAll());

		return mapping.findForward("success");//4
	}
}
