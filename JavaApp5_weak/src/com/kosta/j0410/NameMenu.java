package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class NameMenu {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	String url, user, pw;

	public NameMenu() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			pw = "tiger";

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean existName(String name) {// 이름이 배열에 존재하면 리턴 true
		return false;
	}// existName

	public boolean insert(String addName) {// 이름 추가
		try {
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "insert into names (name) values ('"+ addName +"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();//하나의 유저만 쓸거라면 끄지 않아서
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}// insert

	public Vector<String> select(String tableName) {
		Vector<String> v = new Vector<>();
		System.out.println(v.size());
       
		try {
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "select * from names" ;
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				v.add(rs.getString("name"));
			}
			System.out.println("벡터사이즈:"+v.size());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return v;
		// 이름 조회: 이름 저장소를 화면출력
	}// select

	public boolean update(String tableName, String oldName, String newName) {// 이름
																				// 변경
		try {
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "update names set name='" + newName + "' where name= ' " + oldName + " ' ";
			System.out.println(sql);
			int t= stmt.executeUpdate(sql);
			if(t!=0){
			System.out.println("수정 성공");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;// 수정이 안되었음을 호출한 곳에 전달!!
	}// update

	public boolean delete(String delName) {
		try {
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "delete from names where name='" + delName + "'";
			System.out.println(sql);

			stmt.executeUpdate(sql);
			System.out.println("삭제 성공");
			stmt.executeUpdate("commit");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;// 이름 삭제
	}// delete
}