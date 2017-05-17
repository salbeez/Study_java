package com.kosta.t0502;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;

public class DaoPerson {// DAO (Data Access Object) : DB전담 클래스

	Connection conn;
	// Statement stmt;
	PreparedStatement pstmt;

	// 왜? sql문을 DB에 전달하기 위해 ---> executeUpdate(), executeQuery()
	ResultSet rs;
	// 왜? 조회sql문을 실행한 결과 데이터를 담기 위해서!!

	Properties pro;
//ServletConfig (현재)서블릿 클래스 각각 한개
//ServletContext 여러 서블릿(TomTest 전체)
	
//플러그인 환경 emp만 연습
	public DaoPerson(String rootPath) {
		try {
			pro = new Properties();
			pro.load(new FileReader(rootPath+"conn/conn.properties"));
			System.out.println(pro.keySet());
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자

	private void connect() {// DB연결 객체 생성
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {// DB자원 반환
		try {
			if (rs != null)
				rs.close();
			// if(stmt!=null)stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect

	public boolean insert(UserInfo user) {
		connect();

		try {

			String sql = "insert into userinfo values (?,?,?,?,?,?,?,?)";
			System.out.println("insert SQL: " + sql);

			pstmt = conn.prepareStatement(sql);// sql문 전송
			pstmt.setString(1, user.getId());
			pstmt.executeUpdate();// 실행해라!!

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}// insert

	public boolean update(UserInfo user) {// (특정)회원정보 수정
		connect();
		try {
			String sql = "update userinfo set pass=?,tel=?,addr=?,job=? where id=?";

			pstmt = conn.prepareStatement(sql);// sql문 전송
			pstmt.setString(5, user.getId());
			int t = pstmt.executeUpdate();// 실행해라!!
			if (t == 1)
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		return false;
	}// update

	public boolean delete(String id) {// 회원탈퇴
		connect();
		try {
			String sql = "delete from userinfo where id=?";
			pstmt = conn.prepareStatement(sql);// sql문 전송
			pstmt.setString(1, id);// 데이터 입력
			int t = pstmt.executeUpdate();// 실행해라!!
			if (t == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// delete

	public boolean selectLogin(String id, String pass) {// 로그인 정보 조회 - 로그인폼
		connect();
		try {
			String sql = "select count(*) cnt from userinfo where id=? and pass=?";
			System.out.println("login SQL: " + sql);
			pstmt = conn.prepareStatement(sql);// 미리 sql문 전송!!
			// ?의 수 만큼 데이터를 값대입!!
			// pstmt.setString(int index,String x);//index: ?의 순서번호
			pstmt.setString(1, id);// 1: 첫번째 물음표
			pstmt.setString(2, pass);// 2: 두번째 물음표

			rs = pstmt.executeQuery();// 실행해라!!

			if (rs.next()) {
				// int count = rs.getInt("count(*)");//(X)
				// int count = rs.getInt(1);//(O)
				int count = rs.getInt("cnt");// (O)
				if (count > 0)
					return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// selectLogin

	public Vector<UserInfo> selectAll() {// 전체데이터(전체행) 검색 -JTable
		connect();
		Vector<UserInfo> users = new Vector<>();
		try {
			String sql = "select empno,ename,to_char(hiredate,'yyyy\"년\" mm\"월\" dd\"일\"') hiredate,sal,dname from emp inner join dept using(deptno)";
			// sql전송
			pstmt = conn.prepareStatement(sql);
			// 데이터전송
			// sql실행
			rs = pstmt.executeQuery();
			while (rs.next()) {// 한 행 얻기
				UserInfo user = new UserInfo();
				user.setId(rs.getString(1));
				user.setName(rs.getString(2));
				user.setHiredate(rs.getString(3));
				user.setSal(rs.getString(4));
				user.setDname(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return users;
	}// selectAll

	public UserInfo select(String id) {// 특정 행 한개를 검색 -수정폼
		connect();
		UserInfo user = null;
		// userinfo: id,pass,name,ssn1,ssn2,tel,addr,job
		try {
			String sql = "select id,pass,name,ssn1,ssn2,tel,addr,job from userinfo" + " where id = ?";// 특정
																										// 아이디명으로
																										// 시작하는~

			pstmt = conn.prepareStatement(sql); // sql문을 먼저 전송
			pstmt.setString(1, id);// 데이터전송(물음표의 수 만큼)
			rs = pstmt.executeQuery();// sql실행

			if (rs.next()) {// 한 행 얻기 (일치하는 아이디를 찾았다면)
				user = new UserInfo();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return user;
	}// select

	public Vector<UserInfo> selectId(String searchId) {// 부분 행 데이터(아이디 검색조건을
														// 충족하는) 검색 -JTable
		connect();
		Vector<UserInfo> users = new Vector<>();
		// userinfo: id,pass,name,ssn1,ssn2,tel,addr,job
		try {
			String sql = "select id,name,ssn1,ssn2,tel,addr,job from userinfo " + "where id like ?";// 특정
																									// 아이디명으로
																									// 시작하는~
			// sql전송
			pstmt = conn.prepareStatement(sql);
			// 데이터전송(물음표의 수 만큼)
			pstmt.setString(1, "%" + searchId);
			// sql실행
			rs = pstmt.executeQuery();
			while (rs.next()) {// 한 행 얻기
				UserInfo user = new UserInfo();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return users;
	}// selectId

}// UserInfo

