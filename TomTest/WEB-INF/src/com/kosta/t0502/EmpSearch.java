package com.kosta.t0502;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.JdbcRowSet;

/**
 * @author kosta
 *	@lib 런타임시 사용하는 라이브러리 lib 폴더에 오라클.jar이 있어야 함
 */
public class EmpSearch extends HttpServlet {
	DaoPerson dao;
	UserInfo user;
	Vector<UserInfo> users;
	String str="";
	@Override
	public void init() throws ServletException {
		
		ServletContext application = getServletContext();
		System.out.println(application.getRealPath("/"));
		
		dao = new DaoPerson(application.getRealPath("/"));
		user = new UserInfo();
		users= new Vector<>();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		users = dao.selectAll();
		System.out.println("=="+users.size());
		for (int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i).getId());
		}
		

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("<html><head>"
				+ "<body>"
				+ "<table border=1>"
					+ "<tr>"
					+ "<th>사번</th>"
					+ "<th>이름</th>"
					+ "<th>입사일</th>"
					+ "<th>급여</th>"
					+ "<th>부서명</th>"
					+ "<tr>");
		
		for(int i=0; i< users.size(); i++){
		str +=	"<tr>"
				+ "<td>"+users.get(i).getId()+"</td>"
				+ "<td>"+users.get(i).getName()+"</td>"
				+ "<td>"+users.get(i).getHiredate()+"</td>"
				+ "<td>"+users.get(i).getSal()+"</td>"
				+ "<td>"+users.get(i).getDname()+"</td>"
					+ "</tr>";
		}
		out.println(str+"</table></body></head></html>");
	}

}
