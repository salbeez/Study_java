<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="basic.css">
<title>Insert title here</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#page1").click(function(){
			$("#content").load("a.jsp");
		});
		$("#login").click(function(){
			$("#content").load("./sign/userconfirm.jsp");
		});
		$("#home").click(function(){
			$("#sidebar").load("./home/home_side.html");
			$().ajax
		});
		$("#intro").click(function(){
			$("#content").load("./home/intro_contents.jsp");
		});
	});
</script>
<body>
	<div id="header">aaa</div>
	<div id="header2"><jsp:include page="top.jsp" flush="true"></jsp:include>
	</div>
	<div id="sidebar">side</div>
	<div id="content"></div>
</body>
</html>