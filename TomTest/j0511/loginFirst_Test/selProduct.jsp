<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 목록</title>
<%
	request.setCharacterEncoding("UTF-8");
	if (session.getAttribute("loginName") == null) {
		session.setAttribute("loginName", request.getParameter("username"));
	}
	String action = request.getParameter("act");
	if (action != null && action.equals("remove")) {
		session.setAttribute("arrProduct", null);
	}
%>
</head>
<body>
	<%
		String username = (String) session.getAttribute("username");
	%>
	<center>
		<h2>상품 목록</h2>
		<%="[" + session.getAttribute("loginName") + "]님이 로그인한 상태 입니다"%>
		<form action="add.jsp" method="post">
			<select name="product">
				<option>사과</option>
				<option>딸기</option>
				<option>복숭아</option>
				<option>배</option>
				<option>수박</option>
			</select> <input type="submit" value="추가">
		</form>
		<br> <br> <a href="checkOut.jsp">계산</a>

	</center>
</body>
</html>