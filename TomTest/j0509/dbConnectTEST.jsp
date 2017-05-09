<%@page import="java.io.FileReader"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="oracle.jdbc.driver.DMSFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!Connection conn;
	Properties pro;%>
	<%
	pro = new Properties();
	pro.load(new FileReader("C:/Users/kosta/git/Study_java/TomTest/conn/conn.properties"));
	Class.forName(pro.getProperty("driver"));
	conn = DriverManager.getConnection(pro.getProperty("url"),pro);
	System.out.print("db연결 성공");
	%>
</body>
</html>