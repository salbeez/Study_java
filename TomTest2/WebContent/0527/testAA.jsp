<?xml version="1.0" encoding="EUC-KR" ?>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>

<script>
$(document).ready(function(){
    $("input").click(function(){
    alert($(this).val());
        $.ajax({url: "demo_test.txt", success: function(result){
            alert("TESTAA.jsp");
        }});
    });
});
</script>
</head>
<body>

	<input type="button" id="alpha" value="alpha"> </input>
	<input type="button" id="beta" value="beta"> </input>
</body>
</html>