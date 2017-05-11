<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전달파라미터 출력</h3>
	<hr>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	이름:
	<%=request.getParameter("name")%><br> 비밀번호:
	<%=request.getParameter("pass")%><br> 히든 :
	<%=request.getParameter("hdata")%>
	<br> 좋아하는 과일 :
	<%=Arrays.toString(request.getParameterValues("fruit"))%>
	<br> 강의실 :
	<%=request.getParameter("room")%>
	<br> 저녁식사 :
	<%=request.getParameter("dinner")%><br> 코멘트 :
	<%=request.getParameter("comment")%><br>

	<%
		//파라미터 데이터 얻기
		Enumeration<String> names = request.getParameterNames();
		//폼내의 name속성의 값 얻기
		//names = [name,pass,hdata,fruit,room,dinner,comment];
		while (names.hasMoreElements()) {
			String element = names.nextElement();
			out.print(element + ":" + request.getParameter(element) + "<br>");
		}
	%>
	<%
		Map<String, String[]> map = request.getParameterMap();
		//Key        Value(데이터)
		Set<String> set = map.keySet();//키값만 따로 얻기
		Iterator<String> iter = set.iterator();
		//while(iter.hasNext()){ iter.next() }
		Object key[] = set.toArray();
		for (int i = 0; i < key.length; i++) {
			out.print(key[i] + "<br>");
		}
	%>
</body>
</html>