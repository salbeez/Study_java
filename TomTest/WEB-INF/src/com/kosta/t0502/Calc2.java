package com.kosta.t0502;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc2 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String op1 = req.getParameter("op1").trim();
		String op2 = req.getParameter("op2").trim();
		String op = req.getParameter("combo");

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		if (op1.matches("[0-9]+") && op2.matches("[0-9]+")) {
			if (op.matches("/") && op2.equals("0")) {
				out.print("<html><head><body><font size=20 color=red>0으로는 나눌수가 없습니다</font></body></head></html>");
			} else {
				int a = Integer.parseInt(op1), b = Integer.parseInt(op2);
				float result = 0;

				switch (op) {
				case "+":
					result = a + b;
					break;
				case "-":
					result = a - b;
					break;
				case "*":
					result = a * b;
					break;
				case "/":
					result = a / b;
					break;
				default:
					break;
				}

				out.print("<html><head><body>" + "<h3>결과 페이지</h3>" + "<h1>" + op1 + " " + op + " " + op2 + " = " + result
						+ "</h1>" + "</body></head><html>");
			}
		} else if (op1.length() <= 0 && op2.length() <= 0) {
			out.print("<html><head><body><font size=20 color=red>두수를 입력</font></body></head></html>");
		} else {
			out.print("<html><head><body><font size=20 color=red>숫자만 입력</font></body></head></html>");
		}

	}
}







