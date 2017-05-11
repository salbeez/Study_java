<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("UTF-8");//전달 파라매터에 대한 한글 문자 설정
%>
</head>
<body>
	<h1>이 페이지는 result.jsp 입니다</h1>
<% %>
	<%@include file="print.jsp"%>
	<form action="">
		<button>print.jsp로</button>
	</form>
</body>
</html>