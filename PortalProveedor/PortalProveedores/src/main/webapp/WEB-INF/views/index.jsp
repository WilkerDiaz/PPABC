<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Portal de Proveedores</title>
<style type="text/css" media="all">
	@import "resources/styles/global.css";
	@import "resources/styles/style_accordion.css";
</style>
</head>
<body>
<div id="wrapper">
	<%@include file="includes/header.jsp" %>
	<div id="bodybox">
		<%@include file="includes/menu.jsp" %>
		<div class="ic"></div>	
		<div id="content">
			<h1><spring:message code="label.topSupliers"/></h1>
			<div id="filtros">
				<form:form id="basicSearchForm" method="post" modelAttribute="bform" action="/portalproveedores/index?page=1" accept-charset="UTF-8">
					<table id="tablafiltros">
						<tr>
							<td>
								<p><spring:message code="label.department"/>:</p>
							</td>
							<td>
								<select size="1" class="combo"> 
									<option value="Seleccione"><spring:message code="label.select"/></option>
									<option value="opcion2">opcion2</option>
									<option value="opcion3">opcion3</option>
									<option value="opcion4">opcion4</option> 
								</select>
							</td>
							<td>
								<p><spring:message code="label.productsServices"/>:</p>
							</td>
							<td>
							
								<select size="1" class="combo" onchange="javascript:alert('prueba');"> 
									<option value="link pagina 1"><spring:message code="label.select"/></option>
									<option value="link pagina 2">Bienes</option>
									<option value="link pagina 3">Productos</option>
									<option value="link pagina 4">Servicios</option> 
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<p><spring:message code="label.prospect"/>:</p>
							</td>
							<td>
								<form:checkbox path="isProspect" id="esProspecto" name="esProspecto" value="YES"/>
							</td>
							<td>
								<p><spring:message code="label.name"/></p>
							</td>
							<td>
								<input id="buscarnombre" type="search" name="nombre"/> 
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input id="btnbusquedaav" type="button" value="<spring:message code="label.advancedSearch"/>" onclick="window.location.href='/portalproveedores/busquedaavanzada'"/>
							</td>
							<td colspan="2">
								<button id="btnbuscar"><spring:message code="label.search"/></button>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
			
			<div class="datagrid">
				<table>
					<thead>
						<tr>
							<th><spring:message code="label.supplier"/></th><th><spring:message code="label.country"/></th><th><spring:message code="label.position"/></th><th><spring:message code="label.evaluation"/></th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="4">
								<div id="paging">
									<ul>
										<li><a href="${previous}"><span>Previous</span></a></li>
										<li><a href="${lpg1}" class="active"><span>${pg1}</span></a></li>
										<li><a href="${lpg2}"><span>${pg2}</span></a></li>
										<li><a href="${lpg3}"><span>${pg3}</span></a></li>
										<li><a href="${lpg4}"><span>${pg4}</span></a></li>
										<li><a href="${lpg5}"><span>${pg5}</span></a></li>
										<li><a href="${next}"><span>Next</span></a></li>
									</ul>
								</div>
							</td>
						</tr>
					</tfoot>
					<tbody>
						<c:set var="i" value="${1}"/>
						<c:forEach items="${prospectList}" var="pros" >
							<c:if test="${(i mod 2) == 0}">
				     			<tr class="alt">
									<td><a href="registro.html?supplier=${pros.commercialName}#One">${pros.commercialName}</a></td>
									<td>${pros.country}</td>
									<td>${pospro1}</td>
									<td>${evapro1}</td>
								</tr>
							</c:if>
							<c:if test="${(i mod 2) > 0}">
				     			<tr>
									<td><a href="registro.html?supplier=${pros.commercialName}#One">${pros.commercialName}</a></td>
									<td>${pros.country}</td>
									<td>${pospro1}</td>
									<td>${evapro1}</td>
								</tr>
							</c:if>
							<c:set var="i" value="${i+1}"/>
			    		</c:forEach>
					</tbody>
				</table>
			</div>
		</div>	
	</div>
	<%@include file="includes/footer.jsp" %>
</div>
</body>
</html>
