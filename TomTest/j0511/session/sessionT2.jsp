<%@page import="com.kosta.t0511.DAO_2"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 
역할)
	1. 폼 입력된 ID와 PW를 검사 (인증) 
		DB와 비교를 해서
			>>일치는 >>> 바로 밑에 있는 소스 출력
			>>일치 x >>> 다시 로그인 페이지로 ㄱㄱ씽
 -->
<title>사용자 인증</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.normal {
	font-family: "굴림", "돋움";
	font-size: x-small;
	font-style: normal;
	font-weight: normal;
	text-decoration: none
}

.normalbold {
	font-family: "굴림", "돋움";
	font-size: x-small;
	font-style: normal;
	font-weight: bold;
	text-decoration: none
}
</style>
</head>
<%-- sessionT2.jsp --%>
<%!//DB대신에 hashMap으로 검사 여기에 소스 추가>>> 나중에는 db로 변경
	HashMap<String, String> map = new HashMap<>();%>
<%
/* 	map.put("qwe", "123");

	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pass");

	String dpass = map.get(id);
	System.out.println("사이즈 : " + map.size());
	if (map.get(id) != null) {
		if (dpass.equals(pw)) {//비번 일치
			//로그인 성공
			session.setAttribute("login", "success");
			System.out.println("로그인 성공");
		} else {//비번 불일치
			response.sendRedirect("sessionT1.jsp");
		}
	} else {
		response.sendRedirect("sessionT1.jsp");
	} */
	
	DAO_2 dao = new DAO_2();
	
	//저장	map.put("id","pw" )
%>
<body>
	<center>
		<p class="normalbold">사용자 인증 완료</p>
		<p class="normal">
			<a href="sessionT3.jsp">서비스페이지</a>
		</p>

	</center>
</body>
</html>










