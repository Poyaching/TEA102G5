<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<title>�n�J���v:����</title>
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
</style>

</head>
<body bgcolor='white'>
	<table id="table-1">
		<tr>
			<td><h3>Login_History:Home</h3></td>
		</tr>
	</table>

	<p>�o�O�n�J���v����������</p>

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

	<ul>
		<li><a href='listAllLogin_history.jsp'>�C�X�����n�J���v����</a> <br>
		<br></li>


		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/login_history/login_historyServlet">
				<b>��J�n�J���v�����s�� (�pLOGIN00001):</b> <input type="text" name="login_id">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<jsp:useBean id="login_historySvc" scope="page"
			class="com.login_history.model.Login_historyService" />

		<li>
			<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/login_history/login_historyServlet">
				<b>��ܵn�J���v�����s��:</b> <select size="1" name="login_id">
					<c:forEach var="login_historyVO" items="${login_historySvc.all}">
						<option value="${login_historyVO.login_id}">${login_historyVO.login_id}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>


	</ul>


	<h3>�n�J���v�����޲z</h3>

	<ul>
		<li><a href='<%=request.getContextPath()%>/back-end/login_history/addLogin_history.jsp'>�s�W�n�J���v����</a></li>
	</ul>



</body>
</html>