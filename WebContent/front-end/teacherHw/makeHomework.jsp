<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.teacher_homework.model.*"%>

<%
	Teacher_homeworkVO teacher_homeworkVO = (Teacher_homeworkVO) request.getAttribute("teacher_homeworkVO");
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<%=teacher_homeworkVO == null%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>作業資料新增 - makeHomework.jsp</title>

<style>
table#table-1 {
	width: 450px;
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
				<h3>作業資料新增 - makeHomework.jsp</h3>
			</td>
		</tr>
		<tr>
			<td>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/teacherHw/hwQuestion.jsp">回首頁</a>
				</h4>
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
	<FORM METHOD="post" ACTION="<%= request.getContextPath()%>/teacherHw/teacherhw.do" name="form1" enctype="multipart/form-data">
		<table>
		<jsp:useBean id="class_unitService" scope="page" class="com.class_unit.model.Class_unitService" />
			<tr>
				<td>單元編號:</td>
				<td><select size="1" name="unit_id">
					<c:forEach var="class_unitVO" items="${class_unitService.all}">
						<option value="${class_unitVO.unit_id}">
						${class_unitVO.unit_id} - ${class_unitVO.unit_name}
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>作業標題:</td>
				<td>
					<input type="TEXT" name="hw_name" size="45" placeholder="標題寫在這" value="<%= (teacher_homeworkVO==null)? "" : teacher_homeworkVO.getHw_name()%>"/>
				</td>
			</tr>
			
			<tr>
				<td>作業內容:</td>
				<td>
					<textarea name="hw_content" rows="10" cols="43" placeholder="內容寫在這"><%= (teacher_homeworkVO==null)? "" : teacher_homeworkVO.getHw_content()%></textarea>
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