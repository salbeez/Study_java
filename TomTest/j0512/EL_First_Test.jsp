<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%--EL_First_Test.jsp --%>
<body>
	<h3>
		<font color="blue" size="9"> Expression Language(EL)테스트</font>
	</h3>
	k1 :<%
		String data = (String) request.getAttribute("k1");
		int su = 30;
	%>
	<%=data%><br> k2 :
	<%=session.getAttribute("k1")%><br> k3
	<%=application.getAttribute("k1")%><br> su :
	<%=su%><br>

	<h1>EL을 통한 데이터 출력</h1>
	k1 : ${k1}
	<br> k2 : ${k2}
	<br> k3 : ${k3}
	<!-- 영역이 다른데?? 같은 키값으로?? -->
	<br> 2+3 = ${2+3}
	<br> su : ${su} 지역변수는 안됨

	<h3>
		<font color="blue" size="9"> Expression Language(EL)테스트</font>
	</h3>
	<br>k4 (requset) :
	<%=request.getAttribute("k4").toString()%>
	<br>k4 (session) :
	<%=session.getAttribute("k4").toString()%>
	<br>k4 (application) :
	<%=application.getAttribute("k4").toString()%>

	<h1>EL을 통한 데이터 출력</h1>
	<!-- 키 값이 같을 경우 page >> request >> session >> application -->
	k4 (requset) : ${requestScope.k4 }
	<br />
	<font color=pink>이름: ${k4.id }</font>
	<br />
	<font color=pink>나이: ${k4.pw }</font>
	<br /> k4 (session) : ${sessionScope.k4 }
	<br />
	<font color=pink>이름: ${sessionScope.k4.id }</font>
	<br />
	<font color=pink>나이: ${sessionScope.k4.pw }</font>
	<br /> k4 (application) : ${applicationScope.k4 }
	<br />
<%=application.getRealPath("/") %><br>
	<form action="j0512/print.jsp" method="post">
		이름 : <input type="text" size="2" name="name"><br> 나이 : <input
			type="text" size="2" name="age"><br> <input
			type="submit" value="전송">
	</form>
</body>
</html>