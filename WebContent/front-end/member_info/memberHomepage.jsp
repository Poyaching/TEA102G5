<%@page import="java.sql.Time"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member_info.model.*"%>


<html lang="en">

<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/vendors/bootstrap/css/bootstrap.min.css">
<!-- css -->
<link
	href="<%=request.getContextPath()%>/css/header.css"
	rel="stylesheet" />		



<style>

        /* ������ */
        #content {
            margin-top: 10px;
            margin-bottom: 50px;
            border: 1px rgb(204, 204, 204) solid;
        }

        /* The switch - the box around the slider */
        .switch {
            position: relative;
            display: inline-block;
            width: 60px;
            height: 34px;
        }

        /* Hide default HTML checkbox */
        .switch input {
            opacity: 0;
            width: 0;
            height: 0;
        }

        /* The slider */
        .slider {
            position: absolute;
            cursor: pointer;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #ccc;
            -webkit-transition: .4s;
            transition: .4s;
        }

        .slider:before {
            position: absolute;
            content: "";
            height: 26px;
            width: 26px;
            left: 4px;
            bottom: 4px;
            background-color: white;
            -webkit-transition: .4s;
            transition: .4s;
        }

        input:checked+.slider {
            background-color: #2196F3;
        }

        input:focus+.slider {
            box-shadow: 0 0 1px #2196F3;
        }

        input:checked+.slider:before {
            -webkit-transform: translateX(26px);
            -ms-transform: translateX(26px);
            transform: translateX(26px);
        }

        /* Rounded sliders */
        .slider.round {
            border-radius: 34px;
        }

        .slider.round:before {
            border-radius: 50%;
        }
</style>



<title>TOMATO - ���A�����������b�ǲߪ����x</title>

</head>
<body>
    
	<%@ include file="header.jsp"%>
    <!-- container -->

    <div class="container">
        <!-- ���D -->
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1>�ӤH�ɮ�</h1>
                <p></p>
            </div>
        </div>
        <!-- ���e -->
        <div id="content">
            <div class="row">

                <div class="col-3">
                    <div class="card">
                        <img src="./images/����.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <p style="text-align: center;">�G�v�S</p>
                        </div>
                    </div>
                    <div class="card border-dark mb-3" style="max-width: 18rem;">
                        <div class="card-header">�w�ѥ[�ҵ{</div>
                        <div class="card-body text-dark">
                            <h1 class="card-title">100</h1>
                        </div>
                    </div>
                    <div class="card border-dark mb-3" style="max-width: 18rem;">
                        <div class="card-header">�w�}�]�ҵ{</div>
                        <div class="card-body text-dark">
                            <h1 class="card-title">100</h1>
                        </div>
                    </div>
                    <div class="card border-dark mb-3" style="max-width: 18rem;">
                        <div class="card-header">�����</div>
                        <div class="card-body text-dark">
                            <h9 class="card-title">XXXXXXXXX</h9>
                        </div>
                    </div>
                    <div class="card border-dark mb-3" style="max-width: 18rem;">
                        <div class="card-header">�ڪ�����</div>
                        <div class="card-body text-dark">
                            <h9 class="card-title">�y���ǲ�</h9>
                        </div>
                    </div>
                    <div class="card border-dark mb-3" style="max-width: 18rem;">
                        <div class="card-header">�ڪ��M��</div>
                        <div class="card-body text-dark">
                            <h9 class="card-title">�{���y��</h9>
                        </div>
                    </div>

                </div>
                <div class="col-7">
                    <label>�}�]�ҵ{</label>
                    <div class=" row">
                        <div class="card col-6">
                            <img class="card-img-top" src="./images/1.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This card has supporting text below as a natural lead-in to
                                    additional
                                    content.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                        <div class="card col-6">
                            <img class="card-img-top" src="./images/1.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This card has supporting text below as a natural lead-in to
                                    additional
                                    content.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>


                        <!-- Rounded switch -->
                       
                    </div>
                    <label>�ѥ[�ҵ{</label>
                    <div class=" row">
                        <div class="card col-6">
                            <img class="card-img-top" src="./images/2.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This card has supporting text below as a natural lead-in to
                                    additional
                                    content.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                        <div class="card col-6">
                            <img class="card-img-top" src="./images/2.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This card has supporting text below as a natural lead-in to
                                    additional
                                    content.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                    </div>
                    <label>�ҵ{�@�~</label>
                    <div class=" row">
                        <div class="card col-6">
                            <img class="card-img-top" src="./images/3.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This card has supporting text below as a natural lead-in to
                                    additional
                                    content.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                        <div class="card col-6">
                            <img class="card-img-top" src="./images/3.png" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This card has supporting text below as a natural lead-in to
                                    additional
                                    content.</p>
                                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                            </div>
                            <label class="switch">
                                <input type="checkbox">
                                <span class="slider round"></span>
                            </label>
                        </div>
                    </div>

                </div>





                <!-- �� 6 �� -->
                <!-- ����|��JSP�令 inclord-->
                <div class="col-10">

                </div>
            </div>
        </div>
	<!--  ��ѫ�-->
	<img id="talk"
				src="<%=request.getContextPath()%>/img/icon/chat.png">

	<%@ include file="footer.jsp"%>



    <!-- JavaScript -->
    <script src="<%=request.getContextPath()%>/vendors/jquery/jquery-3.5.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/vendors/popper/popper.min.js"></script>
    <script src="<%=request.getContextPath()%>/vendors/bootstrap/js/bootstrap.min.js"></script>


</body>
</html>	
	
	
	
	
	
	