<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li
 
a
:hover
:not
 
(
.active
 
){
background-color
:
 
#111
;


}
.active {
	background-color: #4CAF50;
}
</style>
</head>
<body>
		<ul>
			<li style="float: left"><a class="active" href="#about">Happy
					Cafe</a></li>
			<li><a href="#home">제품</a></li>
			<li><a href="../test?sub=a">매장 찾기</a></li>
			<li><a href="#contact">매장 관리</a></li>
			<li><a href="#contact">게시판</a></li>
		</ul>
</body>
</html>