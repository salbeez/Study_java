<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니 결과 화면</title>
</head>
<body>
	<center>
		<%!private static final int apple = 100;//사과
	private static final int apple2 = 200;//딸기
	private static final int apple3 = 300;//복숭아
	private static final int apple4 = 400;//배
	private static final int apple5 = 500;//수박

	private int totmoney;%>
		<h2>선택된 상품 목록</h2>
		<%
			List result = (List) session.getAttribute("arrProduct");
			if (result != null) {
				for (int i = 0; i < result.size(); i++) {
					String product = (String) result.get(i);
					switch (product) {
						case "사과" :
							totmoney += apple;
							break;
						case "딸기" :
							totmoney += apple2;
							break;
						case "복숭아" :
							totmoney += apple3;
							break;
						case "수박" :
							totmoney += apple4;
							break;
						case "배" :
							totmoney += apple5;
							break;
						default :
							break;
					}
					out.print(product + "<br>");
				}
			} else {
				out.print("<b>상품을 전혀 선택하지 않았습니다</b>");
			}
		%>
		<hr>
		<%
			out.print("총 지불 금액 : " + totmoney);
		%>
		<hr>
			<input type="submit" value="전체 선택 취소" onclick="location.href='selProduct.jsp?act=remove'">
			<!-- <input type="submit" value="전체 선택 취소" onclick="location.href="clearProduct()"> -->
	</center>

	<script type="text/javascript">
		function clearProduct() {
			<%session.setAttribute("arrProduct", null);
			totmoney = 0;%>
		}
	</script>
</body>
</html>