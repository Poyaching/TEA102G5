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
<title>�@�~��Ʒs�W - makeHomework.jsp</title>

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
				<h3>�@�~��Ʒs�W - makeHomework.jsp</h3>
			</td>
		</tr>
		<tr>
			<td>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/teacherHw/hwQuestion.jsp">�^����</a>
				</h4>
			</td>		
		</tr>
	</table>

	<h3>��Ʒs�W:</h3>
	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
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
				<td>�椸�s��:</td>
				<td><select size="1" name="unit_id">
					<c:forEach var="class_unitVO" items="${class_unitService.all}">
						<option value="${class_unitVO.unit_id}">
						${class_unitVO.unit_id} - ${class_unitVO.unit_name}
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>�@�~���D:</td>
				<td>
					<input type="TEXT" name="hw_name" size="45" placeholder="���D�g�b�o" value="<%= (teacher_homeworkVO==null)? "" : teacher_homeworkVO.getHw_name()%>"/>
				</td>
			</tr>
			
			<tr>
				<td>�@�~���e:</td>
				<td>
					<textarea name="hw_content" rows="10" cols="43" placeholder="���e�g�b�o"><%= (teacher_homeworkVO==null)? "" : teacher_homeworkVO.getHw_content()%></textarea>
				</td>
			</tr>
			
			<tr>
				<td>�ɮ�:</td>
				<td><input type="file" name="file_data" size="45"/></td>
			</tr>
		</table>
		<br>
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="�e�X�s�W">
	</FORM>
</body>
</html>