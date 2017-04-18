package com.kosta.j0411.M;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class PersonDAO { // DB관련 전담 클래스

	Connection conn;
	Statement stmt;
	ResultSet rs;

	Properties pro;

	public PersonDAO() {
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
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean insert(PersonDTO person) {

		connect();
		try {
			stmt = conn.createStatement();
			String sql = "insert into person values (person_seq.nextval,'" + person.getName() + "'," + person.getAge()
					+ ",'" + person.getJob() + "')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public boolean delete(int no) { // 특정 행 삭제
		connect();
		try {
			stmt = conn.createStatement();
			String sql = "delete from person where no="+no;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			disconnect();
		}
		return false;
	}

	public boolean update(PersonDTO person) {
		connect();

		try {
			stmt = conn.createStatement();
			String sql = "update person set name='"+person.getName()+"', age="+person.getAge()+", job='"+person.getJob()+"' where no="+person.getNo();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	public Vector<PersonDTO> select(String name) {
		Vector<PersonDTO> personv = new Vector<>();
		connect();
		try {
			stmt = conn.createStatement();
			String sql = "select * from person where name LIKE '"+name+"%' ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				personv.add(
						new PersonDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("age"), rs.getString("job")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();

		return personv;
	}

	public Vector<PersonDTO> selectAll() {
		Vector<PersonDTO> personv = new Vector<>();
		connect();
		try {
			stmt = conn.createStatement();
			String sql = "select no,name,age,job from person";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				personv.add(
						new PersonDTO(rs.getInt("no"), rs.getString("name"), rs.getInt("age"), rs.getString("job")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		disconnect();

		return personv;
	}
}
