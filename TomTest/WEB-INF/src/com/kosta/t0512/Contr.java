package com.kosta.t0512;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.t0511.DTO_2;

/**
 * @author kosta @
 */
public class Contr extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 영역 request ---->session ----> application에 저장
		HttpSession session = req.getSession();

		// app는 세션이 없어도 찾는다 왜냐 부모 Context에서 찾을수 있으니
		ServletContext application = getServletContext();

		req.setAttribute("k1", "홍길동");
		session.setAttribute("k2", "길라임");
		application.setAttribute("k3", "홍길동");

		DTO_2 p1 = new DTO_2("안철수", "20");
		DTO_2 p2 = new DTO_2("홍준표", "20");
		DTO_2 p3 = new DTO_2("유승민", "20");

		req.setAttribute("k4", p1);
		session.setAttribute("k4", p2);
		application.setAttribute("k4", p3);

		// 페이지 이동
		String action = req.getParameter("action");
		RequestDispatcher dispatcher = null;

		if (action == null || action.equals("test")) {
			dispatcher = req.getRequestDispatcher("/j0512/EL_First_Test.jsp");
		} else if (action.equals("login")) {
			dispatcher = req.getRequestDispatcher("/j0511/session/sessionT1.jsp");
		}
		dispatcher.forward(req, res);
	}
}
