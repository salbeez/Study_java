package com.kosta.s0522.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.kosta.s0522.beans.UserInfo;
import com.kosta.s0522.forms.LoginActionForm;
import com.kosta.s0522.model.LoginInProcess;

public class LoginAction2 extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		// 요청 분석, 입력 데이터 얻기, 모델 호출(영역 저장),페이지 이동
		System.out.println("execute()");
		LoginActionForm laf = (LoginActionForm) form;

		// 유효성 검사가 끝난데이터 얻어오기
		String id = laf.getId();
		String pass = laf.getPass();
		System.out.println(id + "\t" + pass);
		LoginInProcess dao = new LoginInProcess();
		UserInfo user = dao.selectLogin(id, pass);
		
		ActionForward forward;
		if (user == null) {
			ActionMessages msgs = new ActionMessages();
			msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("invalidlogin"));
			saveMessages(request, msgs);// 꼭해야만 프레임워크에 전달이 된다
			forward = mapping.getInputForward();// input속성에 정의된 페이지 이동
		} else {
			request.getSession().setAttribute("user", user);
			forward = mapping.findForward("success");
		}
		return forward;
	}// execute
}
