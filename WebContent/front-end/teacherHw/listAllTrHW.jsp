<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.teacher_homework.model.*"%>

<%
	Teacher_homeworkService trhwService = new Teacher_homeworkService();
	List<Teacher_homeworkVO> list = trhwService.getAll();
	pageContext.setAttribute("list", list);
%>

<html>
<head>
<title>�Ҧ��@�~�D�ظ�� - listAllTrHW.jsp</title>
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
				<h3>�Ҧ��@�~�D�ظ�� - listAllTrHW.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/teacherHw/hwQuestion.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table>
		<tr>
			<th>�@�~�s��</th>
			<th>�椸�s��</th>
			<th>�@�~���D</th>
			<th>���e</th>
			<th>�ɮ�</th>
			<th>�W�Ǯɶ�</th>
			<th>��s�ɶ�</th>
			<th>�ק�</th>
			<th>�R��</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="trhwVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${trhwVO.teacherhw_id}</td>
				<td>${trhwVO.unit_id}</td>
				<td>${trhwVO.hw_name}</td>
				<td>${trhwVO.hw_content}</td>
				<td><img alt="�Ϥ�" src="<%= request.getContextPath()%>/TeacherhwServlet?action=display_pic&teacherhw_id=${trhwVO.teacherhw_id}"></td>
				<td><fmt:formatDate value="${trhwVO.hw_uploadtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${trhwVO.hw_updatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/teacherHw/teacherhw.do" style="margin-bottom: 0px;">
						<input type="submit" value="�ק�">
						<input type="hidden" name="teacherhw_id"  value="${trhwVO.teacherhw_id}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/teacherHw/teacherhw.do" style="margin-bottom: 0px;">
						<input type="submit" value="�R��">
						<input type="hidden" name="teacherhw_id" value="${trhwVO.teacherhw_id}">
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>