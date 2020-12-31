<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.student_homework.model.*"%>

<%
	Student_homeworkVO student_homeworkVO = (Student_homeworkVO) request.getAttribute("student_homeworkVO");
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<%=student_homeworkVO == null%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>作品資料新增 - doHomework.jsp</title>

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

table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>
	<table id="table-1">
		<tr>
			<td>
				<h3>作品資料新增 - doHomework.jsp</h3>
			</td>
		</tr>
		<tr>
			<td>
				<h4><a href="<%=request.getContextPath()%>/front-end/hw_test/studenthw.jsp">回首頁</a></h4>
			</td>		
		</tr>
	</table>

	<h3>資料新增:</h3>
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/studenthwServlet" name="form1" enctype="multipart/form-data">
		<table>
		<jsp:useBean id="teacher_homeworkService" scope="page" class="com.teacher_homework.model.Teacher_homeworkService" />
			<tr>
				<td>作業編號:</td>
				<td><select size="1" name="teacherhw_id">
					<c:forEach var="teacher_homeworkVO" items="${teacher_homeworkService.all}">
						<option value="${teacher_homeworkVO.teacherhw_id}">
						${(student_homeworkVO==null)?teacher_homeworkVO.teacherhw_id: student_homeworkVO.teacherhw_id}
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>學生編號:</td>
				<td><input type="TEXT" name="member_id" size="45" 
					 value="<%= (student_homeworkVO==null)? "MEM00001" : student_homeworkVO.getMember_id()%>" />
				</td>
			</tr>
			
			<tr>
				<td>檔案:</td>
				<td><input type="file" name="file_data" size="45"/></td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="送出新增">
	</FORM>
</body>
</html>