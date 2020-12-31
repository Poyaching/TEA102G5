<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.login_history.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    Login_historyService login_historySvc = new Login_historyService();
    List<Login_historyVO> list = login_historySvc.getAll();
    pageContext.setAttribute("list",list);
%>
<!DOCTYPE html>


<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">
<title>Document</title>
<style>
.styled-table {
	border-collapse: collapse;
	margin: 25px 0;
	font-size: 0.9em;
	font-family: sans-serif;
	min-width: 400px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
	background-color: #009879;
	color: #ffffff;
	text-align: left;
}

.styled-table th, .styled-table td {
	padding: 12px 15px;
}

.styled-table tbody tr {
	border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
	background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
	border-bottom: 2px solid #009879;
}

.styled-table tbody tr.active-row {
	font-weight: bold;
	color: #009879;
}

* {
	box-sizing: border-box;
}

/* header  */
header {
	width: 100%;
	box-shadow: 0px 1px 10px rgb(202, 202, 197);
	z-index: 9999;
	position: sticky;
	top: 0;
}

#talk {
	position: fixed;
	right: 20px;
	bottom: 30px;
	height: 60px;
}

/* ������ */
#content {
	margin-top: 10px;
	margin-bottom: 50px;
	border: 1px rgb(204, 204, 204) solid;
	padding: 20px 10px;
}

input[disabled] {
	background-color: #eee;
	cursor: not-allowed;
}

label {
	margin-top: 10px;
}

.form-check-label {
	margin-top: 0;
	padding-left: 0;
}

#submit-btn {
	margin-top: 20px;
}

li {
	list-style: none;
}
</style>
</head>

<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="#">TOMATO</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">����
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">�ڪ��ҵ{</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> �ҵ{��� </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="#">�y��</a> <a class="dropdown-item"
								href="#">��v</a> <a class="dropdown-item" href="#">�]�p</a> <a
								class="dropdown-item" href="#">�H��</a> <a class="dropdown-item"
								href="#">��P</a> <a class="dropdown-item" href="#">�{��</a>
						</div></li>
					<li>
						<form class="form-inline my-2 my-lg-0" style="position: left">
							<input class="form-control mr-sm-2 form-control" type="search"
								placeholder="��J�A�Q�n���ҵ{" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0"
								type="submit">Search</button>
						</form>
					</li>
				</ul>
				<!-- �|���U�Կ�� -->
				<div class="dropdown">
					<img data-toggle="dropdown"
						src="https://pic.90sjimg.com/design/00/08/16/10/591fa3911d5ee.png"
						alt="XX" style="height: 30px; margin-right: 20px;">
					<div class="dropdown-menu">
						<a class="dropdown-item" href="#">�b���]�w</a> <a
							class="dropdown-item" href="#">�ӤH�ɮ�</a> <a class="dropdown-item"
							href="#">�q�����</a> <a class="dropdown-item" href="#">�ڪ��u�f</a> <a
							class="dropdown-item" href="#">�n�X</a>
					</div>
				</div>


				<img
					src="https://i-1.lanrentuku.com/2020/11/9/7d9cf2fd-ed76-466a-9012-51b017c46025.png"
					alt="XX" style="height: 30px; margin-right: 20px;"> <img
					src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-bell-512.png"
					alt="XX" style="height: 30px; margin-right: 20px;">

			</div>
		</nav>
	</header>

	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1>�Ҧ��n�J���v�������</h1>
				<h4>
					<a
						href="<%=request.getContextPath()%>/back-end/login_history/select_page.jsp">�d�ߵn�J���v����</a>
				</h4>
			</div>
		</div>

		<c:if test="${not empty errorMsgs}">
			<font style="color: red">�Эץ��H�U���~:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>


		<table class="styled-table">
			<thead>
				<tr>
					<th>�n�J���v�����s��</th>
					<th>�n�J�ɶ�</th>
					<th>�n�J�˸m</th>
					<th>�n�JIP</th>
					<th>�|���W��</th>

					<th></th>
					<th></th>
				</tr>
			</thead>
			<%@ include file="page1.file"%>
			<c:forEach var="login_historyVO" items="${list}" begin="<%=pageIndex%>"
				end="<%=pageIndex+rowsPerPage-1%>">
				<tbody>
					<tr>
						<td>${login_historyVO.login_id}</td>
						<td><fmt:formatDate value="${login_historyVO.login_time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>			
						<td>${login_historyVO.login_arrange}</td>
						<td>${login_historyVO.login_ip}</td>
						<td>${login_historyVO.member_id}</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/login_history/Login_historyServlet"
								style="margin-bottom: 0px;">
								<input type="submit" value="�ק�"> <input type="hidden"
									name="login_id" value="${login_historyVO.login_id}"> <input type="hidden"
									name="action" value="getOne_For_Update">
							</FORM>
						</td>
						<td>
							<FORM METHOD="post"
								ACTION="<%=request.getContextPath()%>/login_history/Login_historyServlet"
								style="margin-bottom: 0px;">
								<input type="submit" value="�R��"> 
								<input type="hidden" name="login_id" value="${login_historyVO.login_id}"> 
								<input type="hidden" name="action" value="delete">
							</FORM>
						</td>
					</tr>


				</tbody>
			</c:forEach>
		</table>
		<%@ include file="page2.file"%>

	</div>





	<script src="./vendors/jquery/jquery-3.5.1.min.js"></script>
	<script src="./vendors/popper/popper.min.js"></script>
	<script src="./vendors/bootstrap/js/bootstrap.min.js"></script>


</body>

</html>

		

