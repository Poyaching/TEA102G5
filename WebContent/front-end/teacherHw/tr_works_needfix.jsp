<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
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
    <title>TOMATO - 讓你分分鐘鐘都在學習的平台</title>
</head>

<body>
    <!-- header -->
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">TOMATO</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">首頁 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">我的課程</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            課程選單
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">語言</a>
                            <a class="dropdown-item" href="#">攝影</a>
                            <a class="dropdown-item" href="#">設計</a>
                            <a class="dropdown-item" href="#">人文</a>
                            <a class="dropdown-item" href="#">行銷</a>
                            <a class="dropdown-item" href="#">程式</a>
                        </div>
                    </li>
                    <li>
                        <form class="form-inline my-2 my-lg-0" style="position:left">
                            <input class="form-control mr-sm-2" type="search" placeholder="輸入你想要的課程"
                                aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </li>
                </ul>

                <ul class="navbar-nav mr-3">
                    <li class="nav-item dropdown">
                        <img class="" style="height: 30px;" data-toggle="dropdown" alt="個人專區"
                            src="https://pic.90sjimg.com/design/00/08/16/10/591fa3911d5ee.png">
                        <div class="dropdown-menu mt-2">
                            <a class="dropdown-item" href="#">帳號設定</a>
                            <a class="dropdown-item" href="#">個人檔案</a>
                            <a class="dropdown-item" href="#">訂單紀錄</a>
                            <a class="dropdown-item" href="#">我的優惠</a>
                            <a class="dropdown-item" href="#">登出</a>
                        </div>
                    </li>
                </ul>


                <div class="nav-item mr-3 my-3">
                    <a href="">
                        <img src="https://i-1.lanrentuku.com/2020/11/9/7d9cf2fd-ed76-466a-9012-51b017c46025.png"
                            alt="購物車" style="height: 30px;">
                    </a>
                </div>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <img class="" style="height: 30px;" data-toggle="" alt="小鈴鐺"
                            src="https://cdn4.iconfinder.com/data/icons/ionicons/512/icon-ios7-bell-512.png">
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">通知#</a>
                            <a class="dropdown-item" href="#">通知#</a>
                            <a class="dropdown-item" href="#">通知#</a>
                        </div>
                    </li>
                </ul>
                <!-- 會員下拉選單 -->
            </div>
        </nav>
    </header>

    <!-- container -->
    <!-- 標題 -->
    <div class="jumbotron jumbotron-fluid" style="padding-bottom: 0;">
        <div class="container">
            <h1>海獺超級可愛的</h1>
            <p>說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明說明</p>
        </div>
        <div class="container-fluid sidebar" style="position: relative;">
            <div class="container">
                <div class="row">
                    <!-- 影片底圖 -->
                    <div class="col-9 video embed-responsive embed-responsive-16by9">
                        <video id="my-video" class="video-js embed-responsive-item" controls preload="auto"
                            poster="\img\online-teaching-platform.png" data-setup="{}">
                            <source src="/WebContent/img/videoplayback.mp4" type="video/mp4" />
                        </video>
                    </div>
                    <div class="col-3 video-list pr-0">
                        <div>
                            <h2 style="margin: 10px; text-align:center">影片列表</h2>
                            <ul class="list-group" style="overflow:auto; height:420px;">
                            	<li>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                                <button type="button" class=" class-btn btn btn-secondary">課程簡介</button>
                            	</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 五個button -->
    <div class="container">
        <!-- 內容 -->
        <div id="content-class">
            <div class="row d-flex justify-content-around">
                <button type="button" class="class-btn col-2">
                    課程簡介</button>
                <button type="button" class="class-btn col-2">
                    學習發問</button>
                <button type="button" class="class-btn col-2">
                    作品欣賞</button>
                <button type="button" class="class-btn col-2">
                    隨堂測驗</button>
                <button type="button" class="class-btn col-2">
                    課程評價</button>
            </div>
        </div>
    </div>
    <!-- 內容 -->
    <div class="container">
        <!-- 三個button -->
        <div id="content-class">
            <div class="row" style="justify-content: space-around; ">
                <a class="btn class-btn col-3" href="">
                    作品集
                </a>
                <a class="btn class-btn col-3" href="">
                    作業題目
                </a>
                <a class="btn class-btn col-3" href="">
                    編輯作業
                </a>
            </div>
        </div>

        <div id="content-class">
            <!-- 作業單元選擇，下拉式選單 & 小icon -->
            <div class="row" style="justify-content: space-between; margin: 3% 3% 0 2%;">
                <div>
                    <span class="col-2">作業單元 :</span>
                    <select>
                        <option>請選擇單元</option>
                        <option>單元一 xxxx</option>
                        <option>單元二 xxxx</option>
                        <option>單元三 xxxx</option>
                        <option>單元四 xxxx</option>
                        <option>單元五 xxxx</option>
                    </select>
                </div>
                <button class="class-btn" style="padding-top:0;padding-bottom: 0;">
                    <!-- 小icon -->
                    所有同學作品
                </button>
            </div>
            <!-- 作品卡片集 -->
            <div class=" p-1" id="content">
                <!-- 作品卡片 -->
                <div class="row m-0 d-flex justify-content-around">
                    <div class="card  my-2" style="width: 20rem;">
                        <img class="card-img-top" src="<%=request.getContextPath()%>/img/online-teaching-platform.png" alt="作品圖">
                        <div class="row-3 mt-1 mb-1 text-center border-bottom border-dark">
                            <h4 class="">Card title</h4>
                            <h5 class="card-text ">2020/12/20</h5>
                        </div>
                        <div class="card-text d-flex align-items-center mb-1">
                            <div class="col col-3 pr-0">
                                <img class="rounded-circle img-fluid" src="<%=request.getContextPath()%>/img/法鬥可愛圖.jpg" alt="學生頭像">
                            </div>
                            <div class="col col-9 p-0">
                                <p class=" text-center m-0">POYA CHING</p>
                            </div>
                        </div>
                    </div>
                    <div class="card  my-2" style="width: 20rem;">
                        <img class="card-img-top" src="<%=request.getContextPath()%>/img/online-teaching-platform.png" alt="作品圖">
                        <div class="row-3 mt-1 mb-1 text-center border-bottom border-dark">
                            <h4 class="">Card title</h4>
                            <h5 class="card-text ">2020/12/20</h5>
                        </div>
                        <div class="card-text d-flex align-items-center mb-1">
                            <div class="col col-3 pr-0">
                                <img class="rounded-circle img-fluid" src="<%=request.getContextPath()%>/img/dark_air.jpg" alt="學生頭像">
                            </div>
                            <div class="col col-9 p-0">
                                <p class=" text-center m-0">POYA CHING</p>
                            </div>
                        </div>
                    </div>
                    <div class="card  my-2" style="width: 20rem;">
                        <img class="card-img-top" src="<%=request.getContextPath()%>/img/online-teaching-platform.png" alt="作品圖">
                        <div class="row-3 mt-1 mb-1 text-center border-bottom border-dark">
                            <h4 class="">Card title</h4>
                            <h5 class="card-text ">2020/12/20</h5>
                        </div>
                        <div class="card-text d-flex align-items-center mb-1">
                            <div class="col col-3 pr-0">
                                <img class="rounded-circle img-fluid" src="<%=request.getContextPath()%>/img/法鬥可愛圖.jpg" alt="學生頭像">
                            </div>
                            <div class="col col-9 p-0">
                                <p class=" text-center m-0">POYA CHING</p>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            
        </div>
    </div>
    
    <!--  聊天室-->
    <img id="talk" src="https://image.flaticon.com/icons/png/512/1952/1952178.png">
    <!-- Footer -->
    <footer class="page-footer font-small blue pt-4" style="background-color: azure;">

        <!-- Footer Links -->
        <div class="container-fluid text-center text-md-left">

            <!-- Grid row -->
            <div class="row">

                <!-- Grid column -->
                <div class="col-md-6 mt-md-0 mt-3">

                    <!-- Content -->
                    <h5 class="text-uppercase">Footer Content</h5>
                    <p>Here you can use rows and columns to organize your footer content.</p>

                </div>
            </div>
        </div>

        <div class="footer-copyright text-center py-3">@ 2020 Copyright:
            <a href="https://mdbootstrap.com/"> MDBootstrap.com</a>
        </div>

    </footer>

    <!-- JavaScript -->
    <script src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.5.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/vendors/popper/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/vendors/video-js/js/video.js"></script>

</body>

</html>