<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
	<ul>
		<li><a href="main.do"> 첫화면</a> </li>
		<li><html:link action="/tiles/menu1"> 메뉴 1</html:link></li>
		<li><html:link action="/tiles/menu2"> 메뉴 2</html:link></li>
	</ul>
