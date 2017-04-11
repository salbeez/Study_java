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
	// -------------------------DML ����
	ResultSet rs;

	// -------------------------DQL ���� ����
	
	public JDBCTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String user="scott";
			String pw = "tiger";
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("db���� OK");
			
			//ex3) 30�� �μ��� �ٹ��ϴ� ����� ������ ���
			stmt = conn.createStatement() ;
			int deptno = 20;
			String sql = "select empno,ename, to_char(hiredate,'yy,mm,dd') hiredate from emp where deptno="+deptno;
			
			rs = stmt.executeQuery(sql);
			while(rs.next()){	//���� ���

				//�� �࿡ ���� ������ �����͸� ������
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
