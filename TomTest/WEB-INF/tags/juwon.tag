<%@tag import="com.kosta.t0512.Product"%>
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>

<%@ attribute name="a"%>
<%@ attribute name="b"%>
<%-- --%>
<h3>
	<jsp:doBody />
</h3>
<%
	Product product = new Product();
	String list[] = product.getList();
%>
<table border="${a }" cellpadding="${b }">
	<%
		for (int i = 0; i < list.length; i++) {
	%>
	<tr>
		<td><%=list[i]%></td>
	</tr>
	<%
		}
	%>

</table>