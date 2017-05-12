<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
%>
<body>
	<h3>
		<b>파라미터 데이터 테스트</b>
	</h3>
	<hr>
	이름 :
	<%
		String name = request.getParameter("name");
	%><%=name%><br>
	나이 :
	<%=request.getParameter("age")%><br>
	아무거나 :
	<%=request.getParameter("any")%>

	<h1>
		<b>파라미터 데이터 테스트</b>
		</h3>
		<%-- 얘는 결국 출력만 할뿐 --%>
		이름 : ${param.name }<br> 나이 : ${param.age }<br>
		아무거나 : ${param.any }
</body>
</html>