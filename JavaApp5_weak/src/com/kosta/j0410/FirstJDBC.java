package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args) {//Conn,Stmt,ResultSet
		// 1.����̹� �ε�

		// 2. ���ᰴü ���� :
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		// 3. Statement ��ü ���� ==> SQL���� ����
			Statement stmt = conn.createStatement();
			
		//	ex1)���̺� dept_copy���� 10,30�μ��� ����
			String sql = "delete from dept_copy where deptno in(10,30)";//���⼭�� ���� ����Ŭ���� ���� �ȵȴ� "~~~;";(x)


		//����
			int t= stmt.executeUpdate(sql);
			System.out.println("������ ���� ���� "+t);
			//��Ŭ������ ���� Ŀ��
		// ex2) 20�� �μ��� �μ���ȣ, �μ���, �μ� ��ġ�� ���
			//ResultSet��ü ���� ==> ��? ��ȸ�� �࿭ �����͸� ��� ���ؼ�
			int deptno = 20;
			String sql2 = "select deptno,dname,loc from dept_copy where deptno="+deptno;
			ResultSet rs = stmt.executeQuery(sql2);
			//4.1 �� �� ������ rs.next()
				rs.next();
			//4.2 �� ���� ������ ������ rs.get�ڷ���(�ε���:[�ε����� 1���� ����] || �÷���)
/*				rs.getInt(1);
				rs.getString(2);
				rs.getString(3);*/
				
				int no = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc =  rs.getString("loc");
				
				System.out.println(no+"�μ��� �μ����� "+dname+ "�̰� "+loc+"���� ��ġ�� �ֽ��ϴ�");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
