
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="BIG5">
<title>select_pageClass_info</title>

</head>
<body>
	<ul>
	<%-- ���~��C --%>
	<c:if test="${not empty erMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${erMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
		<li>
			<h2>�o�OClass_info������</h2>
		</li>
		<li>
			<h4>��Ƭd��</h4>
		</li>
		<li>
			<h5>
				�C�X�Ҧ��ҵ{��T <a href="<%=request.getContextPath()%>/back-end/class_info/listAllClass_info.jsp">ListAll</a>
			</h5>
		</li>
		<li>
			<h5>
				�s�W�ҵ{��T <a href="<%=request.getContextPath()%>/back-end/class_info/addClass_info.jsp">�s�W�ҵ{��T</a>
			</h5>
		</li>
		<li>
			<h5>�d�߳浧���</h5>
			<form method="post" action="/TEA102G5/class_info/class_infoServlet">
				<p>��J�ҵ{�s��</p>
				<input type="text" name="class_id"> 
				<input type="hidden" name="action" value="SearchOne"> 
				<input type="submit" value="�e�X">
			</form>
		</li>
	</ul>

</body>
</html>