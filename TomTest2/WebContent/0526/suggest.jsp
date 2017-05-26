<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- suggest.jsp(제시어 출력) --%>
<%!
    String keywords[]={"ajaxProgramming","apple","admin","apache","account","avengers",
    		"자바프로그래밍","자전거","자바스크립트","자바라","자연","자동차","자두"};

    public List<String> search(String keyword){
    	//keyword로 시작하는 데이터 목록 얻기
        List<String> list = new ArrayList<>();
    	
    	if(keyword==null || keyword.length()==0) return list;
    	
    	for(int i=0; i<keywords.length; i++){
    		//String str="자바";    str.startsWith("자") ----> true
    		if(keywords[i].startsWith(keyword)){//특정문자로 시작하는 단어를 찾았다면
    			list.add(keywords[i]);
    		}    		
    	}
      return list;   	
    }
%>

<%
    request.setCharacterEncoding("UTF-8");
    String keyword = request.getParameter("keyword");
    List<String> list = search(keyword);
    System.out.println("요청 keyword: "+ keyword);
    
    out.print(list.size()+"|");
    for(int i=0; i<list.size(); i++){
    	out.print(list.get(i));
    	if(i<list.size()-1)out.print(",");
    }
%>






