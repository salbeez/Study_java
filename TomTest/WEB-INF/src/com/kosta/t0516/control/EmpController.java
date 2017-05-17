package com.kosta.t0516.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.t0516.EmpDAO2;
import com.kosta.t0516.dto.Emp;

public class EmpController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EmpDAO2 dao = new EmpDAO2();
		List<Emp> list = dao.selectAll();

		// 데이터 공유 뷰(JSP) request, session으로;
		// request(forward) session(forward,redirect);
		req.setAttribute("list", list);

		// req.getRequestDispatcher("/j0516/emp5.jsp").forward(req, res);
		req.getRequestDispatcher("/j0516/emp6.jsp").forward(req, res);
	}
}
