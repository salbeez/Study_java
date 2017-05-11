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
		<h3>로그인 화면</h3>
		<div id="d1">
			<form action="selProduct.jsp" method="post">
				이름 : <input type="text" size="3" name="username">
				<%
					System.out.println("로그인 화면 세션id : " + session.getId());
				%>
				<input type="submit" value="로그임">
			</form>
		</div>

		<div id="d2">
			<b><font color="pink" size="13"> 로그인한 상태 입니다 </font> </b><br>
			<hr>
			<button onclick="logOut()">로그 아웃</button>
		</div>

		<script type="text/javascript">
			var d1 = document.getElementById("d1");
			var d2 = document.getElementById("d2");
		</script>
		<%
			if (session.getAttribute("loginName") != null) {
				out.print("<script>d1.style.display='none';d2.style.display='';</script>");
			} else {
				out.print("<script>d2.style.display='none';d1.style.display='';</script>");
			}
		%>
	</center>

</body>
</html>