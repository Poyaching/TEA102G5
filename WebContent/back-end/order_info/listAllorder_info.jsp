<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ page import="com.order_info.model.*" %>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
Order_infoService Order= new Order_infoService();
List<Order_infoVO> list=Order.getAll();
pageContext.setAttribute("list", list);
%>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<table>
<c:if test="${not empty error}">
	<font style="color:red">
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
		<tr>
			<th>訂單編號</th>
			<th>會員編號</th>
			<th>訂單時間</th>
			<th>付款方式匯款/信用卡</th>
			<th>訂單狀態</th>
			<th>優惠券編號</th>	
		</tr>
		<c:forEach var="order_info" items="${list}">
		<tr>
		<td>${order_info.order_ID}</td>
		<td>${order_info.member_id}</td>
		<td>${order_info.order_time}</td>
		<td>${order_info.payment_time}</td>
		<td>${order_info.pay_way}</td>
		<td>${order_info.order_status}</td>
		<td>${order_info.coupon_ID}</td>
		
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/order_info/Order_infoServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="order_ID"  value="${order_info.order_ID}">
			     <input type="hidden" name="action"	value="getOne_For_Update">
			  </FORM>
			</td>
		
		<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/order_info/Order_infoServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="order"  value="${order_info.order_ID}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
		
		</c:forEach>
	</table>
	<a href="<%=request.getContextPath()%>/back-end/order_info/select-page.jsp">回首頁</a>
	
</body>
</html>