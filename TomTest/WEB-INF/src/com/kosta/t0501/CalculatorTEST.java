package com.kosta.t0501;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author kosta
 * @문제 계산기 작성 결과 버튼 클릭시 -> 같은 페이지가 나오지만 추가로 밑줄(결과값)이 추가됨
 */
public class CalculatorTEST extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Insert title here</title></head>"
				+ "<body>"
				+ "<form method=post>"
				+ "<input type=text size=2 name=op1>" 
				+ "<select name=combo>" 
				+ "	<option>+</option>"
				+ "	<option>-</option>" 
				+ "	<option>*</option>" 
				+ "	<option>/</option>" 
				+ "	</select> "
				+ "<input type=text size=2 name=op2>" 
				+ "	<input type=submit value=계산>" 
				+ "</form>");
		
		System.out.println(req.getMethod());
		
		if (req.getMethod().equals("POST")) {
			String op1 = req.getParameter("op1");
			String op2 = req.getParameter("op2");
			String op = req.getParameter("combo");
			// 만약 없는 값을 파라매터로 받으면 애러는 안나지만 이 없는 파라매터를 변수로 받는 타입은 애러가 발생한다.
			String strResult = "";
			if (op1.matches("[0-9]+") && op2.matches("[0-9]+")) {
				int o1 = Integer.parseInt(op1);
				int o2 = Integer.parseInt(op2);
				int result = 0;
				switch (op) {
				case "+":
					result = o1 + o2;
					break;
				case "-":
					result = o1 - o2;
					break;
				case "*":
					result = o1 * o2;
					break;
				case "/":
					result = o1 / o2;
					break;
				default:
					System.out.println("난 바보다.");
					break;
				}
				strResult = result + "";
			}
			String str = "";
			if (!strResult.equals("")) {
				str = "<hr>결과값 : " + op1 + " " + op + " " + op2 + " = " + strResult;
			}
			out.print("</body>" + str + "</html>");
			System.out.println(op1 + " " + op + " " + op2 + " = " + strResult);
		}
	}

	private String a() {
		return null;
	}
}
