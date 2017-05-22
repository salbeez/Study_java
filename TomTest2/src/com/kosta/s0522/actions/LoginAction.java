package com.kosta.s0522.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.kosta.s0522.beans.UserInfo;
import com.kosta.s0522.model.LoginInProcess;

public class LoginAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		System.out.println(id + " " + pass);
		LoginInProcess dao = new LoginInProcess();
		UserInfo user = dao.selectLogin(id, pass);
		System.out.println(user);
		ActionForward forward;// 이동할 페이지에 대한 정보를 담는 글래스
		if (user == null) {
			// 로그인 실패
			forward = mapping.findForward("fail");// struts_config.xml에 정의된
													// 정송페이지 정보
		} else {
			// 영역저장(사용자 정보)
			request.getSession().setAttribute("user", user);
			// 로그인 성공
			forward = mapping.findForward("success");
		}
		return forward;
	}
}
