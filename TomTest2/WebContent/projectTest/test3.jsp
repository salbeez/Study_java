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
<body>
	<div id="header">aaa</div>
	<div id="header2"><jsp:include page="top.jsp" flush="true"></jsp:include>
	</div>
	<div id="sidebar">side</div>
	<div id="content">
		${sub }<br>
		<c:if test="${sub != null}">하하
			<jsp:include page="${sub }.jsp"></jsp:include>
		</c:if>
	</div>
</body>
</html>