<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int count, su1, su2, suResult;%>
	<%="=====문제 1======="%><br />
	<%
		out.println("조회 수 : " + count);
		if (session.isNew()) {//TomTest에서 새로운 세션이 있을때
			count++;
		}
	%><br />
	<%="=====문제 2======="%><br />
	<%="구구단"%><br />

	<table cellpadding="5" border="1">
		<%
			for (int i = 1; i < 10; i++) {
				out.print("<tr>");
				for (int j = 1; j < 10; j++) {
					out.print("<td>" + i + " * " + j + " = " + (i * j) + "&nbsp" + "</td>");
		%>

		<%
			} //i end
				out.print("</tr>");
			} //j end
		%>
	</table>
	<%="=====문제 3======="%><br />
	<%="화면에 계산기를 출력하시오"%><br />
	<form action="">
		<input type="text" size="1" name="su1"> <select name="op">
			<option>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</select> <input type="text" size="1" name="su2"> <input type="submit"
			value="결과값?" name="result">
	</form>
	<%
		String color = "";
		String a = request.getParameter("su1");
		String a2 = request.getParameter("su2");
		System.out.print(a);
		if (request.getParameter("su1") != null) {
			if (a.matches("[0-9]+") && a2.matches("[0-9]+")) {

				try {
					su1 = Integer.parseInt(a.trim());
					su2 = Integer.parseInt(a2.trim());
					color = "blue";
					switch (request.getParameter("op")) {
					case "+":
						suResult = su1 + su2;
						break;
					case "-":
						suResult = su1 - su2;
						break;
					case "*":
						suResult = su1 * su2;
						break;
					case "/":
						if (su2 == 0) {
							color = "red";
						} else {
							suResult = su1 / su2;
						}
						break;
					default:
						break;

					}
				} catch (NumberFormatException e) {
					color = "red";
				} finally {
					out.print("<hr color=" + color + ">");
				}
			}
		} else {
			suResult = 0;
		}
	%>
	<%=suResult%>
</body>
</html>