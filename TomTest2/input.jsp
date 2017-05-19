<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		<b>인풋 폼</b>
	</h3>
	<h3>파일 업로드 >>>결과는>>>result.jsp</h3>
	<form action="result.jsp" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name"> <br> 파일 : <input
			type="file" name="myFile"> <br> <input type="submit">
	</form>

	<h3>
		<b>COS.multipart Req 사용 인풋 폼</b>
	</h3>
	<form action="result2.jsp" method="post" enctype="multipart/form-data">
		이름 : <input type="text" name="name2"> <br> 파일 : <input
			type="file" name="myFile2"> <br> <input type="submit">
	</form>
</body>
</html>