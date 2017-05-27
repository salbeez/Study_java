<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
ul#menu li {
	background-color: black;
	color: white;
	padding: 5px 10px;
	text-decoration: none;
	border-radius: 4px;
	margin-bottom: 5px;
	width: 100px;
}

ul#menu li:hover {
	background-color: orange;
}

table {
	border: 1px solid black;
}

table#div_getData td {
	width: 100px;
	padding: 10px;
	border: 1px solid black;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
		$(function(){
////////////////hover기능을 처리하는 함수
<%--
1. 리스트에 마우스를 댔을때 부서번호를 val()함수를 통해 불러온다
2. ajax를 통해 데이터를 요청한다 . 데이터를 요청할 시에
    depNo를 보내주어 이 부서번호에관한 정보를 json형식으로 달라고 요청
    요청 url은 Testcont로 Servlet에서 요청 url을 받는다.
3. 데이터 요청에 성공할시 테이블에 뿌려주도록 구현 
--%>
			$('#menu li').hover(function() {
				var getDeptNo="";
				var htmlText="";
				getDeptNo = $(this).text();
				alert(getDeptNo);
				$(this).append($("<span> ***</span>"));
				
				$.ajax({
					type : "post",
					url : "../abcd",
					data : { deptNo: getDeptNo},
					dataType : "json",

					success : function(data) {
 						for(var i =0;i<data.length;i++){
 							htmlText +="<tr>"
							+"<td>"+ data[i].empNo +"</td>"
							+"<td>"+ data[i].empName +"</td>"
							+"<td>"+ data[i].empHiredate +"</td>"
							+"</tr>"
						}
						$('table > tbody').html(htmlText);  
					},
					complete : function(data) {
						console.log(data[0]);
					},
					error : function(xhr, status, error) {
						console.log("에러!: " + error);
						console.log("상탱"+status);
					},
				});
			}, function() {
				$(this).find("span:last").remove();
			});
		});
	</script>
</head>

<%--////////부서번호를 검색하기위해 마우스를 댔을 때 관련 데이터를 불러오도록구현//////// --%>
<body>
	<div>
		<h2>사원정보를 검색하세요!</h2>
		<ul id="menu" style="list-style-type: square">
			<li>1000</li>
			<li>2000</li>
			<li>3000</li>
			<li>4000</li>
		</ul>
	</div>

	<table id="div_getData">
		<thead>
			<tr>
				<td>사번</td>
				<td>이름</td>
				<td>입사일</td>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>

	<div id="asd"></div>
</body>
</html>