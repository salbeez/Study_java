package com.kosta.t0501;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author kosta
 * @문제 누군가 이 사이트에 접속을 하면 접속한 인원 만큼 출력(ex> 오늘의 )
 */
public class CountServlet extends HttpServlet {
	private int count;

	@Override
	public void init() throws ServletException {
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("service");
		HttpSession session = req.getSession();
		System.out.println("세션 ID = " + session.getId());
		
		DateFormat df = new SimpleDateFormat("YYYY년 MM월 dd일 HH:mm:ss"); // HH=24h, hh=12h
		String lastAccessedTime = df.format(session.getLastAccessedTime());
		System.out.println("세션 LastAccessedTime = " + lastAccessedTime);
		System.out.println("접속자\t\t\t호스트\t\t\t원격포트\t유저");
		System.out.println(req.getRemoteAddr()+" == " +req.getRemoteHost() +" == "+req.getRemotePort()+" == "+ req.getRemoteUser());
		if (session.isNew()) {// 새로운 접속자일경우 True
			count++;
		}
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter pOut = res.getWriter();
		pOut.print("<html>" + "<head>" + "<title>ServletCount</title>" + "</head>" + "<body>" + "<h3>Count Servlet</h3>"
				+ "조회수 : " + count + "회" + "</body>" + "</html>");
	}

	@Override
	public void destroy() {
	}
}
