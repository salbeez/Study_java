<%@page import="java.sql.SQLException"%>
<%@page import="com.kosta.t0508.UserInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- dbcp(data Source는 곧 커넥션 풀을 의미),JNDI --%>
</head>
<body>
	<h3>DBCP 테스트</h3>
	<hr />
	<%!Context ctx;//bind() 객체 등록,rebind() 재 등록,lookup() 객체 조회,unbind() 객체 해제
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public List<UserInfo> find_Ename(String empno) {

		if (!empno.matches("[0-9]+")) {
			return new ArrayList<UserInfo>();
		}
		String sql = "select ename from emp02 where empno=" + Integer.parseInt(empno);
		List<UserInfo> users = new ArrayList();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setEname(rs.getString("ename"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}%>
	<%
		ctx = new InitialContext();
		Context tomCtx = (Context) ctx.lookup("java:comp/env");//오라클은 이걸로 KEY값 명시
		//TomCtx : 아파치 서버에대한 Context객체 context.xml에 정의한거를 쓸수 있게 한다
		DataSource ds = (DataSource) tomCtx.lookup("jdbc/oracle");
		//ds란 커넥션 풀을 의미
		conn = ds.getConnection();//쉬고 있는 커넥션 하나 줘!
		out.print("DB 연결 성공");

		//sql실행 7788 사번을 갖는 사원의 이름 출력하시오
	%>
	<form method="post">
		<input type="2" name=eNo> <input type="submit" value="검색">
	</form>
	<%
		if (request.getParameter("eNo") != null) {
			System.out.println(request.getParameter("eNo"));
			List<UserInfo> users = find_Ename(request.getParameter("eNo"));
			if (users.size() > 0) {
				for (UserInfo user : users) {
					out.print(user.getEname());
					System.out.println(user.getEname());
				}
			} else {
				out.print("검색된 결과가 없습니다");
			}
			conn.close();
		}
	%>
</body>
</html>