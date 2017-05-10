<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 데이터 조회 -->
	
	<h3>end.jsp</h3>
	<hr>
	page k1: <%= pageContext.getAttribute("k1") %><br>
	request k1: <%=  request.getAttribute("k1")%><br>
	session k1: <%= session.getAttribute("k1") %><br>
	application k1: <%= application.getAttribute("k1") %><br>
</body>
</html>