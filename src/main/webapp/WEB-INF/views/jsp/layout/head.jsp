<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Insert title here</title>

<spring:url value="/resources/css/lib/bootstrap.css" var="bootstrap"></spring:url>
<spring:url value="/resources/css/lib/font-awesome-4.7.0/css/font-awesome.css" var="font_awesome"></spring:url>
<spring:url value="/resources/css/lib/bootstrap-toggle.min.css" var="bootstrap_toggle_css"></spring:url>
<spring:url value="/resources/css/style.css" var="style"></spring:url>


<spring:url value="/resources/js/lib/jquery-3.2.1.min.js" var="jquery"></spring:url>
<spring:url value="/resources/js/lib/jquery-ui.js" var="jquery_ui"></spring:url>
<spring:url value="/resources/js/lib/sockjs-0.3.4.min.js" var="sockjs"></spring:url>
<spring:url value="/resources/js/lib/stomp.min.js" var="stompjs"></spring:url>
<spring:url value="/resources/js/lib/jquery.nicescroll.js" var="jquery_nicescroll"></spring:url>
<spring:url value="/resources/js/lib/jquery.form.js" var="jquery_form"></spring:url>
<spring:url value="/resources/js/lib/bootstrap.js" var="bootstrapjs"></spring:url>
<spring:url value="/resources/js/lib/bootstrap-toggle.min.js" var="bootstrap_toggle_js"></spring:url>
<spring:url value="/resources/js/app.js" var="app"></spring:url>

<link href="${bootstrap}" type="text/css" rel="stylesheet" />
<link href="${bootstrap_toggle_css}" type="text/css" rel="stylesheet" />
<link href="${font_awesome}" type="text/css" rel="stylesheet" />
<link href="${style}" type="text/css" rel="stylesheet" />

<script src="${jquery}"></script>
<script src="${jquery_ui}"></script>
<script src="${sockjs}"></script>
<script src="${stompjs}"></script>
<script src="${jquery_nicescroll}"></script>
<script src="${jquery_form}"></script>
<script src="${bootstrapjs}"></script>
<script src="${bootstrap_toggle_js}"></script>
<script src="${app}"></script>
