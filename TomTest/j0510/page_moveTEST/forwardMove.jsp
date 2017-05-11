<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>forward_move.jsp</h3>
	<%
		RequestDispatcher dispatcher = request.getRequestDispatcher("/page_moveTEST/result.jsp");// '/'를 써야함
		dispatcher.forward(request, response);
	%>
</body>
</html>