<%@page import="com.sun.xml.internal.bind.v2.runtime.NameList"%>
<%@page import="com.kosta.s0525.dao.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- suggest.jsp(제시어 출력) --%>
<%
	
%>

<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
	keyword = keyword.toUpperCase();

	Dao dao = new Dao();
	List<String> list = dao.selectKeyword(keyword);
	System.out.println(list.get(0));
	System.out.println("요청 keyword: " + keyword);

	out.print(list.size() + "|");
	for (int i = 0; i < list.size(); i++) {
		out.print(list.get(i));
		if (i < list.size() - 1)
			out.print(",");
	}
%>






