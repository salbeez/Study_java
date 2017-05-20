<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- emp.jsp 모델2 방식 개발 방식 --> jsp는 VIew의 역할
문제) 사원들의 사원번호, 사원명,입사일을 HTML <table>에 출력하시오 --%>
</head>
<body>
	<%
		//jsp페이지 내에서 JDBC를 직접 사용
		//1. 드라이버 로딩 Class.forName("oracle.jdbc.driver.OracleDriver")<<<DB에 따라 파라메터가 다름
		//2. 연결 Connection conn = DriverManager.getConnection("jdbc:driver:thin@local:1521:xe","scott","tiger")
		//3. SQL 실행 Statement stmt >>PreparedStatement pstmt 권장 
		//		3-1) stmt = conn.createStatement();
		//			   stmt.executeQuery(String sql);
		//		3-2) pstmt = conn.prepareStatement(sql);
		//			   pstmt.setString(1,"홍길동")
		//			   pstmt.executeQuery();
		//4.ResultSet rs = pstmt.executeQuery();
		/*while(rs.next())*/
	%>

	<table border="1" cellpadding="5">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>입사일</th>
		</tr>
		<%
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			String sql = "select empno,ename,hiredate from emp";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		%>

		<%
			while (rs.next()) {
				out.println("<tr><td>" + rs.getString("empno") + "</td><td>" + rs.getString("ename") + "</td><td>"
						+ rs.getString("hiredate") + "</td></tr>");
			}
		%>

	</table>
</body>
</html>