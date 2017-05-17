package com.kosta.t0501;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// 초기화, 메모리 적재후 가장먼저 1번 호출
		System.out.println("init");
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿 서비스(웹 화면 구성)
		System.out.println("service");
		// 한글 설정(안하면 깨짐)
		response.setContentType("text/html;charset=UTF-8");
		// 웹 화면 출력 객체(응답)를 구성(생성)
		PrintWriter pOut = response.getWriter();
		pOut.println("<html>" + "<head>" + "<title>MyServlet</title>" + "</head>" + "<body>"
				+ "<h1>ServletTest</h1><hr>한글" + "</body>" + "</html>");
		pOut.print("Hello Servlet");

		for (int i = 0; i < 10; i++) {
			pOut.println("<html>" + "<head>" + "</head>" + "<body>" + "<h1>" + redBluePrint(i) +" "+i+ "번째</h1><hr>"
					+ "</body>" + "</html>");
		}

	}

	public String redBluePrint(int i) {
		String str = "";
		if (i % 2 == 0) {
			str = "<font color=" + "red" + " size=" + 10 + ">헬로 서블릿</font>";
		} else {
			str = "<font color=" + "blue" + " size=" + 10 + ">헬로 서블릿</font>";
		}
		return str;

	}

	@Override
	public void destroy() {
		// 메모리 반환 전 호출
		System.out.println("destroy");
	}
}
