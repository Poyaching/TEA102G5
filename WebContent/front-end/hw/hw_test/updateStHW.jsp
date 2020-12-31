<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.student_homework.model.*"%>

<%
	//Student_homeworkServlet.java (Concroller) �s�Jreq��StHWVO���� (�]�A�������X��StHWVO, �]�]�A��J��ƿ��~�ɪ�StHWVO����)
	Student_homeworkVO student_homeworkVO = (Student_homeworkVO) request.getAttribute("student_homeworkVO");
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�@�~��ƭק� - updateStHW.jsp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
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
		width: 500px;
		background-color: white;
		margin-top: 1px;
		margin-bottom: 1px;
	  }
	  table, th, td {
	    border: 0px solid #CCCCFF;
	  }
	  th, td {
	    padding: 1px;
	  }
	  img{
		width:auto;
		max-width:330px;
		height:200px;
	}
	</style>
</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>�@�~��ƭק� - updateStHW.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/hw_test/studenthw.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��ƭק�:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/studenthwServlet" name="form1" enctype="multipart/form-data">
		<table>
			<tr>
				<td>�@�~�s��:<font color=red><b>*</b></font></td>
				<td>${student_homeworkVO.studenthw_id}</td>
			</tr>
			
			<jsp:useBean id="teacher_homeworkService" scope="page" class="com.teacher_homework.model.Teacher_homeworkService" />
			<tr>
				<td>�@�~�s��:<font color=red><b>*</b></font></td>
				<td><select size="1" name="teacherhw_id">
					<c:forEach var="teacher_homeworkVO" items="${teacher_homeworkService.all}">
						<option value="${student_homeworkVO.teacherhw_id}"
						${(teacher_homeworkVO.teacherhw_id==student_homeworkVO.teacherhw_id)?'selected':'' }>
						${teacher_homeworkVO.teacherhw_id} ${teacher_homeworkVO.hw_name}
					</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>�ǥͽs��:</td>
				<td><input type="TEXT" name="member_id" size="45" value="${student_homeworkVO.member_id}" /></td>
			</tr>
			<tr>
				<td>�ɮ�:</td>
				<td>
					<input type="file" name="file_data" size="45" value="${student_homeworkVO.file_data}"/>
					<br>
					<img alt="�Ϥ�" src="<%= request.getContextPath()%>/studenthwServlet?action=display_pic&studenthw_id=${student_homeworkVO.studenthw_id}">
				</td>
			</tr>
			<tr>
				<td>�W�Ǯɶ�:</td>
				<td><input type="TEXT" name="hw_uploadtime" size="45" value="<%=df.format(new java.util.Date(student_homeworkVO.getHw_uploadtime().getTime())) %>"/></td>
			</tr>
			<tr>
				<td>�W����s�ɶ�:</td>
				<td><input type="TEXT" name="hw_updatetime" size="45" value="<%=df.format(new java.util.Date(student_homeworkVO.getHw_updatetime().getTime())) %>" readonly/></td>
			</tr>

		</table>
		<br>
		<input type="hidden" name="action" value="update">
		<input type="hidden" name="studenthw_id" value="${student_homeworkVO.studenthw_id}">
		<input type="submit" value="�e�X�ק�">
	</FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->


<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
//         $.datetimepicker.setLocale('zh');
//         $('#f_date1').datetimepicker({
//            theme: '',              //theme: 'dark',
//  	       timepicker:false,       //timepicker:true,
//  	       step: 1,                //step: 60 (�o�Otimepicker���w�]���j60����)
<%-- 	       format:'Y-m-d',         //format:'Y-m-d H:i:s', --%>
<%--  		   value: '<%=student_homeworkVO.getHw_uploadtime()%>',  --%>
//  		   value:   new Date(),
//            disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // �h���S�w���t
//            startDate:	            '2017/07/10',  // �_�l��
//            minDate:               '-1970-01-01', // �h������(���t)���e
//            maxDate:               '+1970-01-01'  // �h������(���t)����
//         });
        
        
   
        // ----------------------------------------------------------�H�U�ΨӱƩw�L�k��ܪ����-----------------------------------------------------------

        //      1.�H�U���Y�@�Ѥ��e������L�k���
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.�H�U���Y�@�Ѥ��᪺����L�k���
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.�H�U����Ӥ�����~������L�k��� (�]�i���ݭn������L���)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</html>