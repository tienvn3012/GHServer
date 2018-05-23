<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="home">
	<div class="main">
		<div class="content">
			
				<div class="row">
					<c:forEach var="item" items="${items}" varStatus="indexes">
    					<div class="block col-lg-3 col-md-3 col-sm-4 col-xs-12" ref="${item.name}">
							<div class="block-inside">
								<i class="fa fa-${item.icon} mar-t-10px fontsize58"></i>
								<br />
								<span class="fontsize24 fontweight-bold mar-b-10px">${item.display_name}</span>
							</div>
						</div>
					</c:forEach>
				</div>
					
			
		</div>
	</div>
</div>