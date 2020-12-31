<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<%@ page import="com.order_list.model.*" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%	Order_listVO Order_listVO=(Order_listVO)request.getAttribute("Order_listVO");
%>


<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<body>
<table>
	<tr>
		<th>明細編號</th>
		<th>訂單編號</th>
		<th>課程編號</th>
		<th>購買方案</th>
	</tr>
	<tr>
		<td><%=Order_listVO.getOrder_list_id()%></td>
		<td><%=Order_listVO.getOrder_id()%></td>
		<td><%=Order_listVO.getClass_id()%></td>
		<td><%=Order_listVO.getPurchase_plan()%></td>
		
		
	
	</tr>
	
</table>
<a href="<%=request.getContextPath()%>/back-end/order_list/select-page.jsp">回上一步</a>
</body>
</html>