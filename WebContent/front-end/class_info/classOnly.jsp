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


<% Class_infoVO class_infoVO=(Class_infoVO)
request.getAttribute("class_infoVO");
System.out.print(class_infoVO.getClass_id()); Map<String,
List<Class_chapterVO>> initClass = (Map<String, List<Class_chapterVO>>)
application.getAttribute("initClass"); //取出ServletContext屬性
List<Class_chapterVO> Class_chapterVO_list =
initClass.get(class_infoVO.getClass_id());
Map<String, List<Class_unitVO>> initChapter = (Map<String,
List<Class_unitVO>>)
application.getAttribute("initChapter");
//取出ServletContext屬性
pageContext.setAttribute("Class_chapterVO_list",
Class_chapterVO_list);
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
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/css/header.css">
	<link
		href="<%=request.getContextPath()%>/vendors/video-js/css/video-js.css"
		rel="stylesheet" />
	<!-- Bootstrap CSS -->
	<link rel="stylesheet"
		href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">


	<!-- css -->
	<link
		href="<%=request.getContextPath()%>/css/front-end/class-info/classOnly.css"
		rel="stylesheet" />

	<link
		href="<%=request.getContextPath()%>/css/header.css"
		rel="stylesheet" />
	<title>TOMATO - 讓你分分鐘鐘都在學習的網站</title>
</head>

<body>
	<%@ include file="header.jsp" %>
		<!-- container -->
		<!-- 標題 -->
		<div class="jumbotron jumbotron-fluid"
			style="padding-bottom: 0;">
			<div class="container">
				<h1>${class_infoVO.class_name}</h1>
				<p>說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明</p>
			</div>
			<div class="container-fluid sidebar"
				style="position: relative;">
				<div class="container">
					<div class="row">
						<!-- 影片底圖 -->
						<div
							class="col-9 video embed-responsive embed-responsive-16by9">
							<video id="my-video"
								class="video-js embed-responsive-item"
								controls preload="auto"
								poster="MY_VIDEO_POSTER.jpg"
								data-setup="{}">
								<source
									src="<%=request.getContextPath()%>/class_info/Class_infoImgAndVideo?action=class_video&class_id=${class_infoVO.class_id}"
									type="video/mp4" />
							</video>
						</div>
						<div class="col-3 video-list">
							<div class="alert bg-danger shadow text-white"
								role="alert"
								style="margin: 10px;">
								募資倒數中
							</div>
							<div
								style=" height:420px; border: 1px rgb(204, 204, 204,50) solid; position:relative;">

								<div
									style="margin: 20px; text-align:center; ">
									<div class="alert bg-secondary shadow text-white"
										role="alert"
										style="margin: 10px;">
										募資剩餘時間
									</div>
									<h4 id="day" style="display: inline;"></h4><h4 style="display: inline;">天</h4>
									<h4 id="hour" style="display: inline;"></h4><h4 style="display: inline;">時</h4>
									<h4 id="min" style="display: inline;"></h4><h4 style="display: inline;">分</h4>
									<h4 id="sec" style="display: inline;"></h4><h4 style="display: inline;">秒</h4>
									<div
										style="margin-top: 10px;">
										<div
											class="class-sell">
											<div class="alert bg-secondary shadow text-white "
												role="alert"
												style="margin: 10px;">
												正式售價
											</div>
											<h3
												style="margin: 0px;text-decoration:line-through;">
												NT＄${class_infoVO.original_price}
											</h3>
										</div>
										<div
											class="class-sell">
											<div class="alert bg-secondary shadow text-white "
												role="alert"
												style="margin: 10px;">
												早鳥售價
											</div>
											<h3
												style="margin: 0px;">
												NT＄${class_infoVO.startfund_price}
											</h3>
										</div>
										<div class="class-carbut"
											style="margin-top: 20px;">
											<button
												id="carbut"
												type="button"
												class="btn  btn-danger" ">加入購物車</button>
<a href=" <%=request.getContextPath()%>/Order_info/EShopServlet?action=carbutNow&class_id=${class_infoVO.class_id}">
												<button
													id="carbutNow"
													type="button"
													class="btn btn-danger">馬上購買</button>
												</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<!-- 內容 -->
			<div id="content-class">
				<div class="row"
					style="margin: auto; justify-content: center;">
					<button type="button"
						class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">課程簡介</button>
					<button type="button"
						class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">課程發問</button>
					<button type="button"
						class="class-btn btn btn-secondary col-2"
						style="margin-right: 45px;">作品欣賞</button>
					<button type="button"
						class="class-btn btn btn-secondary col-2">課程評價</button>
				</div>
			</div>
		</div>


		<div class="container">
			<!-- 內容 -->
			<div id="content">

				<div class="row">

					<!-- 之後會用JSP改成 inclord-->
					<div class="col-10">內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊
						內容切版先寫在這邊 內容切版先寫在這邊 內容切版先寫在這邊</div>
				</div>
			</div>
			<!--  聊天室-->
			<img id="talk"
				src="<%=request.getContextPath()%>/img/icon/chat.png">



		</div>
		<!-- Footer -->
		<%@ include file="footer.jsp" %>



			<!-- JavaScript -->
			<script
				src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.5.1.min.js"></script>
			<script
				src="<%=request.getContextPath()%>/vendors/jquery/jquery-timers.min.js"></script>
			<script
				src="<%=request.getContextPath()%>/vendors/popper/popper.min.js"></script>
			<script
				src="<%=request.getContextPath()%>/vendors/bootstrap/js/bootstrap.min.js"></script>
			<script
				src="<%=request.getContextPath()%>/vendors/video-js/js/video.js"></script>
				
			<script>

				var startDate = new Date();
				console.log(startDate);
				var endDate = new Date('${class_infoVO.startfund_date}');
				var spantime = (endDate - startDate)/1000;

				$(document).ready(function () {
					$(this).everyTime('1s', function(i) {
					spantime --;
					var d = Math.floor(spantime / (24 * 3600));
					var h = Math.floor((spantime % (24 * 3600)) / 3600);
					var m = Math.floor((spantime % 3600) / (60));
					var s = Math.floor(spantime % 60);

					if (spantime > 0) {
						$('#day').text(d);
						$('#hour').text(h);
						$('#min').text(m);
						$('#sec').text(s);
					} else { // 避免倒數變成負的
						$('#day').text(0);
						$('#hour').text(0);
						$('#min').text(0);
						$('#sec').text(0);
					}
					});
				});
				//加入購物車
				$("div.class-carbut").on("click", "button#carbut", function () {
					var that = $(this);
					console.log(that);
					var data_updata = {
						"action": "ADD",
						"class_id": "${class_infoVO.class_id}"
					}

					$.ajax({
						url: "/TEA102G5/Order_info/EShopServlet", // 資料請求的網址
						type: "GET",
						data: data_updata, // 傳送資料到指定的 url

					});

				});
			</script>
</body>

</html>