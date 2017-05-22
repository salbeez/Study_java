package com.kosta.s0522.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginActionForm extends ActionForm {
	// 1.HTML <form>내의 name속성에 대한 멤버 정의 - get set 메소드
	private String id;
	private String pass;

	public String getId() {
		System.out.println("getId() : " + id);
		return id;
	}

	public void setId(String id) {
		System.out.println("setId() : " + id);
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	// 2. 유효성 검사 validate메소드 오버라이딩
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println("validate()");
		ActionErrors errors = new ActionErrors();// 에러메시지를 담는 바구니
		// errors.add("뷰와 공유할 새로운 키값",new ActionMessage("프로퍼티 파일에 정의한 키값"));
		if (id.trim().length() < 1) {
			errors.add("errorid", new ActionMessage("invalidid", "아이디 입력"));
		}
		if (pass.length() < 1) {
			errors.add("errorpass", new ActionMessage("invalidpass"));
		} else {
			errors.add("", new ActionMessage("invalidlogin"));
		}
		return errors;
	}
}
