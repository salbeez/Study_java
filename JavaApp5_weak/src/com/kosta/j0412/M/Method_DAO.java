package com.kosta.j0412.M;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

import com.kosta.j0411.M.PersonDTO;

public class Method_DAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	Properties pro;

	
	public Method_DAO() {
		// C:\Users\kosta\git\Study_java\JavaApp5_weak\conn\conn.properties
		String path = "C:/Users/kosta/git/Study_java/JavaApp5_weak/conn/conn.properties";
		pro = new Properties();
		try {
			pro.load(new FileInputStream(path));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean insert(PersonBean person) {
		connect();
		try {

			String sql = "insert into userinfo values (?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getPass());
			pstmt.setString(3, person.getName());
			pstmt.setString(4, person.getSsn1());
			pstmt.setString(5, person.getSsn2());
			pstmt.setString(6, person.getTel());
			pstmt.setString(7, person.getAddr());
			pstmt.setString(8, person.getJob());
			
			System.out.println(sql);

			int row = pstmt.executeUpdate();
			if (row > 0) {// 로그인 성공
				System.out.println("검색된 행의 수 : " + row);
				return true;
			} else {// 검색 실패
				System.out.println("검색된 행의 수 : " + row);
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;

	}

	public boolean delete(String id) {
		connect();

		System.out.println("DB CONNECT Succ");
		try {
			String sql = "delete from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println(sql);

			int row = pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false; // 특정 행 삭제

	}

	public boolean update(PersonBean person) {
		connect();

		System.out.println("DB CONNECT Succ");
		try {
			String sql = "update userinfo set pass=?, tel=?, addr=?, job=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getPass());
			pstmt.setString(2, person.getTel());
			pstmt.setString(3, person.getAddr());
			pstmt.setString(4, person.getJob());
			pstmt.setString(5, person.getId());
			
			System.out.println(sql);

			int row = pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean select(PersonBean person) {// 로그인시 검색부분
		connect();

		System.out.println("DB CONNECT Succ");
		try {
			String sql = "select count(*) cnt from userinfo where id=? AND pass=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getPass());
			System.out.println(sql);

			ResultSet row = pstmt.executeQuery();
			row.next();
			System.out.println(row.getInt("cnt"));
			if (row.getInt("cnt") > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean selectDuple(String name) {// 가입시 아이디가 있는지 확인
		connect();
		try {
			String sql = null;
			sql = "select id,pass from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			System.out.println(sql);

			ResultSet row = pstmt.executeQuery();
			if (row.next()) {// 로그인 성공
				return true;
			} else {// 검색 실패
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public Vector<PersonBean> selectId(String name) {// 가입시 아이디가 있는지 확인
		connect();
		Vector<PersonBean> personv = new Vector<>();
		try {
			String sql = null;
			sql = "select * from userinfo where name LIKE '?%' ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			System.out.println(sql);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// 로그인 성공
				personv.add(new PersonBean(rs.getString("id"), rs.getString("pass"), rs.getString("name"),
						rs.getString("ssn1"), rs.getString("ssn2"), rs.getString("tel"), rs.getString("addr"),
						rs.getString("job")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return personv;
	}

	public Vector<PersonBean> selectAll() {// 전체보기
		Vector<PersonBean> personv = new Vector<>();
		connect();
		try {
			String sql = "select * from userinfo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			/*
			 * private String id; private String pass; private String name;
			 * private int ssn1; private int ssn2; private String tel; private
			 * String addr; private String job;
			 */
			while (rs.next()) {
				personv.add(new PersonBean(rs.getString("id"), rs.getString("pass"), rs.getString("name"),
						rs.getString("ssn1"), rs.getString("ssn2"), rs.getString("tel"), rs.getString("addr"),
						rs.getString("job")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();

		return personv;
	}
}
