<%@page import="com.member_info.model.Member_infoVO"%>
<%@page import="com.member_info.model.Member_infoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<%
	Member_infoService member_infoSrv = new Member_infoService();
	List<Member_infoVO> memberlist = (List<Member_infoVO>) member_infoSrv.getAll();
	pageContext.setAttribute("memberlist", memberlist);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/friendchat.css" type="text/css" />
<style type="text/css">
</style>
<title>Tomato客服聊天室</title>
</head>
<body onload="connect();" onunload="disconnect();">
	<h3 id="statusOutput" class="statusOutput"></h3>
	<div id="row" style="background-color:#ffff;float=left;width:34%;">
	<div><p style="text-align:center;font-size:22px;color:#ffffff;background: #0181cc;#0181cc;max-inline-size:fit-content;pointer-events:none;">請點選聊天對象</p></div>
		<c:forEach var="memberlist" items="${memberlist }">
			<div  style="border:3px #7880e2 solid;width:380px;height:30px;cursor:pointer;" id="${memberlist.member_name }">
			<h2>${memberlist.member_email }</h2>
			</div></c:forEach>
				<%-- 	<div id="" class="column" name="friendName" value="${userName2 }"><h2>${userName2 }</h2></div> --%>
			</div>
			<div id="messagesArea" class="panel message-area"></div>
			<div class="panel input-area">
				<input id="message" class="text-field" type="text"
					placeholder="Message"
					onkeydown="if (event.keyCode == 13) sendMessage();" /> <input
					type="submit" id="sendMessage" class="button" value="Send"
					onclick="sendMessage();" /> <input type="button" id="connect"
					class="button" value="Connect" onclick="connect();" /> <input
					type="button" id="disconnect" class="button" value="Disconnect"
					onclick="disconnect();" />
					<div>
				<h2 style="color: #ffffff">現在登入的是: ${member_infoVO.member_name}
				</h2>
			</div>
			</div>
			
</body>
<script>
	var MyPoint = "/FriendWS/${userName}";
	var host = window.location.host;
	var path = window.location.pathname;
	var webCtx = path.substring(0, path.indexOf('/', 1));
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;

	var statusOutput = document.getElementById("statusOutput");
	var messagesArea = document.getElementById("messagesArea");
	var self = '${userName}';
	var webSocket;

	function connect() {
		// create a websocket
		webSocket = new WebSocket(endPointURL);

		webSocket.onopen = function(event) {
			console.log("Connect Success!");
			document.getElementById('sendMessage').disabled = false;
			document.getElementById('connect').disabled = true;
			document.getElementById('disconnect').disabled = false;
		};

		webSocket.onmessage = function(event) {
			var jsonObj = JSON.parse(event.data);
			if ("open" === jsonObj.type) {
				refreshFriendList(jsonObj);
			} else if ("history" === jsonObj.type) {
				messagesArea.innerHTML = '';
				var ul = document.createElement('ul');
				ul.id = "area";
				messagesArea.appendChild(ul);
				// 這行的jsonObj.message是從redis撈出跟好友的歷史訊息，再parse成JSON格式處理
				var messages = JSON.parse(jsonObj.message);
				for (var i = 0; i < messages.length; i++) {
					var historyData = JSON.parse(messages[i]);
					var showMsg = historyData.message;
					var li = document.createElement('li');
					// 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
					historyData.sender === self ? li.className += 'me'
							: li.className += 'friend';
					li.innerHTML = showMsg;
					ul.appendChild(li);
				}
				messagesArea.scrollTop = messagesArea.scrollHeight;
			} else if ("chat" === jsonObj.type) {
				var li = document.createElement('li');
				jsonObj.sender === self ? li.className += 'me'
						: li.className += 'friend';
				li.innerHTML = jsonObj.message;
				console.log(li);
				document.getElementById("area").appendChild(li);
				messagesArea.scrollTop = messagesArea.scrollHeight;
			} else if ("close" === jsonObj.type) {
				refreshFriendList(jsonObj);
			}

		};

		webSocket.onclose = function(event) {
			console.log("Disconnected!");
		};
	}

	function sendMessage() {
		var inputMessage = document.getElementById("message");
		var friend = statusOutput.textContent;

		var message = inputMessage.value.trim();

		if (message === "") {
			alert("Input a message");
			inputMessage.focus();
		} else if (friend === "") {
			alert("Choose a friend");
		} else {
			var jsonObj = {
				"type" : "chat",
				"sender" : self,
				"receiver" : friend,
				"message" : message
			};
			webSocket.send(JSON.stringify(jsonObj));
			inputMessage.value = "";
			inputMessage.focus();
		}
	}

	// 有好友上線或離線就更新列表
	function refreshFriendList(jsonObj) {
		var friends = jsonObj.users;
		// 		var friends = jsonObj.memberlist;
		// 		var row = document.getElementById("row");
		// 		row.innerHTML = '';
		// 		for (var i = 0; i < 10; i++) {
		// 			if (friends[i] === self) { continue; }
		// 			row.innerHTML +='<div id=' + i + ' class="column" name="friendName" value=' + friends[i] + ' ><h2>' + friends[i] + '</h2></div>';
		// 		}
		addListener();

	}
	// 		row.innerHTML = '';
	// 		for (var i = 0; i < friends.length(); i++) {
	// 			if (friends[i] === self) { continue; }
	// 			row.innerHTML +='<div id=' + i + ' class="column" name="friendName" value=' + friends[i] + ' ><h2>' + friends[i] + '</h2></div>';
	// 		}

	// 		addListener();
	// 	}
	// 註冊列表點擊事件並抓取好友名字以取得歷史訊息
	function addListener() {
		var container = document.getElementById("row");
		container.addEventListener("click", function(e) {
			var friend = e.srcElement.textContent;
			updateFriendName(friend);
			var jsonObj = {
				"type" : "history",
				"sender" : self,
				"receiver" : friend,
				"message" : ""
			};
			webSocket.send(JSON.stringify(jsonObj));
		});
	}

	function disconnect() {
		webSocket.close();
		document.getElementById('sendMessage').disabled = true;
		document.getElementById('connect').disabled = false;
		document.getElementById('disconnect').disabled = true;
	}

	function updateFriendName(name) {
		statusOutput.innerHTML = name;
	}
</script>
</html>