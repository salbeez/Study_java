package com.kosta.j0411;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class NameMenu {
    Connection conn;
    Statement stmt;    
    ResultSet rs;	
    
    public NameMenu() {
	   try {
		//����̹� �ε�(��ǰ�� ����)
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   
	   } catch (ClassNotFoundException e) {
		e.printStackTrace();
	   }
       
    }//������
    
    //���ᰴü����
    private void connect(){ 
    	try {
			//Connection��ü����
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					                              "scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }//connect
    
    //DB�ڿ� ��ȯ
    private void disconnect(){
    	try {
			//DB�ڿ� ��ȯ!!
    		if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }//disconnect    
    
    
    public boolean existName(String name){//�̸��� DB�� �����ϸ� ���� true
       try {
		connect();
		   stmt= conn.createStatement();
		   String sql="select count(*) from names where name='ȫ�浿'";
		    rs = stmt.executeQuery(sql);
		    rs.next();
		    int cnt = rs.getInt(1);	
		    if(cnt>0){
		    	return true;
		    }
	   } catch (SQLException e) {
		e.printStackTrace();
	  }finally{
       disconnect();
	  }
    	return false;
    }//existName
    
    
    public boolean insert(String addName){//�̸� �߰�  
      
    try {
	  connect();
      //Statement��ü����
      stmt = conn.createStatement();
      
      //String sql="insert into names (name) values ('ȫ�浿')";
      String sql="insert into names (name) values ('"+addName+"')"; 
      System.out.println("insert SQL: "+ sql);
      stmt.executeUpdate(sql);//�������(DB�� sql���� ����)
      
            return true;//�Է��� �� �Ǿ���!!
      
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
       return false;
    }//insert
    
    public Vector<String> select(){//�̸� ��ȸ: �̸� ����Ҹ� ȭ�����
      //���ͳ��� ���� ���!!  -----> DB��ȸ�� ����� NameMenuTest���� ����!!
    	
    	Vector<String> v = new Vector<>();
        try {
			connect();    
					
			//Statement��ü���� - stmt.executeQuery("DQL")   stmt.executeUpdate("DML")
			stmt = conn.createStatement();
			
			String sql="select name from names";
			//ResultSet��ü����
			
			   rs=stmt.executeQuery(sql);
			    while(rs.next()){//����
			              //�೻�� �������� ���
			        //rs.getString(int columnIndex); ---> rs.getString(1);
			        //rs.getString(String columnLabel); ---> rs.getString("name");
			    	String name = rs.getString("name");
			    	v.add(name);
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
    	return v;
    }//select
    
    public boolean update(String oldName, String newName){//�̸� ����      		
      
      try {
		connect();     
		  stmt = conn.createStatement();
		  //String sql="update names set name='������½' where name='ȫ�浿'";	
		  String sql="update names set name='"+newName
				           +"' where name='"+oldName+"'";	
		  System.out.println("update SQL: "+ sql);
		  int t = stmt.executeUpdate(sql);//������� (DB�� sql�� ����)
		  //t: ������ ���� ���� ����
		  if(t>0){//������ ���� ���� �Ѵٸ�
		     return true;
		  }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
	        disconnect();
		}    	
        return false;//������ �ȵǾ����� ȣ���� ���� ����!!
    }//update
    
    
    public boolean delete(String delName){//�̸� ���� 
    	try {
			connect();
			stmt = conn.createStatement();
			String sql="delete from names where name='"+delName+"'";
			System.out.println("delete SQL: "+ sql);
			int t= stmt.executeUpdate(sql);//��������(DB�� sql�� ����)
			//t:������ ���� ����
			if(t>0)//������ ���� �����Ѵٸ�!!
			  return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{    		
    	   disconnect();
		}
    	return false;
    }//delete
}





