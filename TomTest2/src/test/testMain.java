package test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class testMain extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String str= (String) req.getParameter("sub");
		req.setAttribute("sub", str);
		System.out.println(str);
		req.getSession().setAttribute("sub", str);
		res.sendRedirect("projectTest/test3.jsp");
	}
}
