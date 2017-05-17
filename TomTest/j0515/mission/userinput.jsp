<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사용자등록</title> 
  <script type="text/javascript">
     function idCheck(){
    	window.open('confirmid.jsp','confirm','width=300,height=150');
     }
     function validCheck(){
      //빈값체크, 숫자체크, 문자열조합
        /* var id = document.frm.id.value;
        var pass = document.frm.pass.value; */
        
        var jumin1Exp = new RegExp("^[\\d]{6}$","g");
        var jumin2Exp = /^[\d]{7}$/g;        
        var yearExp = /^[\d]{4}$/g;        
        var zipExp = /^[\d]{3}-[\d]{3}$/g;        
        var emailExp = /^[a-zA-Z0-9]{6,15}@[a-zA-Z]+\.[a-zA-Z]+$/g;
        
        var f = document.frm;//f: <form>엘리먼트
        var id = f.id.value;
        
        if(id==''){
        	alert('아이디를 입력!!');
        	f.id.focus();
        }else if(id.length < 6 || id.length > 12){
           	alert('아이디는 6~12자리!!');
           	f.id.focus();
        }else if(f.pass.value == ''){//데이터내용 비교
        	alert('비번입력!!');
        	f.pass.focus();
        }else if(f.pass2.value === ''){//자료형 비교후 내용 비교
        	alert('비번입력!!');
        	f.pass2.focus();
        }else if(f.pass.value!=f.pass2.value){
            alert('비번이 일치하지 않습니다!!');
            f.pass.value=''; f.pass2.value='';
            f.pass.focus();
        }else if(f.name.value==''){
        	alert('이름입력!!');
        	f.name.focus();
        }else if(!jumin1Exp.test(f.jumin1.value) ||
        		 !jumin2Exp.test(f.jumin2.value)){
        	alert('잘못된 주민번호입니다!!');
        	f.jumin1.value='';
        	f.jumin2.value='';
        	f.jumin1.focus();
        }else if( !yearExp.test(f.year.value)){
        	alert('생년에 4자리 수를 입력!!');
        	f.year.value='';
        	f.year.focus();
        }else if(zipExp.test(f.zip1.value+"-"+f.zip2.value)){
        	alert('잘못된 우편번호입니다!!');
        	f.zip1.value='';
        	f.zip2.value='';
        	f.zip1.focus();
        }else if(!emailExp.test(f.email.value)){
        	alert('유효하지 않은 이메일형식입니다!!');
        	f.email.value='';
        	f.email.focus();
        }else if(f.job.value=='==선택=='){
        	alert('직업을 선택!!');
        	f.job.focus();
        }else{
        	//폼내에 유효한 데이터가 입력 되었다면
        	f.submit();//<form>태그내의 action속성의 URL로 폼데이터 전송!!
        }
        
     }//validCheck
  </script> 
</head>
<%-- userinput.jsp --%>
<body>
  <center>
  <form name="frm" action="userprocess.jsp" method="post">
  <table width="600" border="0" cellpadding="5" >
      <tr bgcolor="#3399cc">
         <td><font size="4" color="white">사용자정보입력</font>
      </tr>
      <tr>
         <td>안녕하세요. 이 페이지를 자유롭게 이용하려면
               먼저 회원가입을 하셔야 합니다.<br>
               아래의 사항들을 빠짐없이 기록해 주세요.
         </td>
      </tr>
  </table>
  <table border="1" cellpadding="5" width="600">
      <tr>
         <td width="100" bgcolor="#ffcccc">사용자ID<font color="red">*</font></td>
         <td colspan="3"><input type="text" name="id" 
                        onclick="idCheck()" readonly> 
         <input type="button" value="중복확인" onclick="idCheck()">
          <font color="blue">(6자리~12자리)</font>
         </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">비밀번호<font color="red">*</font></td>
         <td><input type="password" name="pass"> </td>
         <td width="100" bgcolor="#ffcccc">비번확인</td>
         <td><input type="password" name="pass2"> </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">사용자이름<font color="red">*</font></td>
         <td colspan="3"><input type="text" name="name"> </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">주민번호<font color="red">*</font></td>
         <td colspan="3">
              <input type="text" name="jumin1" size="6" maxlength="6"
                      style="height:23px" >
              -
              <input type="password" name="jumin2" size="7" maxlength="7"
                      style="height:23px" ></td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc" >생년월일</td>
         <td colspan="3">
         <input type="text" name="year" size="4" maxlength="4">년
         <select name="month">
          <%for(int i=1; i<13; i++){ 
               if(i<10){
            %> 
           <option value="0<%=i%>">0<%=i %></option>  
           <%}else{ %>              
           <option value="<%=i%>"><%=i %></option>                
          <%     }
           }%>
         </select>월          
         <select name="day" >
          <%for(int i=1; i<32; i++){ 
               if(i<10){
            %> 
           <option value="0<%=i%>">0<%=i %></option>  
           <%}else{ %>              
           <option value="<%=i%>"><%=i %></option>                
          <%     }
           }%>                            
         </select>일          
          </td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">우편번호<font color="red">*</font></td>
         <td colspan="3">
            <input type="text" name="zip1" size="3" maxlength="3"> 
            - 
            <input type="text" name="zip2" size="3" maxlength="3"></td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">주소</td>
         <td colspan="3"><input type="text" name="addr" size="50"></td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">E-Mail<font color="red">*</font></td>
         <td colspan="3"><input type="text" name="email" size="30"></td>
      </tr>
      <tr>
         <td width="100" bgcolor="#ffcccc">직업<font color="red">*</font></td>
         <td colspan="3">
                <% 
                String jobs[]={"==선택==","학생","공무원","언론/출판","군인/경찰","일반사무직",
        		   "영업직","기술/전문직","보건/의료","자영업","주부","기타" };        		
        		%>
               <select name="job" >
                <%for(int i=0; i<jobs.length; i++){ %>
                 <option value="<%=jobs[i]%>"><%= jobs[i] %></option>
                 <%} %>
               </select>
         </td>
      </tr>
      <tr align="center">
         <td colspan="4">
           <input type="button" value="등록" onclick="validCheck()">
           <input type="reset" value="취소">
         </td>
      </tr>
  </table>
  </form>
  </center>
</body>
</html>