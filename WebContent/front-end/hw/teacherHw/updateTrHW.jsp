<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.teacher_homework.model.*"%>

<%
	//Teacher_homeworkServlet.java (Concroller) 存入req的teacher_homeworkVO物件 (包括幫忙取出的teacher_homeworkVO, 也包括輸入資料錯誤時的teacher_homeworkVO物件)
	Teacher_homeworkVO teacher_homeworkVO = (Teacher_homeworkVO) request.getAttribute("teacher_homeworkVO");
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>作業資料修改 - updateTrHW.jsp</title>
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
				<h3>作業資料修改 - updateTrHW.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/hw/teacherHw/hwQuestion.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/TeacherhwServlet" name="form1" enctype="multipart/form-data">
		<table>
			<tr>
				<td>作業編號:<font color=red><b>*</b></font></td>
				<td>${teacher_homeworkVO.teacherhw_id}</td>
			</tr>

			<jsp:useBean id="class_unitService" scope="page" class="com.class_unit.model.Class_unitService" />
			<tr>
				<td>單元編號:</td>
				<td><select size="1" name="unit_id">
					<c:forEach var="class_unitVO" items="${class_unitService.all}">
						<option value="${teacher_homeworkVO.unit_id}"
						${(class_unitVO.unit_id==teacher_homeworkVO.unit_id)?'selected':'' }>
						${class_unitVO.unit_id} - ${class_unitVO.unit_name}
					</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>作業標題:</td>
				<td>
					<input type="TEXT" name="hw_name" size="45" placeholder="標題寫在這" value="${teacher_homeworkVO.hw_name}"/>
				</td>
			</tr>
			
			<tr>
				<td>作業內容:</td>
				<td>
					<textarea name="hw_content" rows="10" cols="43" placeholder="內容寫在這">${teacher_homeworkVO.hw_content}</textarea>
				</td>
			</tr>
			
			<tr>
				<td>檔案:</td>
				<td>
					<%--不選檔案保留回傳上次照片--%>
					<input type="file" name="file_data" size="45" value="${teacher_homeworkVO.file_data}"/>
					<br>
					<img alt="圖片" src="<%= request.getContextPath()%>/TeacherhwServlet?action=display_pic&studenthw_id=${student_homeworkVO.studenthw_id}">
				</td>
			</tr>
			<tr>
				<td>上傳時間:</td>
				<td><input type="TEXT" name="hw_uploadtime" size="45" value="<%=df.format(new java.util.Date(teacher_homeworkVO.getHw_uploadtime().getTime())) %>"/></td>
			</tr>
			<tr>
				<td>上次更新時間:</td>
				<td><input type="TEXT" name="hw_updatetime" size="45" value="<%=df.format(new java.util.Date(teacher_homeworkVO.getHw_updatetime().getTime())) %>" readonly/></td>
			</tr>

		</table>
		<br>
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="teacherhw_id" value="${teacher_homeworkVO.teacherhw_id}">
		<input type="submit" value="送出修改">
	</FORM>
</body>
</html>