package com.kosta.s0523.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CalcActionForm extends ActionForm {
	private String su1;
	private String su2;
	private String oper;

	public String getSu1() {
		System.out.println("su1 : "+su1);
		return su1;
	}

	public void setSu1(String su1) {
		System.out.println("su1 : "+su1);
		this.su1 = su1;
	}

	public String getSu2() {
		return su2;
	}

	public void setSu2(String su2) {
		this.su2 = su2;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		System.out.println("validate");
		ActionErrors errors = new ActionErrors();// 에러메시지를 담는 바구니
		if (su1.length() < 1 && su2.length() < 1) {
			errors.add("errorid", new ActionMessage("calcError", "두수를 입력"));
		}
		if (!su1.matches("[0-9]+") && !su2.matches("[0-9]")) {
			errors.add("errorid", new ActionMessage("calcError", "숫자만 입력"));
		}
		if (oper.equals("/") && su2.equals("0")) {
			errors.add("errorid", new ActionMessage("calcError", " '0' 으로 나눌수 없습니다"));
		}
		return errors;
	}

}
