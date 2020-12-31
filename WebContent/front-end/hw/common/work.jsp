<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.sql.Timestamp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.teacher_homework.model.*"%>
<%@ page import="com.student_homework.model.*"%>
<%@ page import="com.member_info.model.*"%> 

<% String locatoin = (String)request.getRequestURI(); %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- 	include header -->
	
	  <!-- title -->
    <div class="py-3 border-bottom border-muted">
        <h2 class="col col-2 mx-auto my-0 text-center text-muted">
            <a class="text-dark" href="${location}">�ǥͧ@�~</a>
            <p>${loacation}</p>
        </h2>
    </div>
    <!-- ���e -->
    <div class="container d-flex justify-content-center p-3">
        <div class="col-3">
            <img class="rounded-circle img-fluid img-thumbnail" src="\img\�Ϥ�\�k���i�R��.jpg" alt="">
        </div>
        <div class="col-6 py-2 px-4 border border-dark">
            <div>
                <div class="d-flex justify-content-between">
                    <span>���D(��)</span>
                    <span class="">�o����</span>
                </div>
                <div>�ҵ{�W��/�ҵ{�椸/�@�~�D��</div>
                <div class="my-2">
                    <img class="container-fluid p-0" src="\img\�Ϥ�\bright_beach.jpg" alt="�@�~��">
                </div>
                <div>
                    <p class="text-left mb-0 border-bottom border-muted">�@�~����</p>
                    <p class="text-left">��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r</p>
                </div>
            </div>
            <div class="pb-2 mb-2">
                <div class="row mb-3">
                    <div class="col-3 d-flex justify-content-center">
                        <img class="head-img rounded-circle img-fluid" src="\img\�Ϥ�\�k���d�q��.png" alt="">
                    </div>
                    <div class="col p-0 mr-3">
                        <div class="d-flex justify-content-between mb-1">
                            <span>�ڬO�@���k��</span>
                            <span class="mr-3">2020/01/11 12:20:03</span>
                        </div>
                        <div class="table-responsive" style="max-height: 100px;">
                            <span>��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r</span>
                        </div>
                    </div>
                </div>
                <div class="row w-75 mb-2 ml-auto mr-0">
                    <div class="col-3 d-flex justify-content-center">
                        <img class="head-img rounded-circle img-fluid" src="\img\�Ϥ�\�k���d�q��.png" alt="">
                    </div>
                    <div class="col p-0  mr-3">
                        <div class="d-flex justify-content-between mb-1">
                            <span>�ڬO�@���k��</span>
                            <span>2020/01/11 12:20:03</span>
                        </div>
                        <div class="table-responsive" style="max-height: 100px;">
                            <span>��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r��r</span>
                        </div>
                    </div>
                </div>
                <div class="w-75 border boerder-muted ml-auto p-1">
                    <form class="p-1">
                        <textarea class="form-control px-2 py-0" name="�l�^��" id="" cols="" rows="" placeholder="�b���^��"></textarea>
                        <div class="mt-2 d-flex justify-content-end">
                            <button>�M��</button>
                            <button>�o�e</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="border boerder-muted p-2">
                <form class="p-2">
                    <textarea class="form-control p-2" name="�l�^��" id="" cols="" rows="5" placeholder="�b���^��"></textarea>
                    <div class="mt-2 d-flex justify-content-end">
                        <button>�M��</button>
                        <button>�o�e</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	
<!-- 	include chat -->
<!-- 	include footer -->
</body>
</html>