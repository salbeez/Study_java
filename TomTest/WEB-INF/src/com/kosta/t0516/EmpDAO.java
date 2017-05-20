package com.kosta.t0516;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.w3c.dom.stylesheets.LinkStyle;

import com.kosta.t0516.dto.Emp;

public class EmpDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	Properties pro;

	public EmpDAO() {
	}

	public EmpDAO(String rootPath) {

		try {
			pro = new Properties();
			pro.load(new FileInputStream(new File(rootPath + "conn/conn.properties")));
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<Emp> selectAll() {
		List<Emp> list = new ArrayList<>();
		String sql = "select empno,ename,hiredate from emp";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getDate("hiredate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;

	}

}
