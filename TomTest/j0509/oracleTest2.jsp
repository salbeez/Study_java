<%@page import="java.util.List"%>
<%@page import="com.kosta.t0508.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kosta.t0508.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 사원 테이블 부서테이블을 검색하여 브러우저 화면에 사원 번호,사원명,입사일,급여,부서명을 출력하시오 -->
</head>
<body>
	<%
		DAO dao = new DAO(application.getRealPath("/"));
		List<UserInfo> users = dao.selectAll();
	%>
	<table border="1" cellpadding="5">
		<tr bgcolor="#E1BEE7">
			<th>Empno</th>
			<th>Ename</th>
			<th>HireDate</th>
			<th>Salary</th>
			<th>DName</th>
		</tr>
		<%
			for (UserInfo user : users) {
				out.println("<tr><td>" + user.getEmpno() + "</td>");
				out.println("<td>" + user.getEname() + "</td>");
				out.println("<td>" + user.getHireDate() + "</td>");
				out.println("<td>" + user.getSal() + "</td>");
				out.println("<td>" + user.getDeptNo() + "</td></tr>");
			}
		%>
	</table>
</body>
</html>