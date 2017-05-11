<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		System.out.println("여기는 add.jsp");
		request.setCharacterEncoding("UTF-8");
		String product = request.getParameter("product");

		List products = new ArrayList();
		if (session.getAttribute("arrProduct") == null) {
			products.add(product);
			session.setAttribute("arrProduct", products);
		} else {
			products = (List) session.getAttribute("arrProduct");
			products.add(product);
			session.setAttribute("arrProduct", products);
		}

		out.print("<script>alert('" + product + "(이)가 추가되었습니다!!');history.back()</script>");
	%>
</body>
</html>