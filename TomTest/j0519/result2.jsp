<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>결과 페이지</title>
<%
	request.setCharacterEncoding("UTF-8");
%>
</head>
<body>
	<%
		String saveDir = application.getRealPath("/upload/");

		int maxSize = 5 * 1024 * 1024;//파일 크기 5mb로 제한
		//	MultipartRequest(req,저장 장소,제한용량,인코딩,중복된 이름있을때 새 네임으로 생성)
		MultipartRequest req = new MultipartRequest(request, saveDir, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		out.print("파일 업로드 성공");
		out.print("이름");
		out.print("원본 파일 명 : "+req.getOriginalFileName("myFile2"));
		out.print("저장된 파일 명 : " +req.getFilesystemName("myFile2"));
		
		
	%>
</body>
</html>