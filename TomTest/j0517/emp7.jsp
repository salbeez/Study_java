<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%-- ibatis를 사용
	EmpDAO3.java
	EmpController.java
 --%>
<body>
	<table>
		<tr>
			<th>사번</th>
			<th>이름</th>
			<th>입사일</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td><fmt:formatDate value="${emp.hiredate }" pattern="MM/dd"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>