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
<!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes">
    <!-- video.js CSS -->
    <link href="<%=request.getContextPath()%>/vendors/video-js/css/video-js.css" rel="stylesheet" />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">
    <style>
        /* 套用全部 */
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
        /* 影片底圖 */
        .sidebar {
            background: linear-gradient(rgba(255, 255, 255, 0.466), rgba(255, 255, 255, 0.5)), url(https://www.twcode01.com/images/demo/demo2.jpg);
            border: 1px #ccc solid;
            padding: 10px;
            /*去掉固定高度，以內容撐高度*/
            /* font-size: 0; */
        }
        #talk {
            position: fixed;
            right: 20px;
            bottom: 30px;
            height: 60px;
        }
        /* 內部框 */
        #content {
            margin-top: 10px;
            margin-bottom: 50px;
            border: 1px rgb(204, 204, 204) solid;
        }
        #content-class {
            margin-top: 10px;
            margin-bottom: 20px;
            /* border: 1px rgb(204, 204, 204) solid; */
        }
        .video-js {
            position: relative;
            width: 100%;
            top: 1%;
        }
        /* 自訂按鈕- */
        .class-btn {
            background-color: rgba(255, 255, 255);
            color: black;
            border: 1px rgb(204, 204, 204) solid;
            padding: 15px;
            border-radius: .25rem;
            /*增加了圓框*/
        }
    </style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div style="border:1px solid black; padding: 2rem;">
		<%@ include file="page1.file"%>
		<c:forEach var="sthwVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			<jsp:include page="/front-end/hw/teacherHw/work_card.jsp" flush="true">
				<jsp:param name="studenthw_id" value="${sthwVO.studenthw_id}"/>
			</jsp:include>
		</c:forEach>
	</div>
	<%@ include file="page2.file"%>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>