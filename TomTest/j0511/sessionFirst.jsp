<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 테스트</h3>
	1. 세션 ID(String) :
	<%=session.getId()%><br> 2. 세션 유지시간(int) :
	<%=session.getMaxInactiveInterval()%>

	<script type="text/javascript">
		
		<%--<%=session.setMaxInactiveInterval(5)%>--%>
		if (
			<%=session.isNew()%>
		) {
			alert("세션이 종료 되었습니다 다시 설정합니다");
		}
	</script>
</body>
</html>

<!-- 
	세션은 서버에 저장
	최초 서버에 접속시 자동 생성 
		>>>예전에 count.jsp에서 isNew했을때 서버 실행후 바로 접속하면 true나오지만 
				다른 jsp 실행 후  count.jsp를 실행하면 이미 세션이 생성 되었기 때문에 false
 
 -->