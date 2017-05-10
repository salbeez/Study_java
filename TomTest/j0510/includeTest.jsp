<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<font size="12" color="blue">1. include directive(지시자) 테스트 페이지
			입니다</font><hr><br>

		<%@include file="./includePage/menu.jsp"%>
		<table>
			<tr>
				<td><%@include file="./includePage/news.jsp"%></td>
				<td><%@include file="./includePage/shopping.jsp"%></td>
			</tr>
		</table>
	</center>

</body>
</html>