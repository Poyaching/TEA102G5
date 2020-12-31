<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
				<h4>( here is hwQuestion )</h4>
			</td>
		</tr>
		<tr>
			<td><div><a href="../hw_test/studenthw.jsp">作品集</a></div></td>
			<td><div><a href="../teacherHw/hwQuestion.jsp">作業題目</a></div></td>
		</tr>
	</table>

	<p>This is the Home page for homework: Home</p>

	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<ul>
<!-- 		查詢全部 -->
		<li>
			<a href='listAllTrHW.jsp'>List all Homeworks</a>
			<br>
			<br>
		</li>
<!-- 		輸入式功課編號查詢 -->
		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/TeacherhwServlet">
				<b>輸入功課編號 (如TH00001):</b>
				<input type="text" name="teacherhw_id">
				<input	type="hidden" name="action" value="getOne_For_Display">
				<input	type="submit" value="送出">
			</FORM>
			<br>
		</li>
		
		<jsp:useBean id="trService" scope="page" class="com.teacher_homework.model.Teacher_homeworkService" />
			
<!-- 		下拉式功課編號查詢 -->
		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/TeacherhwServlet">
				<b>選擇功課編號:</b> 
				<select size="1" name="teacherhw_id">
					<c:forEach var="teacherhwVO" items="${trService.all}">
						<option value="${teacherhwVO.teacherhw_id}">${teacherhwVO.teacherhw_id}
					</c:forEach>
				</select> 
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
			<br>
		</li>
<!-- 		下拉式單元編號查詢 -->
		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/TeacherhwServlet">
				<b>選擇單元編號:</b>
				<select size="1" name="teacherhw_id">
					<c:forEach var="teacherhwVO" items="${trService.all}">
						<option value="${teacherhwVO.teacherhw_id}">${teacherhwVO.unit_id}
					</c:forEach>
				</select>
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
			<br>
		</li>
	</ul> 

	<h3>來去出作業囉</h3>

	<ul>
		<li><a href='makeHomework.jsp'>Add</a> a new teacherHomework.</li>
	</ul>

	<!-- 	================================================================================================ -->
</body>
</html>