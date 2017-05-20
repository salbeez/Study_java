package com.kosta.signUp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAO_User {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	Properties pro;

	Context ctx;
	DataSource ds;

	public DAO_User() {
		try {
			ctx = new InitialContext();
			Context tomCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) tomCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
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

	public boolean db_idCheck(String id) {
		List<UserInfo> users = new ArrayList<>();
		System.out.println("중복창에서 받은 ID : " + id);
		try {
			conn = ds.getConnection();
			String sql = "select id from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
				System.out.println("ID찾음");
				return true;
			} else {
				System.out.println("ID 없음");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
