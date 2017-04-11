package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class JDBCTest {

	Connection conn;
	Statement stmt;
	// -------------------------DML 업무
	ResultSet rs;

	// -------------------------DQL 업무 까지
	
	public JDBCTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("db연결 OK");
			
			//ex3) 30번 부서에 근무하는 사원의 정보를 출력
			stmt = conn.createStatement() ;
			int deptno = 20;
			String sql = "select empno,ename, to_char(hiredate,'yy,mm,dd') hiredate from emp where deptno="+deptno;
			
			rs = stmt.executeQuery(sql);
			while(rs.next()){	//한행 얻고

				//그 행에 대한 각각의 데이터를 가져옴
				System.out.println(rs.getInt("empno")+" "+rs.getString("ename")+" "+rs.getString("hiredate"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JDBCTest();
	}
}
