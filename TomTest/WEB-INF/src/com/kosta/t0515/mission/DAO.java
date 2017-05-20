package com.kosta.t0515.mission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import oracle.net.aso.p;

/**
 * @author kosta
 * @메소드명 : 보통 insert말고 다른걸 쓰는게 좋고 보통 5개정도
 * @나중에는 interface로 바뀐다
 */
public class DAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;

	public DAO() {
		try {
			Context ctx = new InitialContext();
			Context tomCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) tomCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connect() {
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void disconnect() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// -------DML------
	public boolean insert(UserInfo user) {
		try {
			connect();
			String sql = "INSERT INTO userinfo VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println(sql);
			System.out.println(user.getId());
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getJumin());
			pstmt.setString(5, user.getBirth());
			pstmt.setString(6, user.getZip());
			pstmt.setString(7, user.getAddr());
			pstmt.setString(8, user.getEmail());
			pstmt.setString(9, user.getJob());
			pstmt.executeUpdate();
			System.out.println("insert 성공");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// insert

	public String update(UserInfo user) {
		// boolean보다 더 많은 상태를 표기하기 위해 return형을 String으로함

		return null;
	}// update

	public boolean delete(String id) {
		return false;// 한행 삭제
	}// delete

	// -------DQL------
	public UserInfo select(String id) {// 한행 검색(조회)
		UserInfo user = new UserInfo();
		connect();
		try { 
			String sql = "select * from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setPass(rs.getString("pass"));
				user.setName(rs.getString("name"));
				user.setJumin(rs.getString("jumin"));
				user.setBirth(rs.getString("birth"));
				user.setZip(rs.getString("zip"));
				user.setAddr(rs.getString("addr"));
				user.setEmail(rs.getString("email"));
				user.setJob(rs.getString("job"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}// select

	public List<UserInfo> selectAll() {// 모든행 검색
		List<UserInfo> list = new ArrayList<>();
		return list;
	}// selectAll

	public String selectLogin(String id, String pass) {
		// 상태표현: 로그인 성공, 실패1 아이디존재x, 실패2비번 x
		connect();

		try {
			String sql = "select pass from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {// 일단 아이디가 존재하고

				String dpass = rs.getString("pass");
				if (dpass.equals(pass)) {
					return "success";
				} else {
					return "fail_pass";
				}
			} else {// id가 존재 x
				return "fail_id";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}// selectLogin
}
