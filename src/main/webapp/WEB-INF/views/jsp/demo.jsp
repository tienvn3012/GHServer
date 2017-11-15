<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<spring:url value="/resources/js/lib/sockjs-0.3.4.min.js" var="sockjs" />
<spring:url value="/resources/js/lib/stomp.min.js" var="stomp" />

<script src="${sockjs}"></script>
<script src="${stomp}"></script>

<script>

function connect(){
	var socket = new SockJS("/GHServer/control_app/");
	stompClient = Stomp.over(socket);
	stompClient.connect({},function(frame){
		console.log('Connected: ' + frame);
		stompClient.subscribe("/topic/control",function(mes){
			 var response = document.getElementById('show');
			 response.innerHTML = JSON.parse(mes.body).message;
		})
	});
}

function sendMessage(){
	var msg = document.getElementById('mes').value;
	console.log(msg);
	stompClient.send("/gh/control_app", {}, JSON.stringify({'message' : msg}));
}

</script>

<title>Insert title here</title>
</head>
<body>
<h1>demooooo</h1>

<button id="connect" onclick="connect()">Connect</button>
<input id="mes" type="text" />
<button id = "send" onclick="sendMessage()">Send</button>
<p id="show"></p>
</body>
</html>