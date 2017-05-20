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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.w3c.dom.stylesheets.LinkStyle;

import com.kosta.t0516.dto.Emp;

/**
 * @author kosta @
 */
public class EmpDAO2 {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	DataSource ds;

	public EmpDAO2() {

		try {
			Context ctx = new InitialContext();
			// 객체등록 bind rebind, 조회 lookup, 삭제 unbind
			Context tomCtx = (Context) ctx.lookup("java:comp/env");
			ds = (DataSource) tomCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// tomCtx: 아파치 톰캣에 설정 (등록)된 객체 조회
	}

	public List<Emp> selectAll() {

		List<Emp> list = new ArrayList<>();
		try {
			conn = ds.getConnection();
			String sql = "select empno,ename,hiredate from emp";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getDate("hiredate")));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
