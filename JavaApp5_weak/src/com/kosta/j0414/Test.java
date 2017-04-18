package com.kosta.j0414;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Test {
	Connection conn;
	ResultSet rs;

	Properties pro;
	
	CallableStatement proc;
	public Test() {
		connect();
		String sql ="{call exec test_pro(10,2)}";
		try {
			System.out.println(sql);
				proc = conn.prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
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
			if (proc != null)
				proc.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Test();
	}
}
