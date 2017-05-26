<%@page import="java.util.List"%>
<%@page import="iba.conf.MySqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- zip_result.jsp --%>
<%
	request.setCharacterEncoding("UTF-8");

	SqlMapClient sqlMap = MySqlMapClient.getSqlMapInstance();

	String action = request.getParameter("action");
	List<String> list = null;
	if (action.equals("sido")) {
		list = sqlMap.queryForList("selectSido");
	} else if (action.equals("gugun")) {
		String sido = request.getParameter("sido");
		list = sqlMap.queryForList("selectGugun", sido);
	} else {
		String gugun = request.getParameter("gugun");
		System.out.print(gugun);
		list = sqlMap.queryForList("selectDong", gugun);
	}

	out.print("<option>==선택==</option>");
	for (int i = 0; i < list.size(); i++) {
		out.print("<option>" + list.get(i) + "</option>");
	}
%>