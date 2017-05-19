<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과 페이지</title>
<%
	request.setCharacterEncoding("euc-kr");
%>
</head>
<body>
	<h3>결과 페이지</h3>
	<h3>input.jsp에서 보내온 파일을 받아옴</h3>
	<hr>
	이름 :
	<%=request.getParameter("name")%><br> 파일 :
	<%=request.getParameter("myFile")%><br>


	<%
		ServletInputStream sis = request.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(sis));
		String str = null;
		FileOutputStream outS = new FileOutputStream("C:/Users/kosta/git/Study_java/TomTest/upload/a_.txt");
		while ((str = in.readLine()) != null) {
			out.print(str + "<br>");
			outS.write((str+"\n").getBytes());
			System.out.println(str);
		}
		outS.close();
	%>
</body>
</html>