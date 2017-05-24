<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function contentChange() {
		var name = document.frm.name.value;
		var d1 = document.getElementById("d1");
		
		d1.innerHTML = '<font color=orange>' + name + ' 안녕';
	}
</script>
<body>
	<h3>입력폼</h3>
	<form name="frm">
		이름 : <input type="text" name="name"> <input type="button"
			value="전송" onclick="contentChange()">
	</form>

	<div id="d1"></div>
</body>
</html>