package com.kosta.t0501;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kosta
 * @문제 클라이언트가 전달한 파라미터값 얻기
 */
public class ParamServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet");
		//
		getParamTEST(req,resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");// 주소가의 암호
		//getParamTEST(req);
	}

	private void getParamTEST(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pOut = resp.getWriter();
		pOut.print("<html>"
				+ "<head><title>파라매터 받기</title></head>"
				+ "<body>"
				+ "<h3>id = " + id + "</h3><br>"
				+ "<h3>pw " + pw+ "</h3>"
				+ "</body>"
				+ "</html>");
	}
}
