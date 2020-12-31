<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.teacher_homework.model.*"%>

<%
	//Teacher_homeworkServlet.java (Concroller) �s�Jreq��teacher_homeworkVO���� (�]�A�������X��teacher_homeworkVO, �]�]�A��J��ƿ��~�ɪ�teacher_homeworkVO����)
	Teacher_homeworkVO teacher_homeworkVO = (Teacher_homeworkVO) request.getAttribute("teacher_homeworkVO");
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�@�~��ƭק� - updateTrHW.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
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
		width: 500px;
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
	  img{
		width:auto;
		max-width:330px;
		height:200px;
	}
	</style>
</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�@�~��ƭק� - updateTrHW.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/teacherHw/hwQuestion.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/teacherHw/teacherhw.do" name="form1" enctype="multipart/form-data">
		<table>
			<tr>
				<td>�@�~�s��:<font color=red><b>*</b></font></td>
				<td>${teacher_homeworkVO.teacherhw_id}</td>
			</tr>

			<jsp:useBean id="class_unitService" scope="page" class="com.class_unit.model.Class_unitService" />
			<tr>
				<td>�椸�s��:</td>
				<td><select size="1" name="unit_id">
					<c:forEach var="class_unitVO" items="${class_unitService.all}">
						<option value="${teacher_homeworkVO.unit_id}"
						${(class_unitVO.unit_id==teacher_homeworkVO.unit_id)?'selected':'' }>
						${class_unitVO.unit_id} - ${class_unitVO.unit_name}
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>�@�~���D:</td>
				<td>
					<input type="TEXT" name="hw_name" size="45" placeholder="���D�g�b�o" value="${teacher_homeworkVO.hw_name}"/>
				</td>
			</tr>
			
			<tr>
				<td>�@�~���e:</td>
				<td>
					<textarea name="hw_content" rows="10" cols="43" placeholder="���e�g�b�o">${teacher_homeworkVO.hw_content}</textarea>
				</td>
			</tr>
			
			<tr>
				<td>�ɮ�:</td>
				<td>
					<%--�����ɮ׫O�d�^�ǤW���Ӥ�--%>
					<input type="file" name="file_data" size="45" value="${teacher_homeworkVO.file_data}"/>
					<br>
					<img alt="�Ϥ�" src="<%= request.getContextPath()%>/TeacherhwServlet?action=display_pic&studenthw_id=${student_homeworkVO.studenthw_id}">
				</td>
			</tr>
			<tr>
				<td>�W�Ǯɶ�:</td>
				<td><input type="TEXT" name="hw_uploadtime" size="45" value="<%=df.format(new java.util.Date(teacher_homeworkVO.getHw_uploadtime().getTime())) %>"/></td>
			</tr>
			<tr>
				<td>�W����s�ɶ�:</td>
				<td><input type="TEXT" name="hw_updatetime" size="45" value="<%=df.format(new java.util.Date(teacher_homeworkVO.getHw_updatetime().getTime())) %>" readonly/></td>
			</tr>

		</table>
		<br>
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="teacherhw_id" value="${teacher_homeworkVO.teacherhw_id}">
		<input type="submit" value="�e�X�ק�">
	</FORM>
</body>
</html>