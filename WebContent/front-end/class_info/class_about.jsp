<!-- 設定JSP編碼 -->
<%@page import="com.class_chapter.model.Class_chapterVO" %>
<%@page import="com.class_unit.model.Class_unitVO" %>
<%@page import="com.class_unit.model.Class_unitService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 設定標籤庫 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="com.class_info.model.*" %>
<%@ page import="com.class_chapter.*" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="Big5">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
    href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <!-- ¤º®e -->
        <div id="content">

            <div class="row">

                <!-- ¤§«á·|¥ÎJSP§ï¦¨ inclord-->
                <div class="col-10">

                    <div>
                        <div>Ãö©ó½Òµ{</div>
                        <div>
                            <div style="display: inline-block;">½Òµ{®Éªø</div>
                            <div style="display: inline-block;">½Òµ{Á`¤H¼Æ</div>
                            <br>
                            <div style="display: inline-block;">³æ¤¸¼Æ</div>
                            <div style="display: inline-block;">§@·~¼Æ</div>
                        </div>
                    </div>
                    <div>
                        <div>½Òµ{´y­z</div>
                        <div>
                            <div>
                                ½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z
                            </div>
                        </div>
                    </div>
                    <div>
                        <div>Ãö©ó¦Ñ®v</div>
                        <div>
                            <div>
                                ½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z½Òµ{´y­z
                            </div>
                        </div>
                    </div>
                    <div>
                        <div>½Òµ{¥Ø¿ý</div>
                        <div>
                            <ul>½Òµ{³¹¸`
                                <li> ½Òµ{³æ¤¸ </li>
                                <li> ½Òµ{³æ¤¸ </li>
                                <li> ½Òµ{³æ¤¸ </li>
                                <li> ½Òµ{³æ¤¸ </li>
                                <li> ½Òµ{³æ¤¸ </li>
                                <li> ½Òµ{³æ¤¸ </li>
                            </ul>
                        </div>
                    </div>                  
                </div>
            </div>
        </div>
        
			<!-- JavaScript -->
			<script	src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.5.1.min.js"></script>
			<script src="<%=request.getContextPath()%>/vendors/popper/popper.min.js"></script>
			<script	src="<%=request.getContextPath()%>/vendors/bootstrap/js/bootstrap.min.js"></script>
			<script src="<%=request.getContextPath()%>/vendors/video-js/js/video.js"></script>
</body>
</html>