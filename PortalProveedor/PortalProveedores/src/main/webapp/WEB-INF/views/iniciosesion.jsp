<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="styles/style_accordion.css">
<link rel="stylesheet" type="text/css" href="styles/style_tabs.css">
<title>Portal de Proveedores</title>
<style type="text/css" media="all">
	@import "resources/styles/global.css";
	@import "resources/styles/style_accordion.css";
</style>
</head>

<body>
<div id="wrapper">
	<%@include file="includes/header.jsp" %>
	
	<div id="bodyboxnm">
		
		<div class="ic"></div>	
		<div id="content">
			
			<h1><spring:message code="label.login"/></h1>
			<div id="login">
				<form:form method="post" action="/portalproveedores/index?page=1" modelAttribute="loginform" accept-charset="UTF-8">
					<div id="campo">
						<div id="lblfiltro">
							<p><spring:message code="label.username"/>:</p>
						</div>
						<div id="campo">
							<form:input class="campoin" path="user" />
						</div>
					</div>
					<div id="campo">
						<div id="lblfiltro">
							<p><spring:message code="label.password"/>:</p>
						</div>
						<div id="campo">
							<form:password class="campoin" path="password" />
						</div>
					</div>
					<div id="campo">
						<div id="lblfiltro">
							<p><spring:message code="label.language"/>:</p>
						</div>
						<div id="campo">
							<form:select  class="combo3" path="language" items="${loginform.languageList}"/>
						</div>
					</div>
					<button id="btnenviar3" type="submit" value="Enviar"><spring:message code="label.send"/></button>
				</form:form>
			</div>
			
			
		</div>	
			<a href="/portalproveedores/index?page=1">Inicio Portal</a>
	</div>
	<div id="footer">
		<p>Copyright 2014 AMAND/BECO/CAPUY All Rights Reserved. | Design by <a target="_blank">Sistemas</a></p>
	</div>
</div>
</body>
</html>
