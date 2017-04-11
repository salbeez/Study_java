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

	public boolean existName(String name) {// �̸��� �迭�� �����ϸ� ���� true
		return false;
	}// existName

	public boolean insert(String addName) {// �̸� �߰�
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
					conn.close();//�ϳ��� ������ ���Ŷ�� ���� �ʾƼ�
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
			System.out.println("���ͻ�����:"+v.size());

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
		// �̸� ��ȸ: �̸� ����Ҹ� ȭ�����
	}// select

	public boolean update(String tableName, String oldName, String newName) {// �̸�
																				// ����
		try {
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "update names set name='" + newName + "' where name= ' " + oldName + " ' ";
			System.out.println(sql);
			int t= stmt.executeUpdate(sql);
			if(t!=0){
			System.out.println("���� ����");
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
		return false;// ������ �ȵǾ����� ȣ���� ���� ����!!
	}// update

	public boolean delete(String delName) {
		try {
			conn = DriverManager.getConnection(url, user, pw);
			stmt = conn.createStatement();
			String sql = "delete from names where name='" + delName + "'";
			System.out.println(sql);

			stmt.executeUpdate(sql);
			System.out.println("���� ����");
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
		return false;// �̸� ����
	}// delete
}