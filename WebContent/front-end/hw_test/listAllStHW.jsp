<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.student_homework.model.*"%>


<%
	Student_homeworkService sthwService = new Student_homeworkService();
	List<Student_homeworkVO> list = sthwService.getAll();
	pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有學生作業資料 - listAllStHW.jsp</title>
<style>
table#table-1 {
	width: 800px;
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
table {
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	max-width:200px;
	padding: 5px;
	text-align: center;
}
img{
	max-width:200px;
	width:auto;
	height:200px;
}
</style>

</head>
<body bgcolor='white'>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有學生作業資料 - listAllStHW.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/hw_test/studenthw.jsp">回首頁	</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- 錯誤表列 --%>
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
			<th>作品編號</th>
			<th>作業編號</th>
			<th>學生編號</th>
			<th>檔案</th>
			<th>上傳時間</th>
			<th>更新時間</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="sthwVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${sthwVO.studenthw_id}</td>
				<td>${sthwVO.teacherhw_id}</td>
				<td>${sthwVO.member_id}</td>
				<td><img alt="圖片" src="<%= request.getContextPath()%>/hw_test/studenthw.do?action=display_pic&studenthw_id=${sthwVO.studenthw_id}"></td>
				<td><fmt:formatDate value="${sthwVO.hw_uploadtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${sthwVO.hw_updatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hw_test/studenthw.do" style="margin-bottom: 0px;">
						<input type="submit" value="修改">
						<input type="hidden" name="studenthw_id"  value="${sthwVO.studenthw_id}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/hw_test/studenthw.do" style="margin-bottom: 0px;">
						<input type="submit" value="刪除">
						<input type="hidden" name="studenthw_id" value="${sthwVO.studenthw_id}">
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>