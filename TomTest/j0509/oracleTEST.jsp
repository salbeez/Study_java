<%@page import="com.kosta.t0508.UserInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	private void init2() {
		try {
			pro = new Properties();
			pro.load(new FileReader("C:/Users/kosta/git/Study_java/TomTest/conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
			System.out.println("DB연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {// DB종료
		try {
			if (rs != null)
				rs.close();
			// if(stmt!=null)stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect

	private ArrayList<UserInfo> selectAll() {
		ArrayList<UserInfo> users = new ArrayList<>();
		try {
			init2();
			connect();
			String sql = "select * from emp02";
			System.out.println(sql);

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setEmpno(rs.getString("empno"));
				user.setEname(rs.getString("ename"));
				user.setJob(rs.getString("job"));
				user.setMgr(rs.getString("mgr"));
				user.setHireDate(rs.getString("hiredate"));
				user.setSal(rs.getString("sal"));
				user.setDeptNo(rs.getString("deptno"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return users;
	}%>
	<%
		ArrayList<UserInfo> users = selectAll();
	%>
	<table border="1" cellpadding="5">
		<tr>
			<th>Empno</th>
			<th>Ename</th>
			<th>Job</th>
			<th>Mgr</th>
			<th>HireDate</th>
			<th>Salary</th>
			<th>DeptNo</th>
		</tr>
		<%
			for (UserInfo user : users) {
				out.println("<tr><td>" + user.getEmpno() + "</td>");
				out.println("<td>" + user.getEname() + "</td>");
				out.println("<td>" + user.getJob() + "</td>");
				out.println("<td>" + user.getMgr() + "</td>");
				out.println("<td>" + user.getHireDate() + "</td>");
				out.println("<td>" + user.getSal() + "</td>");
				out.println("<td>" + user.getDeptNo() + "</td></tr>");
			}
		%>
	</table>
	<%
		
	%>
</body>
</html>