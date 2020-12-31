<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>homework</title>
<style>
table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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
div{
	width: 200px;
	border: 1px solid black;
}
</style>
</head>
<body>
	<table id="table-1">
		<tr>
			<td colspan="3">
				<h3>homework: Home</h3>
				<h4>( here is studenthw )</h4>
			</td>
		</tr>
		<tr>
			<td><div><a href="../hw_test/studenthw.jsp">�@�~��</a></div></td>
			<td><div><a href="../teacherHw/hwQuestion.jsp">�@�~�D��</a></div></td>
		</tr>
	</table>

	<p>This is the Home page for homework: Home</p>

	<h3>��Ƭd��:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
<!-- 		�d�ߥ��� -->
	<ul>
		<li>
			<a href='listAllStHW.jsp'>List</a> all Homeworks.
			<br>
			<br>
		</li>
<!-- 		��J���@�~�s���d�� -->
		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/studenthwServlet">
				<b>��J�@�~�s�� (�pSH00001):</b>
				<input type="text" name="studenthw_id">
				<input	type="hidden" name="action" value="getOne_For_Display">
				<input	type="submit" value="�e�X">
			</FORM>
			<br>
		</li>
		
		<jsp:useBean id="stService" scope="page" class="com.student_homework.model.Student_homeworkService" />
			
<!-- 		�U�Ԧ��@�~�s���d�� -->
		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/studenthwServlet">
				<b>��ܧ@�~�s��:</b> 
				<select size="1" name="studenthw_id">
					<c:forEach var="studenthwVO" items="${stService.all}">
						<option value="${studenthwVO.studenthw_id}">${studenthwVO.studenthw_id}
					</c:forEach>
				</select> 
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
			<br>
		</li>
<!-- 		�U�Ԧ��ǥͽs���d�� -->
		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/studenthwServlet">
				<b>��ܾǥͽs��:</b>
				<select size="1" name="studenthw_id">
					<c:forEach var="studenthwVO" items="${stService.all}">
						<option value="${studenthwVO.studenthw_id}">${studenthwVO.member_id}
					</c:forEach>
				</select>
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
			<br>
		</li>
	</ul>

	<h3>�ӥh���@�~</h3>

	<ul>
		<li><a href='doHomework.jsp'>Add</a> a new studentHomework.</li>
	</ul>

	<!-- 	================================================================================================ -->
</body>
</html>