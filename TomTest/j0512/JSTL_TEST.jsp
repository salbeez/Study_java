<%@page import="com.kosta.t0511.DTO_2"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%--JSTL => JSP Standard Tag Library --%>
</head>
<body>
	<h3>JSTL</h3>
	<c:if test="test">
		HTML마크업,text<br>
		조건식 참일때 실행
	</c:if>

	<c:if test="some text">
		Some test
	</c:if>

	<c:if test="${param.age<20 }">
		<font color="blue">나이가 20 미만 입니다</font>
	</c:if>
	<c:if test="${param.age>=20 }">
		<font color="blue">나이가 20 이상 입니다</font>
	</c:if>
	<c:if test="${param.age>=20 &&  param.age>=30 }">
		<font color="blue">나이가 20대 입니다</font>
	</c:if>
	<hr>

	<c:choose>
		<%-- switch case--%>
		<c:when test="${param.age>19 && param.age<30 }">
			20대 입니다<br>
		</c:when>
		<c:when test="${param.age>29 && param.age<40}">
		</c:when>
		<c:otherwise>
			<%-- default--%>
			20대 또는 30대가 아닙니다
		</c:otherwise>
	</c:choose>

	<h3>
		<b>forEach TEST</b>
	</h3>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="stat">
		<c:if test="${stat.count%2==0 }">
			<font color=blue> JSTL 안녕 ${i }</font>
		</c:if>
		<c:if test="${i%2==1 }">
			<font color=red> JSTL 안녕 ${i }</font>
		</c:if>

		<br>
	</c:forEach>

	<%
		//
		List<String> list = new ArrayList<>();
		list.add("홍준표");
		list.add("나경원");
		list.add("최순실");
		list.add("박근혜");
		list.add("최경환");

		request.setAttribute("nameList", list);

		List<DTO_2> list2 = new ArrayList<>();
		list2.add(new DTO_2("유승민", "13"));
		list2.add(new DTO_2("퐁듄표", "40"));
		list2.add(new DTO_2("심상정", "23"));

		request.setAttribute("nameList2", list2);
	%>

	<h3>이름 목록</h3>
	<hr>
	<ul>
		<c:forEach items="${nameList}" var="name">
			<li>${name}
		</c:forEach>
	</ul>

	<h3>이름 목록 2</h3>
	<table cellpadding="5" border="1">
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
		<c:forEach items="${nameList2}" var="name2">
			<tr>
				<td>${name2.id }</td>
				<td>${name2.pw }</td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>