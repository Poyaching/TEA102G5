<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.sql.Timestamp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.teacher_homework.model.*"%>
<%@ page import="com.student_homework.model.*"%>
<%@ page import="com.member_info.model.*"%> 

<% String locatoin = (String)session.getAttribute("location"); %>

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
            <a class="text-dark" href="${location}">學生作品</a>
            
        </h2>
    </div>
    <!-- 內容 -->
    <div class="container d-flex justify-content-center p-3">
        <div class="col-3">
            <img class="rounded-circle img-fluid img-thumbnail" src="\img\圖片\法鬥可愛圖.jpg" alt="">
        </div>
        <div class="col-6 py-2 px-4 border border-dark">
            <div>
                <div class="d-flex justify-content-between">
                    <span>標題(左)</span>
                    <span class="">發表日期</span>
                </div>
                <div>課程名稱/課程單元/作業題目</div>
                <div class="my-2">
                    <img class="container-fluid p-0" src="\img\圖片\bright_beach.jpg" alt="作品圖">
                </div>
                <div>
                    <p class="text-left mb-0 border-bottom border-muted">作品說明</p>
                    <p class="text-left">文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字</p>
                </div>
            </div>
            <div class="pb-2 mb-2">
                <div class="row mb-3">
                    <div class="col-3 d-flex justify-content-center">
                        <img class="head-img rounded-circle img-fluid" src="\img\圖片\法鬥卡通圖.png" alt="">
                    </div>
                    <div class="col p-0 mr-3">
                        <div class="d-flex justify-content-between mb-1">
                            <span>我是一隻法鬥</span>
                            <span class="mr-3">2020/01/11 12:20:03</span>
                        </div>
                        <div class="table-responsive" style="max-height: 100px;">
                            <span>文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字</span>
                        </div>
                    </div>
                </div>
                <div class="row w-75 mb-2 ml-auto mr-0">
                    <div class="col-3 d-flex justify-content-center">
                        <img class="head-img rounded-circle img-fluid" src="\img\圖片\法鬥卡通圖.png" alt="">
                    </div>
                    <div class="col p-0  mr-3">
                        <div class="d-flex justify-content-between mb-1">
                            <span>我是一隻法鬥</span>
                            <span>2020/01/11 12:20:03</span>
                        </div>
                        <div class="table-responsive" style="max-height: 100px;">
                            <span>文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字文字</span>
                        </div>
                    </div>
                </div>
                <div class="w-75 border boerder-muted ml-auto p-1">
                    <form class="p-1">
                        <textarea class="form-control px-2 py-0" name="子回覆" id="" cols="" rows="" placeholder="在此回覆"></textarea>
                        <div class="mt-2 d-flex justify-content-end">
                            <button>清除</button>
                            <button>發送</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="border boerder-muted p-2">
                <form class="p-2">
                    <textarea class="form-control p-2" name="子回覆" id="" cols="" rows="5" placeholder="在此回覆"></textarea>
                    <div class="mt-2 d-flex justify-content-end">
                        <button>清除</button>
                        <button>發送</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	
<!-- 	include chat -->
<!-- 	include footer -->
</body>
</html>