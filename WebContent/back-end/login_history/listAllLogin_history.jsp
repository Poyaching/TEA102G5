<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.login_history.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    Login_historyService login_historySvc = new Login_historyService();
    List<Login_historyVO> list = login_historySvc.getAll();
    pageContext.setAttribute("list",list);
%>
<html>
<head>
<title>所有登入歷史紀錄</title>
<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>

img{
	height: 50px;
}
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有登入歷史紀錄資料</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/back-end/login_history/select_page.jsp"><img src="<%=request.getContextPath()%>/back-end/login_history/images/tomato.gif"
						width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<table>
		<tr>
			<th>登入歷史紀錄編號</th>
			<th>登入時間</th>
			<th>登入裝置</th>
			<th>登入IP</th>
			<th>會員名稱</th>

		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="login_historyVO" items="${list}"
			begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${login_historyVO.login_id}</td>
				<td><fmt:formatDate value="${login_historyVO.login_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>			
				<td>${login_historyVO.login_arrange}</td>
				<td>${login_historyVO.login_ip}</td>
				<td>${login_historyVO.member_id}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/login_history/login_historyServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="login_id" value="${login_historyVO.login_id}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/login_history/login_historyServlet"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="login_id" value="${login_historyVO.login_id}"> 
							<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>
</body>
</html>