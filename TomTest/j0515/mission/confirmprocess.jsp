<%@page import="com.kosta.t0515.mission.DAO"%>
<%@page import="com.kosta.t0515.mission.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 처리</title>
<script type="text/javascript">
function Go_modifyPage(){
	location.href = "modifyuser.jsp";
}
</script>
</head>
<body>
	<center>
		<%
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");

			DAO dao = new DAO();
			String result = dao.selectLogin(id, pass);
		%>
		<%
			if (result.equals("success")) {
				session.setAttribute("login", "success");
		%>
		<table width="280" border="0" cellpadding="5">
			<tr bgcolor="#3399cc">
				<td><b>로그인 성공</b></td>
			</tr>
			<tr>
				<td>입력하신 아이디와 패스워드를<br> 확인했습니다. <br> <br> <input
					type="button" value="회원정보수정" onclick="Go_modifyPage()"> <input type="button"
					value="회원탈퇴"> <br> <br> <a href="service.jsp">서비스화면</a>
				</td>
			</tr>
		</table>
		<%
			} else if (result.equals("fail_pass")) {
		%>
		<table width="280" border="0" cellpadding="5">
			<tr bgcolor="#3399cc">
				<td><b>로그인 실패</b></td>
			</tr>
			<tr>
				<td>패스워드가 틀립니다.<br> 패스워드를 다시한번 확인해 주시기 바랍니다.<br> <br>
					<a href="userconfirm.jsp">로그인화면</a>
				</td>
			</tr>
		</table>
		<%
			} else {
		%>
		<table width="280" border="0" cellpadding="5">
			<tr bgcolor="#3399cc">
				<td><b>로그인 실패</b></td>
			</tr>
			<tr>
				<td>다시 아이디를 확인하세요.<br> 만약 가입하지 않으신 경우 신규가입을 하시기 바랍니다.<br>
					<br> <a href="userinput.jsp">신규가입</a>
				</td>
			</tr>
		</table>
		<%
			}
		%>
	</center>
</body>
</html>








