<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<spring:url value="/resources/js/lib/jquery-3.2.1.min.js" var="jquery" />
<title>Insert title here</title>

<script src="${jquery}"></script>

</head>
<body>
	
	<button id="led">Click</button>
	
<script>
	$(document).ready(function(){
		
		$("#led").click(function(){
			$.ajax({url: "demo2/led",type : "POST", success: function(result){
		       alert("ok");
		    }});
		});
		
	});
</script>
	
</body>
</html>