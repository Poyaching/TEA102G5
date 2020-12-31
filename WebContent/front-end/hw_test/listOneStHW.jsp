<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.student_homework.model.*"%>

<%
	//studenthwServlet.java(Concroller), �s�Jreq��student_homeworkVO����
	Student_homeworkVO sthwVO = (Student_homeworkVO)request.getAttribute("student_homeworkVO");
%>

<html>
<head>
<title>�@�~��� - listOneStHW.jsp</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
  img {
	width:auto;
	max-width:330px;
	height:200px;
  }
</style>

</head>
<body bgcolor='white'>
<table id="table-1">
	<tr><td>
		 <h3>�@�~��� - listOneStHW.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/hw_test/studenthw.jsp">�^����</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>�@�~�s��</th>
		<th>�@�~�s��</th>
		<th>�ǥͽs��</th>
		<th>�ɮ�</th>
		<th>�W�Ǯɶ�</th>
		<th>��s�ɶ�</th>
	</tr>
	<tr>
		<td><%= sthwVO.getStudenthw_id()%></td>
		<td><%= sthwVO.getTeacherhw_id()%></td>
		<td><%= sthwVO.getMember_id()%></td>
		<td><img alt="�Ϥ�" src="<%= request.getContextPath()%>/hw_test/studenthw.do?action=display_pic&studenthw_id=<%= sthwVO.getStudenthw_id()%>"></td>
		<td><fmt:formatDate value="<%= sthwVO.getHw_uploadtime()%>" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td><fmt:formatDate value="<%= sthwVO.getHw_updatetime()%>" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
</table>

</body>
</html>