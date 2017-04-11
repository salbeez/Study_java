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
		//드라이버 로딩(제품군 선택)
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   
	   } catch (ClassNotFoundException e) {
		e.printStackTrace();
	   }
       
    }//생성자
    
    //연결객체생성
    private void connect(){ 
    	try {
			//Connection객체생성
	    conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
					                              "scott","tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
    }//connect
    
    //DB자원 반환
    private void disconnect(){
    	try {
			//DB자원 반환!!
    		if(rs != null)rs.close();
			if(stmt != null)stmt.close();
			if(conn != null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }//disconnect    
    
    
    public boolean existName(String name){//이름이 DB에 존재하면 리턴 true
       try {
		connect();
		   stmt= conn.createStatement();
		   String sql="select count(*) from names where name='홍길동'";
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
    
    
    public boolean insert(String addName){//이름 추가  
      
    try {
	  connect();
      //Statement객체생성
      stmt = conn.createStatement();
      
      //String sql="insert into names (name) values ('홍길동')";
      String sql="insert into names (name) values ('"+addName+"')"; 
      System.out.println("insert SQL: "+ sql);
      stmt.executeUpdate(sql);//실행시점(DB에 sql문을 전달)
      
            return true;//입력이 잘 되었음!!
      
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			disconnect();
		}
       return false;
    }//insert
    
    public Vector<String> select(){//이름 조회: 이름 저장소를 화면출력
      //벡터내의 값을 출력!!  -----> DB조회된 결과를 NameMenuTest에게 전달!!
    	
    	Vector<String> v = new Vector<>();
        try {
			connect();    
					
			//Statement객체생성 - stmt.executeQuery("DQL")   stmt.executeUpdate("DML")
			stmt = conn.createStatement();
			
			String sql="select name from names";
			//ResultSet객체생성
			
			   rs=stmt.executeQuery(sql);
			    while(rs.next()){//행얻기
			              //행내의 열데이터 얻기
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
    
    public boolean update(String oldName, String newName){//이름 변경      		
      
      try {
		connect();     
		  stmt = conn.createStatement();
		  //String sql="update names set name='동에번쩍' where name='홍길동'";	
		  String sql="update names set name='"+newName
				           +"' where name='"+oldName+"'";	
		  System.out.println("update SQL: "+ sql);
		  int t = stmt.executeUpdate(sql);//실행시점 (DB에 sql문 전달)
		  //t: 수정된 행의 갯수 리턴
		  if(t>0){//수정된 행이 존재 한다면
		     return true;
		  }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
	        disconnect();
		}    	
        return false;//수정이 안되었음을 호출한 곳에 전달!!
    }//update
    
    
    public boolean delete(String delName){//이름 삭제 
    	try {
			connect();
			stmt = conn.createStatement();
			String sql="delete from names where name='"+delName+"'";
			System.out.println("delete SQL: "+ sql);
			int t= stmt.executeUpdate(sql);//삭제시점(DB에 sql문 전달)
			//t:삭제된 행의 갯수
			if(t>0)//삭제된 행이 존재한다면!!
			  return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{    		
    	   disconnect();
		}
    	return false;
    }//delete
}





