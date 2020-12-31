<!-- 設定JSP編碼 -->
<%@page import="com.video_record.model.Video_recordVO"%>
<%@page import="com.video_record.model.Video_recordService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 設定標籤庫 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="tw">
<head>
  <meta http-equiv="Content-Language" content="zh-tw" />
  <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui" />

  <title>後台管理系統</title>

  <link href="<%=request.getContextPath()%>/css/back-end/icon.css" rel="stylesheet" type="text/css" />
  <link href="<%=request.getContextPath()%>/css/back-end/public.css" rel="stylesheet" type="text/css" />
  <script src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.5.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/back-end/public.js" language="javascript" type="text/javascript" ></script>

</head>
<body lang="zh-tw">
  <input type='checkbox' id='menu_ckb' >
  <input type='checkbox' id='info_ckb' >

  <header class="row sh-lg" id='header'>

    <form class="left pdvt-12 pdlt-20">
      <div class='logo'>Tomato後台管理系統</div>
      <!-- <div class='title'>歡迎光臨</div> -->
    </form>
    <img style="height: 40px ; margin: 10px"src='<%=request.getContextPath()%>/img/icon/1024px-Home_free_icon.svg.png'>

        <nav class="right">
          <ul class="left sk-1st mgvt-12 mghr-20">
            <li class="left mglt-20 left70">
              <a href="<%=request.getContextPath()%>/index.jsp">檢視網頁</a>
            </li>
            <li class="left mglt-20 left80">
              <a href="<%=request.getContextPath()%>/back-end/back-login.jsp">登入&nbsp;|&nbsp;登出</a>
            </ul>
          </nav>
      <label class='avatar left90' for='info_ckb'>
        <img src='<%=request.getContextPath()%>/img/avatar.png'>
      </label>
    </header>

    <div id='menu'>
      <a  style="margin-left: 20px"><span>審核課程</span></a>
      <div class='sub'>
        <a class='icon-home'><span>教案審核</span></a>
        <a class='icon-home'><span>影片審核</span></a>
      </div>

      <a  style="margin-left: 20px"><span>訊息管理</span></a>
      <div class='sub'>
        <a class='icon-home'><span>公告管理</span></a>
        <a class='icon-home'><span>聊天室</span></a>
      </div>

      <a  style="margin-left: 20px"><span>首頁內容</span></a>
      <div class='sub'>
        <a class='icon-home'><span>廣告與關鍵字</span></a>
      </div>
      <a  style="margin-left: 20px"><span>課程管理</span></a>
      <div class='sub'>
        <a class='icon-home'><span>課程列表</span></a>
      </div>
      <a  style="margin-left: 20px"><span>會員資料</span></a>
      <div class='sub'>
        <a class='icon-home'><span>會員列表</span></a>
      </div>
      <a  style="margin-left: 20px"><span>費用管理</span></a>
      <div class='sub'>
        <a class='icon-home'><span>優惠券</span></a>
        <a class='icon-home'><span>講師費用</span></a>
      </div>
      <a  style="margin-left: 20px"><span>數據管理</span></a>
      <div class='sub'>
        <a class='icon-home'><span>銷售分析</span></a>
        <a class='icon-home'><span>關鍵字分析</span></a>
      </div>
      <a  style="margin-left: 20px"><span>權限管理</span></a>
      <div class='sub'>
        <a class='icon-home'><span>管理員列表</span></a>
      </div>
    </div>

    <div id='info'>

    </div>
    <label class='cover' for='info_ckb'></label>

  </body>
  </html>
