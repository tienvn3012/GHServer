<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="css" items="${more_css}" varStatus="indexes">
    <link href="${css.path}" type="text/css" rel="stylesheet" />
</c:forEach>

<c:forEach var="js" items="${more_js}" varStatus="indexes">
   <script src="${js.path}"></script>
</c:forEach>