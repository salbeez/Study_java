package com.kosta.s0525.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.s0525.dao.Dao;
import com.kosta.s0525.dto.Dto;
import com.kosta.t0519.dto.Emp;

@WebServlet("/aaaaa")
public class ctrl extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Dao dao = new Dao();
		PrintWriter out = res.getWriter();
		String str = "";
		String tag = req.getParameter("emp");
		System.out.println(tag);
		if (tag == null) {
			List<String> list = dao.selectAll();
			out.print("[");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i);
				if (i != list.size() - 1) {
					str += "{" + "\"title\":\"" + list.get(i) + "\"},";
				} else {
					str += "{" + "\"title\":\"" + list.get(i) + "\"}";
				}
			}
			out.print(str + "]");
		}
		if (tag != null) {
			System.out.println(tag);

			List<Emp> list = dao.selectAll2();

			out.print("[");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i);
				if (i != list.size() - 1) {
					str += "{" + "\"empno\":\"" + list.get(i).getEmpno() + "\", " + "\"ename\":\""
							+ list.get(i).getEname() + "\"," + "\"hiredate\":\"" + list.get(i).getHiredate() + "\"},";
				} else {
					str += "{" + "\"empno\":\"" + list.get(i).getEmpno() + "\", " + "\"ename\":\""
							+ list.get(i).getEname() + "\"," + "\"hiredate\":\"" + list.get(i).getHiredate() + "\"}";
				}
			}
			out.print(str + "]");
		}
	}
}
