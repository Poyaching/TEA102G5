<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.teacher_homework.model.*"%>
<%@ page import="com.student_homework.model.*"%>


<%
	Student_homeworkService sthwService = new Student_homeworkService();
	Student_homeworkVO student_homeworkVO = sthwService.select("SH00002");
	List<Student_homeworkVO> list = sthwService.getAll();
	pageContext.setAttribute("list", list);
	request.setAttribute("student_homeworkVO", student_homeworkVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
<style>
	.card {
	width: 20rem;
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: .25rem;
	}
	
	.img {
    vertical-align: middle;
    border-style: none;
	}
	
	.card-img, .card-img-bottom, .card-img-top {
    -ms-flex-negative: 0;
    flex-shrink: 0;
    width: 100%;
	}
	
	.d-flex {
    display: -ms-flexbox!important;
    display: flex!important;
	}
	
	.align-items-center {
    -ms-flex-align: center!important;
    align-items: center!important;
	}
	
	.border-bottom {
    border-bottom: 1px solid #dee2e6!important;
	}
	
	.border-dark {
    border-color: #343a40!important;
	}
</style>
</head>
<body>
	<div style="border:1px solid black; padding: 2rem;">
		<%@ include file="page1.file"%>
		<c:forEach var="sthwVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<jsp:include page="/front-end/teacherHw/work_card.jsp" flush="true">
				<jsp:param name="studenthw_id" value="${sthwVO.studenthw_id}"/>
			</jsp:include>
		</c:forEach>
	</div>
	<%@ include file="page2.file"%>
</body>
</html>