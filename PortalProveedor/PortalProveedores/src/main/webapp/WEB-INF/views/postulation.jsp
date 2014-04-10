<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<!-- <link rel="stylesheet" type="text/css" href="resources/styles/style_accordion.css"/>
	<link rel="stylesheet" type="text/css" href="resources/styles/style_tabs.css"/>
	<link rel="stylesheet" type="text/css" href="resources/styles/global.css"/>
	<!-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script> -->
	<!--<script language="text/javascript" src="/resources/js/main.js"></script>  
	
	
	<script src="/portalproveedores/resources/js/main.js"></script>-->
	<!-- <script src="/resources/js/jquery-2.1.0.js"></script> -->
	<script src="<c:url value="/resources/js/validateProspect.js" />"></script>
	<title>Portal de Proveedores</title>
	 <style type="text/css" media="all">
		@import "resources/styles/global.css";
		@import "resources/styles/style_accordion.css";
		@import "resources/styles/style_tabs.css";
		
	</style>
</head>

<body>
<div id="wrapper">
	<%@include file="includes/header.jsp" %>
	
	<div id="bodyboxnm">
		
		<div class="ic"></div>	
		<div id="content">
			<h1><spring:message code="label.vendornomination"/></h1>
			<form:form id="postulationForm" action ="/portalproveedores/postulationsuccess" modelAttribute="posform" accept-charset="UTF-8" method="post" onsubmit="return validateSolicitude(this);">
				<div id="tabs">
					<ul>
						<li id="One"><a href="#One" id="first"><spring:message code="label.basicInformation"/></a>
							<div id="tab">
									<table id="registro">
										<tr>
											<td><p><spring:message code="label.name"/>:</p></td>
											<td><form:input class="inputform2" path="commercialName" id="nombreComercial" name="nombreComercial"/></td>
											<td><p><spring:message code="label.country"/>:</p></td>
											<td><form:select name="pais" id="pais" path="country" class="combo4" items="${posform.countryList}">														
													</form:select>
											</td>
										</tr>
										<tr>
											<td><p><spring:message code="label.rif"/>:</p></td>
											<td><form:input class="inputform2" path="rif" id="rif" name="rif"/></td>
											<td><p>Persona de contacto:</p></td>
											<td><form:input class="inputform2" path="contactPerson" id="personaContacto" name="personaContacto"/></td>
											
										</tr>
										<tr>
											<td><p><spring:message code="label.telephone"/>:</p></td>
											<td><form:input class="inputform2" path="phone" id="telefono" name="telefono"/></td>
											<td><p>Procedencia:</p></td>
											<td><form:select id="procedencia" name="procedencia" class="combo4" path="origin" items="${posform.originList}" />
											</td>
										</tr>
										<tr>
											<td><p><spring:message code="label.email"/>:</p></td>
											<td><form:input class="inputform2" path="email" id="correo" name="correo"/></td>
											<td><p>Detalle de Procedencia:</p></td>
											<td><form:input class="inputform2" path="originDetails" id="detalleProcedencia" name="detalleProcedencia"/></td>
										</tr>
										<tr>
											<td><p><spring:message code="label.website"/>:</p></td>
											<td><form:input class="inputform2" path="website" id="sitioWeb" name="sitioWeb"/></td>
											<td><p>Observaci&oacute;n:</p></td>
											<td id="text" rowspan="2"><form:textarea rows="2" id="observaciones" name="observaciones" path="observation"/></td>
										</tr>
										
									</table>
									
							</div>
						</li>
						<li id="Two"><a href="#Two" id="sec"><spring:message code="label.productsServices"/></a>
							<div>
								<table id="tablacat">
										<tr>
											<td>
												<p>Categor&iacute;a</p>
											</td>
											<td>
												<p>Departamento</p>
											</td>
											<td>
												<p>L&iacute;nea</p>
											</td>
											<td>
												<p>Secci&oacute;n</p>
											</td>
										</tr>
										<tr>
											<td>
												<form:select id="combomultiple2" class="combo3" multiple="true" path="selectedCategoryList" itemValue="posform.category" itemLabel="posform.category">
												    <form:options items="${categoryList}" />
												</form:select>
											</td>
											<td>
												<form:select id="combomultiple2" class="combo3" multiple="true" path="selectedDepartmentList" itemValue="posform.department" itemLabel="posform.department">
												    <form:options items="${departmentList}" />
												</form:select>
											</td>
											<td>
												<form:select id="combomultiple2" class="combo3" multiple="true" path="selectedLineList" itemValue="posform.line" itemLabel="posform.line">
												    <form:options items="${lineList}" />
												</form:select>
											</td>
											<td>
												<form:select id="combomultiple2" class="combo3" multiple="true" path="selectedSectionList" itemValue="posform.section" itemLabel="posform.section">
												    <form:options items="${sectionList}" />
												</form:select>
											</td>
										</tr>
									</table>
								</div>
						</li>
					</ul>
				
				</div>
				<div id="divboton1">
	
					<button id="btnenviar" type="submit" value="Enviar"><spring:message code="label.send"/></button>
				
				</div>
			</form:form>
		</div>	
			<a href="/portalproveedores/index">Inicio Portal</a>
	</div>
	<div id="footer">
		<p>Copyright 2014 AMAND/BECO/CAPUY All Rights Reserved. | Design by <a target="_blank">Sistemas</a></p>
	</div>
</div>
</body>
</html>
