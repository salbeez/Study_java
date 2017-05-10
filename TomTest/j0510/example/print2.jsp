<%@page import="java.util.Arrays"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>입력 페이지2 값 받아오기</title>
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String pw = request.getParameter("pass");//
		String hd = request.getParameter("hdata");
		String f[] =  request.getParameterValues("fruit");
		String room = request.getParameter("room");
		String dinner = request.getParameter("dinner");
		String comment = request.getParameter("comment");
		
	
		Enumeration<String> params = request.getParameterNames();
		out.print("파라매터로 받아온 NAME 속성값 이름");
		while(params.hasMoreElements()){
			String element = params.nextElement();
			out.print(Arrays.toString(request.getParameterValues(element)));
		}
		out.print("<hr><br>");
		
		Map<String, String[]> map = request.getParameterMap();
		Set<String> keys = map.keySet();
		Iterator<String> keySet = keys.iterator();
		while(keySet.hasNext()){
			out.print( keySet.next()+"  ");
		}
	%>
	<%=name%>
	<%=pw%>
	<%=hd%>
	<%=Arrays.toString(f)%>
	<%=room%>
	<%=dinner%>
	<%=comment%>
</body>
</html>