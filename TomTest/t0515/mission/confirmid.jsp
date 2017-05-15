<%@page import="com.kosta.t0515.mission.UserInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script type="text/javascript">
      function confirmid(useid){
    	  alert('사용가능한 아이디입니다!!');
    	  if(confirm('사용하시겠습니까?')){
    		  opener.document.frm.id.value=useid;
    		  window.close();
    	  }
      }
  </script>
</head>
<%-- confirmid.jsp --%>
<body>
  <center>
     
     <h4>아이디 확인</h4>
     <form method="post">
           아이디: <input type="text" name="id"> 
           <input type="submit" value="확인">
     </form><br>
     <a href="javascript:self.close()">창닫기</a>
     <%
        if(request.getMethod().equals("POST")){
        	String id = request.getParameter("id");
        	//아이디에 대한 중복검사
        	UserInfoDAO dao = new UserInfoDAO();
        	if(dao.duplicateId(id)){//중복아이디 발견!!
        		out.print("<script>alert('이미 사용중인 아이디입니다!!')</script>");
        	}else{
        	    out.print("<script>confirmid('"+id+"');</script>");	
        	}
        }
     
     %>     
      
          <!-- <table width="280" border="0" cellpadding="5">
               <tr bgcolor="#3399cc">
                 <td><b>사용불가능</b></td>
               </tr>
               <tr>
                 <td>
                    이미 사용중인 아이디입니다.<br>
                    다른 아이디를 선택하십시요!!
                 </td>
               </tr>
            </table> 
                 <input type="button" value="닫기" onclick="window.close()">       
            <table width="280" border="0" cellpadding="5">
               <tr bgcolor="#3399cc">
                 <td><b>사용가능</b></td>
               </tr>
               <tr>
                 <td>
                     사용가능한 아이디입니다^^*
                 </td>
               </tr>
            </table> 
                <a href="javascript:self.close()">창닫기</a>   -->       
   </center>
</body>
</html>
