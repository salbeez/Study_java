<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="MsgTag" uri="/WEB-INF/tld/jsp2-example-taglib.tld"%>
<%@ taglib prefix="you" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>커스텀 태그 테스트</h3>
	<hr>
	<MsgTag:gildong />

	<you:juwon a="1" b="100">상품 태그 </you:juwon>

</body>
</html>