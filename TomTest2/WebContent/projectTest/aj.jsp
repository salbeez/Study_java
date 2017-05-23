<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	$(document).ready(function() {
		jQuery.ajax({
			type : "GET",
			url : "/test",
			//dataType : "JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
			success : function(data) {
				// 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
				// TODO
			},
			/*	complete : function(data) {
					// 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
					// TODO
					/*
					보통 complete을 쓸 지, success를 쓸 지는 상황에 따라 다르다.
					둘 중 하나만 써야함. 그냥 설명하기 위해 2개 쓴 것임.
					(반드시 둘 중 하나만 써야하는건 아니고, 둘다 쓰면 두 번 호출되기 때문에)
					
				},*/
			error : function(xhr, status, error) {
				alert("에러발생");
			}
		});
	});
</script>

<body>

</body>
</html>