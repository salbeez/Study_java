<%@page import="iba.conf.MySqlMapClient"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<b>Ibatis_FrameWork (SQL MAP 프레임 워크) 테스트</b>
	</h3>
	<%
		SqlMapClient sqlMap = MySqlMapClient.getSqlMapInstance();
	%>
	7788사번 사원명 :<%=(String) sqlMap.queryForObject("selEname")%>
</body>
</html>