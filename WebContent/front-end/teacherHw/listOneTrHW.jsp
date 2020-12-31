<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.teacher_homework.model.*"%>

<%
	//teacherhwServlet.java(Concroller), �s�Jreq��teacher_homeworkVO����
	Teacher_homeworkVO teacher_homeworkVO = (Teacher_homeworkVO) request.getAttribute("teacher_homeworkVO");
%>

<html>
<head>
<title>�@�~��� - listOneTrHW.jsp</title>

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
	<tr><td>
		 <h3>�@�~��� - listOneTrHW.jsp</h3>
			 <h4>
			 	<a href="<%=request.getContextPath()%>/front-end/teacherHw/hwQuestion.jsp">�^����</a>
			 </h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�@�~�s��</th>
		<th>�椸�s��</th>
		<th>�@�~���D</th>
		<th>���e</th>
		<th>�ɮ�</th>
		<th>�W�Ǯɶ�</th>
		<th>��s�ɶ�</th>
	</tr>
	<tr>
		<td>${teacher_homeworkVO.teacherhw_id}</td>
		<td>${teacher_homeworkVO.unit_id}</td>
		<td>${teacher_homeworkVO.hw_name}</td>
		<td>${teacher_homeworkVO.hw_content}</td>
		<td><img alt="�Ϥ�" src="<%= request.getContextPath()%>/TeacherhwServlet?action=display_pic&teacherhw_id=${teacher_homeworkVO.teacherhw_id}"></td>
		<td><fmt:formatDate value="${teacher_homeworkVO.hw_uploadtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><fmt:formatDate value="${teacher_homeworkVO.hw_updatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
</table>

</body>
</html>