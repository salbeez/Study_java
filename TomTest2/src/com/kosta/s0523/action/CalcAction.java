package com.kosta.s0523.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kosta.s0523.forms.CalcActionForm;
import com.kosta.s0523.model.Calculator;

public class CalcAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("CalcAction");
		CalcActionForm laf = (CalcActionForm) form;
		int op1 = Integer.parseInt(laf.getSu1());
		int op2 = Integer.parseInt(laf.getSu2());

		Calculator dao = new Calculator(op1, op2, laf.getOper());
		String result = dao.getResult();
		System.out.println(op1 + " " + laf.getOper() + " " + op2 + " " + result);
		request.getSession().setAttribute("result", result);
		return mapping.findForward("success");
	}
}
