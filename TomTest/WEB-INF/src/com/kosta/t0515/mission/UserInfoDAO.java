package com.kosta.t0515.mission;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserInfoDAO {//DB관련(Access) 전담 클래스
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	DataSource ds;
	
	public UserInfoDAO() {
	   try {
		Context ctx = new InitialContext();
		   Context tomCtx = (Context) ctx.lookup("java:comp/env");
		   ds = (DataSource) tomCtx.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}//생성자
	
	private void connect(){
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//connect
	private void disconnect(){
		try {
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//disconnect	
	
	
	//----DML----	
	
	//id,pass,name,jumin,birth,zip,addr,email,job
	public boolean insert(UserInfo user){
	  connect();
	  try {
		String sql="insert into userinfo (id,pass,name,jumin,birth,zip,addr,email,job) "
		  		  + " values (?,?,?,?,?,?,?,?,?)";
		  pstmt = conn.prepareStatement(sql);//DB에 sql문 전달
		    pstmt.setString(1, user.getId());
		    pstmt.setString(2, user.getPass());
		    pstmt.setString(3, user.getName());
		    pstmt.setString(4, user.getJumin());
		    pstmt.setString(5, user.getBirth());
		    pstmt.setString(6, user.getZip());
		    pstmt.setString(7, user.getAddr());
		    pstmt.setString(8, user.getEmail());
		    pstmt.setString(9, user.getJob());
		  pstmt.executeUpdate();//전달된 sql문 실행 요청
		  
		  return true;//insert가 DB에서 잘 실행되었음!!
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();		
		}
	  
	  return false;//insert가 DB에서 잘 실행되지 않음!!
	}//insert
	
	
	//id,pass,name,jumin,birth,zip,addr,email,job
	public String update(UserInfo user){
     //리턴형 boolean---> String변환한 이유: 실행결과에 대해 세개 이상의 상태를 표현하기위해
	 //DAO는 모델로 분류되고, 모델은 컨트롤러가 호출!!
     //즉, 컨트롤러에게 리턴형을 통해 상태를 표현하는 것임.
     connect();
		
	 try {
		String sql="update userinfo set pass=?,zip=?,addr=?,email=?,job=? "
		 		   + " where id=?";	
		 pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, user.getPass());
		    pstmt.setString(2, user.getZip());
		    pstmt.setString(3, user.getAddr());
		    pstmt.setString(4, user.getEmail());
		    pstmt.setString(5, user.getJob());
		    pstmt.setString(6, user.getId());
		 int t = pstmt.executeUpdate();//t: 수정된 행의 갯수
		 if(t==1) return "success";
		 else return "fail";
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally{	 
	     disconnect();
	  }
	  return "fail_db";	
	}//update
	
	public boolean delete(String id){//한 행 삭제
	  connect();
	  try {
		String sql="delete from userinfo where id=?";
		  pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, id);
		  int t= pstmt.executeUpdate();//t: 삭제된 행의 갯수
		  if(t==1) return true;
		}catch (SQLException e) {
		  e.printStackTrace();
		}finally {
			disconnect();			
		}	  
	  return false;	
	}//delete
	
	
	//----DQL----
	//id,pass,name,jumin,birth,zip,addr,email,job
	public UserInfo select(String id){//한행 검색(조회)  ---> 수정폼에 출력할 데이터
	   UserInfo user = new UserInfo();	
	   connect();	
	   try {
		String sql="select pass,name,jumin,birth,zip,addr,email,job "
		   		+ " from userinfo where id=?";
		   pstmt = conn.prepareStatement(sql);
		     pstmt.setString(1, id);
		   rs = pstmt.executeQuery();
		   if(rs.next()){//rs.get~() : DB로 부터 검색된 결과 얻기
			   user.setId(id);
			   user.setPass(rs.getString("pass"));
			   user.setName(rs.getString("name"));
			   user.setJumin(rs.getString("jumin"));
			   user.setBirth(rs.getString("birth"));
			   user.setZip(rs.getString("zip"));
			   user.setAddr(rs.getString("addr"));
			   user.setEmail(rs.getString("email"));
			   user.setJob(rs.getString("job"));
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{	   
		   disconnect();
		}
	   return user;	
	}//select
	
	public ArrayList<UserInfo> selectAll(){//모든행 검색(조회)
	   ArrayList<UserInfo> list = new ArrayList<>();
	   
	   return list;
	}//selectAll
	
	public String selectLogin(String id, String pass){
	  //상태표현: 로그인성공, 로그인실패(아이디존재여부,비번일치여부)
	  connect();
	  try {
		String sql="select pass from userinfo where id=?";
		  pstmt = conn.prepareStatement(sql); //DB서버에게 sql문 전달
		    pstmt.setString(1, id);
		  rs = pstmt.executeQuery();//sql문 실행요청
		   if(rs.next()){//일치하는 id가 있다면
			   String dpass = rs.getString("pass");
			   if(dpass.equals(pass)){//id존재, pass일치
				   return "success";
			   }else{//id존재, pass불일치
				   return "fail_pass";
			   }
		   }else{//id가 존재하지 않는다면
			       return "fail_id";
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		  disconnect();	
		}
	  return "fail_db";
	}//selectLogin
	
	public boolean duplicateId(String id){//아이디 중복검사
		//중복된 아이디:true
	   connect();	
	   try {
		String sql="select count(*) count from userinfo where id=?";
		   pstmt = conn.prepareStatement(sql);
		     pstmt.setString(1, id);
		   rs=pstmt.executeQuery();
		   rs.next();
		   int count = rs.getInt("count");//rs.getInt(1)
		   if(count==1)return true;//중복된 아이디 발견   
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{	   
		   disconnect();
		}
	   return false;//아이디 중복X
	}//duplicateId

}




