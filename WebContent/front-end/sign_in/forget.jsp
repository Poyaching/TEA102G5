<!-- 設定JSP編碼 -->
<%@page import="com.class_chapter.model.Class_chapterVO"%>
<%@page import="com.class_unit.model.Class_unitVO"%>
<%@page import="com.class_unit.model.Class_unitService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 設定標籤庫 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.class_info.model.*"%>
<%@ page import="com.class_chapter.*"%>


<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes">
<!-- video.js CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/header.css">
<link
	href="<%=request.getContextPath()%>/vendors/video-js/css/video-js.css"
	rel="stylesheet" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">

<title>TOMATO - 讓你分分鐘鐘都在學習的網站</title>


<style type="text/css">
html, body {
	height: 100%;
}

.sign_in {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<link href="<%=request.getContextPath()%>/css/header.css"
	rel="stylesheet" />
</head>

<body>
	<%@ include file="header.jsp"%>
	<c:if test="${not empty errorMsgs}">
			<font style="color: red">請修正以下錯誤:</font>
			<ul>
				<c:forEach var="message" items="${errorMsgs}">
					<li style="color: red">${message}</li>
				</c:forEach>
			</ul>
		</c:if>
	<div class="container sign_in">
		<!-- 內容 -->
		<form class="form-signin" action="<%=request.getContextPath()%>/member_info/LoginHandler" method="post">

			<h1 class="h3 mb-3 font-weight-normal">登入帳號</h1>
			<br>
			<h6 class=" font-weight-normal">Email</h6>
			<input
				name="account" type="email" id="inputEmail" class="form-control"
				placeholder="輸入Email" required autofocus> 
			<br>
			<h6 class=" font-weight-normal">密碼</h6>
			<input
				name="password" type="password" id="inputPassword" class="form-control"
				placeholder="輸入密碼" required>
			<br>	
			<h6 class=" font-weight-normal">驗證碼</h6>
			<img
				src="<%=request.getContextPath()%>/front-end/sign_in/newimage.jsp" alt="New Image" />	 
			<input type="text" name="insrand" id="insrand" maxlength="4" class="form-control" /><br>
				
				
				
				
				
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					記住帳號
				</label>
			</div>
			<input type="hidden" name="action" value="login"/><br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>

		</form>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>