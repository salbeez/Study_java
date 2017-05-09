package com.kosta.t0508;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	public DAO(String root) {
		try {
			pro = new Properties();
			pro.load(new FileReader(root+"/conn/conn.properties"));
			System.out.println(pro.keySet());
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void connect() {// DB연결 객체 생성
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {// DB자원 반환
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

	public ArrayList<UserInfo> selectAll() {
		ArrayList<UserInfo> users = new ArrayList<>();
		connect();
		String sql = "select empno,ename,hiredate,sal,dname from emp02 inner join dept using(deptno)";
		System.out.println(sql);

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setEmpno(rs.getString("empno"));
				user.setEname(rs.getString("ename"));
				user.setHireDate(rs.getString("hiredate"));
				user.setSal(rs.getString("sal"));
				user.setDeptNo(rs.getString("dname"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return users;
	}
}
