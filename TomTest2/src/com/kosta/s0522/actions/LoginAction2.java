package com.kosta.s0522.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kosta.s0522.beans.UserInfo;
import com.kosta.s0522.model.LoginInProcess;

public class LoginAction2 extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//요청 분석, 입력 데이터 얻기, 모델 호출(영역 저장),페이지 이동
		System.out.println("execute()");
		return mapping.findForward("success");
	}//execute
}
