<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- session에 user라는 키값이 존재한다면 -->
	<logic:present scope="sesstion" name="user">
		 이름 : <bean:write name="user" scope="session" property="username"/>
	<br> 전화번호 : ${user.phone}
	<br> 이메일 :${user.email }
	<br>
	</logic:present>

	<!-- 존재하지 않는다면 -->
	<logic:notPresent scope="sesstion" name="user">
		<b>로그인 하세요! </b>
	</logic:notPresent>

	<html:messages id="msg" message="true">
		<bean:write name="msg" />
	</html:messages>
	<form action="login.do" method="post">
		아이디 : <input type="text" name="id">
		<%-- 		
		<html:messages id="새로 정의할 변수명" property="validate에서 정의한 키값"></html:messages> 
		--%>
		<html:messages id="msg" property="errorid">
			<font color="red"><bean:write name="msg" /> </font>
		</html:messages>
		<br> 비밀번호 : <input type="password" name="pass">
		<html:messages id="msg" property="errorpass">
			<font color="red"><bean:write name="msg" /> </font>
		</html:messages>
		<br>
		<button>전송</button>
	</form>
</body>
</html>