package com.kosta.j0410;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
	public static void main(String[] args) {//Conn,Stmt,ResultSet
		// 1.드라이버 로딩

		// 2. 연결객체 생성 :
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = 
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		// 3. Statement 객체 생성 ==> SQL쓰기 위해
			Statement stmt = conn.createStatement();
			
		//	ex1)테이블 dept_copy에서 10,30부서를 삭제
			String sql = "delete from dept_copy where deptno in(10,30)";//여기서는 끝에 세미클론을 쓰면 안된다 "~~~;";(x)


		//실행
			int t= stmt.executeUpdate(sql);
			System.out.println("삭제된 행의 갯수 "+t);
			//이클립스는 오토 커밋
		// ex2) 20번 부서의 부서번호, 부서명, 부서 위치를 출력
			//ResultSet객체 생성 ==> 왜? 조회된 행열 데이터를 담기 위해서
			int deptno = 20;
			String sql2 = "select deptno,dname,loc from dept_copy where deptno="+deptno;
			ResultSet rs = stmt.executeQuery(sql2);
			//4.1 한 행 얻어오기 rs.next()
				rs.next();
			//4.2 행 내의 데이터 얻어오기 rs.get자료형(인덱스:[인덱스는 1부터 시작] || 컬럼명)
/*				rs.getInt(1);
				rs.getString(2);
				rs.getString(3);*/
				
				int no = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc =  rs.getString("loc");
				
				System.out.println(no+"부서의 부서명은 "+dname+ "이고 "+loc+"에서 위치해 있습니다");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
