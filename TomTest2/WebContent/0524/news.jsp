<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String newsTitles[] = { "김무성 ‘노룩패스’ 논란에 “그걸 내가 왜 해명하나", "'도청' 측 김우빈 기다린다, 쾌유가 최우선",
				"'월드 IT쇼 2017' 주인공 된 삼성전자, LG전자" };

		for (int i = 0; i < newsTitles.length; i++) {
			if (i == 0) {
				out.print("<strong>");
				out.print(newsTitles[i] + "<br>");
				out.print("</strong>");
			} else {
				out.print(newsTitles[i] + "<br>");
			}
		}
	%>


</body>
</html>