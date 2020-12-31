<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.sql.Timestamp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.teacher_homework.model.*"%>
<%@ page import="com.student_homework.model.*"%>
<%@ page import="com.member_info.model.*"%> 
   
<%
	Student_homeworkService stService = new Student_homeworkService();
	Teacher_homeworkService trService = new Teacher_homeworkService();
	Member_infoService memService = new Member_infoService();

	String studenthw_id = request.getParameter("studenthw_id");
	Student_homeworkVO stVO = stService.select(studenthw_id);
	Timestamp hw_updatetime  = stVO.getHw_updatetime();
	
	String teacherhw_id = stVO.getTeacherhw_id();
	Teacher_homeworkVO trVO = trService.select(teacherhw_id);
	String member_id = stVO.getMember_id();
	Member_infoVO memVO = memService.getOneMember_info(member_id);

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/front-end/hw/common/work.jsp?studenthw_id=<%= request.getParameter("studenthw_id") %>">
		<div class="card  my-2" style="width: 20rem;">
	<!-- 	�U�ӭ����n��studenthw_id		 -->
			<img class="card-img-top" src="<%= request.getContextPath()%>/studenthwServlet?action=display_pic&studenthw_id=<%=request.getParameter("studenthw_id")%>" alt="�@�~��">
		    <div class="row-3 mt-1 mb-1 text-center border-bottom border-dark">
	<!--	�n������trVO��hw_name	 -->
				<h4><%= trVO.getHw_name() %></h4>
	<!-- 	studenthwVO��updatetime -->
		        <h5 class="card-text"><fmt:formatDate value="<%= stVO.getHw_updatetime() %>" pattern="yyyy-MM-dd HH:mm:ss"/></h5>
		    </div>
		    <div class="card-text d-flex align-items-center mb-1">
		        <div class="col col-3 pr-0">
	<!-- 	�Q��studenthwVO��member_infoid�A�A��member_infoid�L�� -->
		            <img class="rounded-circle img-fluid" src="<%= request.getContextPath()%>/member_info/Member_infoServlet?action=member_pic&member_id=<%= member_id %>" alt="�ǥ��Y��">
		        </div>
		        <div class="col col-9 p-0">
	<!-- 	�Q��studenthwVO��member_infoid�A�A��member_infoid��VO�A�A��VO��member_name -->
		            <p class=" text-center m-0"><%= memVO.getMember_name() %></p>
		        </div>
		    </div>
		</div>
	</a>
</body>
</html>