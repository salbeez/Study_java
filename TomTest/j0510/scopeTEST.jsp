<%@page import="com.kosta.t0510.person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 영역객체에 대한 데이터 저장 -->
	<h3>scopeTEST.jsp</h3>		
	<%
	String name = "길동";
	
	//저장 각기 다른 공간임
	pageContext.setAttribute("k1", name);
	request.setAttribute("k1", "길라임");
	session.setAttribute("k1", "김주원");
	application.setAttribute("k1", "김유신");
	
	//request.getRequestDispatcher("/j0510/end.jsp").forward(request, response);
	
	person p =new person("지영준",27,"학생");
	
	session.setAttribute("p", p);
	person p2 =  (person)session.getAttribute("p");
	%>
	<%=p2.getName() %>
	<%=p2.getAge() %>
	<%=p2.getJob() %>
</body>
</html>