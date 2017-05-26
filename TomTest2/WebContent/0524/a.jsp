<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>입력폼</h3>
	<form>
		이름 : <input type="text" name="name"> <input type="submit"
			value="전송">
	</form>

	<%
		String name = request.getParameter("name");
		if (name != null) {
			out.print(name+"안녕");
		}
	%>
</body>
</html>