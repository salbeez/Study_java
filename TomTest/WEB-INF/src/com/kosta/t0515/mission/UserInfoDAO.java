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

public class UserInfoDAO {//DB����(Access) ���� Ŭ����
	
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
	}//������
	
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
		  pstmt = conn.prepareStatement(sql);//DB�� sql�� ����
		    pstmt.setString(1, user.getId());
		    pstmt.setString(2, user.getPass());
		    pstmt.setString(3, user.getName());
		    pstmt.setString(4, user.getJumin());
		    pstmt.setString(5, user.getBirth());
		    pstmt.setString(6, user.getZip());
		    pstmt.setString(7, user.getAddr());
		    pstmt.setString(8, user.getEmail());
		    pstmt.setString(9, user.getJob());
		  pstmt.executeUpdate();//���޵� sql�� ���� ��û
		  
		  return true;//insert�� DB���� �� ����Ǿ���!!
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();		
		}
	  
	  return false;//insert�� DB���� �� ������� ����!!
	}//insert
	
	
	//id,pass,name,jumin,birth,zip,addr,email,job
	public String update(UserInfo user){
     //������ boolean---> String��ȯ�� ����: �������� ���� ���� �̻��� ���¸� ǥ���ϱ�����
	 //DAO�� �𵨷� �з��ǰ�, ���� ��Ʈ�ѷ��� ȣ��!!
     //��, ��Ʈ�ѷ����� �������� ���� ���¸� ǥ���ϴ� ����.
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
		 int t = pstmt.executeUpdate();//t: ������ ���� ����
		 if(t==1) return "success";
		 else return "fail";
	  } catch (SQLException e) {
		e.printStackTrace();
	  } finally{	 
	     disconnect();
	  }
	  return "fail_db";	
	}//update
	
	public boolean delete(String id){//�� �� ����
	  connect();
	  try {
		String sql="delete from userinfo where id=?";
		  pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, id);
		  int t= pstmt.executeUpdate();//t: ������ ���� ����
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
	public UserInfo select(String id){//���� �˻�(��ȸ)  ---> �������� ����� ������
	   UserInfo user = new UserInfo();	
	   connect();	
	   try {
		String sql="select pass,name,jumin,birth,zip,addr,email,job "
		   		+ " from userinfo where id=?";
		   pstmt = conn.prepareStatement(sql);
		     pstmt.setString(1, id);
		   rs = pstmt.executeQuery();
		   if(rs.next()){//rs.get~() : DB�� ���� �˻��� ��� ���
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
	
	public ArrayList<UserInfo> selectAll(){//����� �˻�(��ȸ)
	   ArrayList<UserInfo> list = new ArrayList<>();
	   
	   return list;
	}//selectAll
	
	public String selectLogin(String id, String pass){
	  //����ǥ��: �α��μ���, �α��ν���(���̵����翩��,�����ġ����)
	  connect();
	  try {
		String sql="select pass from userinfo where id=?";
		  pstmt = conn.prepareStatement(sql); //DB�������� sql�� ����
		    pstmt.setString(1, id);
		  rs = pstmt.executeQuery();//sql�� �����û
		   if(rs.next()){//��ġ�ϴ� id�� �ִٸ�
			   String dpass = rs.getString("pass");
			   if(dpass.equals(pass)){//id����, pass��ġ
				   return "success";
			   }else{//id����, pass����ġ
				   return "fail_pass";
			   }
		   }else{//id�� �������� �ʴ´ٸ�
			       return "fail_id";
		   }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
		  disconnect();	
		}
	  return "fail_db";
	}//selectLogin
	
	public boolean duplicateId(String id){//���̵� �ߺ��˻�
		//�ߺ��� ���̵�:true
	   connect();	
	   try {
		String sql="select count(*) count from userinfo where id=?";
		   pstmt = conn.prepareStatement(sql);
		     pstmt.setString(1, id);
		   rs=pstmt.executeQuery();
		   rs.next();
		   int count = rs.getInt("count");//rs.getInt(1)
		   if(count==1)return true;//�ߺ��� ���̵� �߰�   
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{	   
		   disconnect();
		}
	   return false;//���̵� �ߺ�X
	}//duplicateId

}




