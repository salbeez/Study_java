<%@page import="com.kosta.signUp.DAO_User"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String id = request.getParameter("id");
	if (id != null) {
		if (id.matches("^[a-zA-Z]{1}[a-zA-Z0-9]{2,11}")) {//아이디는 오로지 문자+숫자 6 -12자리 단,첫글자는 문자로
			System.out.println(request.getParameter("id"));
			DAO_User dao = new DAO_User();
			if (dao != null && dao.db_idCheck(id)) {
				System.out.println("중복된 아이디가 있습니다");
			} else {
				System.out.println("해당 아이디를 쓸수 있습니다");
				out.print("<script> opener.document.frm.id.value='" + id + "';self.close(); </script>");
			}
		}else{
			out.print("아이디는 첫글자는 문자로 시작해야 합니다(6-12자리)");
		}
	}
%>
<body>
	<form action="" method="post">
		아이디 : <input type="text" size="3" name="id"> <input
			type="submit" value="중복확인">
	</form>
</body>
</html>