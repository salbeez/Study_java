<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
제품 정보 음료{
아이템 고유 번호 id
이름 name
가격 price
카테고리 넘버 (1=빵 2=음료) tagid
}

카테고리 테이블 PRODUCTTAG( tagid tagname)
										id=1 -> 빵
										id=2 -> 음료
 --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
img {
	border: 3px solid red;
	width: 100px;
	height: 100px;
	float: left;
}
</style>
<body>
	<h1>cyder</h1>
	<img alt="제품 사진" src="../img/cyder.jpg"> 
	아이템 고유 번호 id<br> 
	이름 name<br>
	가격 price <br>
</body>
</html>