<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="${head}"></jsp:include>
<jsp:include page="${head_loadmore}"></jsp:include>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="wapper">
		<jsp:include page="${topbar}"></jsp:include>
		<jsp:include page="${sidebar}"></jsp:include>
		<jsp:include page="${content}"></jsp:include>
		<jsp:include page="${footer}"></jsp:include>
	</div>
</body>
</html>