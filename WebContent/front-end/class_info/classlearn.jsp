<!-- 設定JSP編碼 -->
<%@page import="com.class_chapter.model.Class_chapterVO"%>
<%@page import="com.class_unit.model.Class_unitVO"%>
<%@page import="com.class_unit.model.Class_unitService"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 設定標籤庫 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.class_info.model.*"%>
<%@ page import="com.class_chapter.*"%>


<%
	Class_infoVO class_infoVO = (Class_infoVO) request.getAttribute("class_infoVO");
	Map<String, List<Class_chapterVO>> initClass = (Map<String, List<Class_chapterVO>>) application
			.getAttribute("initClass"); //取出ServletContext屬性
	List<Class_chapterVO> Class_chapterVO_list = initClass.get(class_infoVO.getClass_id());
	Map<String, List<Class_unitVO>> initChapter = (Map<String, List<Class_unitVO>>) application
			.getAttribute("initChapter"); //取出ServletContext屬性
	pageContext.setAttribute("Class_chapterVO_list", Class_chapterVO_list);
	pageContext.setAttribute("initChapter", initChapter);
%>


<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes">
	

<!-- video.js CSS -->
<link
	href="<%=request.getContextPath()%>/vendors/video-js/css/video-js.css"
	rel="stylesheet" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">
	
<!-- css -->
<link
	href="<%=request.getContextPath()%>/css/front-end/class-info/classlearn.css"
	rel="stylesheet" />	
	
<link
	href="<%=request.getContextPath()%>/css/header.css"
	rel="stylesheet" />		

<title>TOMATO - 讓你分分鐘鐘都在學習的網站</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<!-- container -->
	<!-- 標題 -->
	<div class="jumbotron jumbotron-fluid" style="padding-bottom: 0;">
		<div class="container">
			<h1>${class_infoVO.class_name}</h1>
			<p>說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明</p>
		</div>
		<div class="container-fluid sidebar" style="position: relative;">
			<div class="container">
				<div class="row">
					<!-- 影片 -->
					<div class="col-9 video embed-responsive ">
						<video id="my-video" class="video-js vjs-fluid " controls
							preload="auto" data-setup="{}">
							<source id="video_url"
								src="https://images.ctfassets.net/hrltx12pl8hq/4ACnMj4WVSOZRZt0jHu9h5/1506f652bcd70f4dc3e88219fefea858/shutterstock_739595833-min.jpg?fit=fill&w=800&h=300"
								" type="video/mp4" />
						</video>
					</div>
					<!-- 影片列表 -->
					<div class="col-3 video-list">
						<div>
							<h2 style="margin: 10px; text-align: center">影片列表</h2>
							<ul class="list-group" style="overflow: auto; height: 420px;">

								<!--課程章節 -->
								<div id="accordion">
									<!--章節迴圈     Start-->
									<c:forEach var="Class_chapterVO_list" items="${Class_chapterVO_list}" varStatus="loop">
										<div class="card" >
											<div class="card-header" id="heading_${loop.index}" >
												<h5 class="mb-0">
													<button class="btn btn-link collapsed"
														data-toggle="collapse"
														data-target="#collapse_${loop.index}"
														aria-expanded="false"
														aria-controls="collapse_${loop.index}" 
														data-chapterID = "${Class_chapterVO_list.chapter_id}">
														${Class_chapterVO_list.chapter_name}</button>
												</h5>
											</div>
											<!--單元迴圈 Start-->
											<c:forEach var="Class_unit" items="${initChapter[Class_chapterVO_list.chapter_id]}">
													<div
														id="collapse_${loop.index}"
														class="collapse"
														aria-labelledby="heading_${loop.index}"
														data-parent="#accordion">
														<div class="card-body" style="padding: 0%;">
															<ul class="list-group unit_list">
																<button type="button" class=" class-btn btn btn-secondary" data-unitID="${Class_unit.unit_id}">${Class_unit.unit_name}</button>
															</ul>
														</div>
													</div>
											</c:forEach>
											<!--單元迴圈END-->
										</div>
									</c:forEach>
									<!--章節迴圈     END-->
								</div>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<!-- 內容 -->
			<div id="content-class">
				<div class="row" style="margin: auto; justify-content: center;">
					<button type="button" class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">課程簡介</button>
					<button type="button" class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">學習發問</button>
					<button type="button" class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">作品欣賞</button>
					<button type="button" class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">隨堂測驗</button>
					<button type="button" class="class-btn btn btn-secondary col-2">課程評價</button>
				</div>
			</div>
		</div>


		<div class="container">
			<!-- 內容 -->
			<div id="content">

				<div class="row">

					<!-- 之後會用JSP改成 inclord-->
					<div class="col-10">內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊</div>
				</div>
			</div>
			<!--  聊天室-->
			<img id="talk"
				src="https://image.flaticon.com/icons/png/512/1952/1952178.png">



		</div>
		<!-- Footer -->
	<%@ include file="footer.jsp"%>



		<!-- JavaScript -->
		<script
			src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.5.1.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/vendors/popper/popper.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/vendors/bootstrap/js/bootstrap.min.js"></script>
		<script
			src="<%=request.getContextPath()%>/vendors/video-js/js/video.js"></script>
		<script>
		

			window.document.body.onload =function(){
				var url_video =$("div#accordion").find("button").attr("data-unitID");
				$("#video_url").closest("video").attr("src", "<%=request.getContextPath()%>/Class_unit/Class_unitServlet?unit_id=" + url_video + "&action=many_video");
				$("#video_url").attr("src", "<%=request.getContextPath()%>/Class_unit/Class_unitServlet?unit_id="+ url_video + "&action=many_video");
			}
			//按下列表按鈕時，轉換影片路徑
				$("div#accordion").on("click", "button.class-btn", function () {
					var url_video = $(this).attr("data-unitID");
					$("#video_url").closest("video").attr("src", "<%=request.getContextPath()%>/Class_unit/Class_unitServlet?unit_id=" + url_video + "&action=many_video");
					$("#video_url").attr("src", "<%=request.getContextPath()%>/Class_unit/Class_unitServlet?unit_id="+ url_video + "&action=many_video");
					});

			//離開時抓影片時間點
			window.document.body.onbeforeunload = function() {
				var myPlayer = videojs('my-video');
				var whereYouAt = myPlayer.currentTime();
				var unit_id = $("video").attr("src");
				var data_updata = {
					"action" : "getNewTime",
					"record_id" : "",
					"member_id" : "${member_infoVO.member_id}",
					"unit_id" : unit_id,
					"class_last" : whereYouAt
				};
				var that = $(this);
				$.ajax({
					url : "/TEA102G5/Video_record/Video_recordServlet", // 資料請求的網址
					type : "GET", // GET | POST | PUT | DELETE | PATCH
					data : data_updata, // 傳送資料到指定的 url
				});
			}
		</script>
</body>

</html>