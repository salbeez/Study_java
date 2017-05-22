<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		아이디 : <input type="text" name="id">
		<%-- 		
		<html:messages id="새로 정의할 변수명" property="validate에서 정의한 키값"></html:messages> 
		--%>
		<html:messages id="msg" property="errorid">
			<font color="red"><bean:write name="msg"/> </font>
		</html:messages>
		<br> 비밀번호 : <input type="password" name="pass"> 
		<html:messages id="msg" property="errorpass">
			<font color="red"><bean:write name="msg"/> </font>
		</html:messages>
		<br>
		<button>전송</button>
	</form>
</body>
</html>