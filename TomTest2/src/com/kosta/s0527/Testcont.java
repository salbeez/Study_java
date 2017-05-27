package com.kosta.s0527;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kosta.s0525.dao.Dao;
import com.kosta.t0519.dto.Emp;
@WebServlet("/abcd")
public class Testcont extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Dao dao = new Dao();
		List<Emp> returnList = dao.selectAll2();
		PrintWriter out = res.getWriter();

		///// 불러온 데이터 리스트를 Json객체 형식으로 구현후 다시 클라이언트로 보냄 /////
		JSONArray jArray = new JSONArray();

		for (int i = 0; i < returnList.size(); i++) {
			System.out.println(i+" "+ returnList.get(i).getEmpno());
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("empNo", returnList.get(i).getEmpno());
			jsonObj.put("empName", returnList.get(i).getEname());
			jsonObj.put("empHiredate", returnList.get(i).getHiredate().toString());
			jArray.add(jsonObj);
		}
		
		String str = jArray.toString();
		
		out.print(str);
		out.flush();

		System.out.println(str);
	}
}
