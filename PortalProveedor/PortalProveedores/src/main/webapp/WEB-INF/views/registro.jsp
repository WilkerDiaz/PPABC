<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	
	<script type="text/javascript" src="resources/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>
	<script type="text/javascript" src="resources/js/bootstrap-multiselect.js"></script>
	
	<script src="<c:url value="/resources/js/validateProspect.js" />"></script>
	<title>Portal de Proveedores</title>
	<style type="text/css" media="all">
		@import "resources/styles/global.css";
		@import "resources/styles/style_accordion.css";
		@import "resources/styles/style_tabs.css";
		/*@import "resources/styles/bootstrap.css";
		@import "resources/styles/bootstrap-multiselect.css";*/
	</style>
</head>

<body>
<div id="wrapper">
	<%@include file="includes/header.jsp" %>
	<div id="bodybox">
		<%@include file="includes/menu.jsp" %>
		<div id="content">
			<h1><spring:message code="label.vendorinformation"/></h1>
			
			<ol class="progtrckr" data-progtrckr-steps="5">
					<li class="progtrckr-done"><spring:message code="label.prospect"/></li><!--
				 --><li class="progtrckr-todo"><spring:message code="label.preApproved"/></li><!--
				 --><li class="progtrckr-todo"><spring:message code="label.authorizedRegister"/></li><!--
				 --><li class="progtrckr-todo"><spring:message code="label.forApprovingControl"/></li><!--
				 --><li class="progtrckr-todo"><spring:message code="label.registered"/></li>
				 
			</ol>
			<br/>
				
					<div id="tabs2">
					
					<form:form id="registrationForm" action ="/portalproveedores/registrationsuccess" modelAttribute="regForm" accept-charset="UTF-8" method="post" onsubmit="return validateFormRegistry(this);">
						<ul>
							<li id="One"><a href="#One" id="first"><spring:message code="label.basicInformation"/></a>
								<div > <!-- id="tab2"-->
										<table id="registro2">
											<tr>
												<td><p>Nombre Comercial:</p></td>
												<td>
												<form:input class="inputform2" path="commercialName" id="nombreComercial" name="nombreComercial"/>
												</td>
												
												<td><p>Nombre Fiscal:</p></td>
												<td><form:input class="inputform2" path="fiscalName" /></td>
											</tr>
											<tr>
												<td><p>RIF:</p></td>
												<td><form:input class="inputform2" path="rif" id="rif" name="rif"/></td>
												<td><p>Fecha de Vencimiento de RIF:</p></td>
												<td><form:input class="inputform2" path="rifExpirationDate" id="vencimientoRif" name="vencimientoRif"/></td>
											</tr>
											<tr>
												<td><p>Pa&iacute;s:</p></td>
												<td>
													<form:select name="pais" id="pais" path="country" class="combo4" items="${countryList}">														
													</form:select>
												</td>
												<td><p>Persona de contacto:</p></td>
												<td><form:input class="inputform2" path="contactPerson" id="personaContacto" name="personaContacto"/></td>
												
											</tr>
											<tr>
												<td><p>Tel&eacute;fono:</p></td>
												<td><form:input class="inputform2" path="phone" id="telefono" name="telefono"/></td>
												<td><p>Procedencia:</p></td>
												<td><form:select id="procedencia" name="procedencia" class="combo4" path="origin" items="${originList}" > 
													</form:select>
												</td>
											</tr>
											<tr>
												<td><p>Tel&eacute;fono 2:</p></td>
												<td><form:input class="inputform2" path="phone2" id="telefono2" name="telefono2"/></td>
												<td><p>Detalle de Procedencia:</p></td>
												<td><form:input class="inputform2" path="originDetails" id="detalleProcedencia" name="detalleProcedencia"/></td>
											</tr>
											<tr>
												<td><p>Correo:</p></td>
												<td><form:input class="inputform2" path="email" id="correo" name="correo"/></td>
												<td><p>Observaci&oacute;n:</p></td>
												<td id="text" rowspan="2"><form:textarea rows="2" id="observaciones" name="observaciones" path="observation"/></td>
											</tr>
											<tr>
												<td><p>Sitio Web:</p></td>
												<td><form:input class="inputform2" path="website" id="sitioWeb" name="sitioWeb"/></td>
											</tr>
											<tr>
												<td><p>Estado:</p></td>
												<td><form:select name="estado" id="estado" path="status" items="${statusList}" class="combo4">
													</form:select></td>
												<td colspan="2"><p>Bienes  <form:checkbox path="assets" id="bienes" name="bienes" value="YES" />  Productos  <form:checkbox id="productos" path="products" value="YES" name="productos"/> Servicios  <form:checkbox id="servicios" name="servicios" path="services" value="YES"/></p></td>
											</tr>
											<tr>
												<td colspan="2"><p>Estado Actualizado: ${estadoActualizadoFecha}</p></td>
												<td><p>Por:  ${estadoActualizadoPor}</p></td>
											</tr>
											<tr>
												<td colspan="2"><p>Fecha de ingreso: ${fechaRegistro}</p></td>
											</tr>
											<tr>
												<td><p>Detalles Estado:</p></td>
												<td id="text2" colspan="3" rowspan="1"><form:textarea class="inputarea2" rows="2" id="detallesEstado" name="detallesEstado" path="statusDetails"/></td>
												
											</tr>
											<tr>
												<td colspan="2"><p>Aprobado por Finanzas  <form:checkbox name="apFinanzas" id="apFinanzas" path="approvedFinance" value="YES"/></p></td>
												<td colspan="2" ><p>Aprobado por Jefe Encargado  <form:checkbox id="apJEncargado" name="apJEncargado" path="approvedBoss" value="YES"/></p></td>
											</tr>
											<tr>
												<td colspan="4"><button id="btnenviar2" type="submit" value="Enviar">Enviar</button></td>
											</tr>
										</table>
								</div>
							</li>
							<li id="Two"><a href="#Two" id="sec"><spring:message code="label.productsServices"/></a>
								<div>
									<table id="tablacat2">
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
													<form:select id="combomultiple2" class="combo3" multiple="true" path="selectedCategoryList" itemValue="regForm.category" itemLabel="regForm.category">
												    	<form:options items="${categoryList}" />
													</form:select>
												</td>
												<td>
													<select id="combomultiple4" class="combo3" name="mytextarea" size="3" multiple="multiple">
														<option  value="one"> Electrodom&eacute;sticos </option>
														<option  value="two"> Servicio de mesa </option>
														<option  value="three"> Servicio de cama </option>
														<option  value="four"> Implementos para cocinar </option>
														<option  value="four"> Utensilios de cocina </option>
														<option  value="four"> Organizaci&oacute;n </option>
														<option  value="four"> Decoraci&oacute;n </option>
														<option  value="four" selected="selected"> Navidad </option>
													</select>
												</td>
												<td>
													<select id="combomultiple4" class="combo3" name="mytextarea" size="3" multiple="multiple">
														<option  value="one"> Arboles artificiales </option>
														<option  value="two"> Bambalinas </option>
														<option  value="three"> Lencer&iacute;a </option>
														<option  value="four"> Luces </option>
														<option  value="four" selected="selected"> Flores </option>
														<option  value="four"> Candelaboros </option>
														<option  value="four"> Cascanueces </option>
														<option  value="four"> Velas </option>
														<option  value="four"> Mantas </option>
														
													</select>
												</td>
												<td>
													<select id="combomultiple4" class="combo3" name="mytextarea" size="3" multiple="multiple">
														<option  value="one">Luces de figuras </option>
														<option  value="one">Luces para &aacute;rbol</option>
														<option  value="one">Luces tipo manguera</option>
														<option  value="one">Bambalina</option>
														<option  value="one">Base de &aacute;rbol</option>
														<option  value="one">Cadena y collar para &aacute;rbol</option>
													</select>
												</td>
											</tr>
											<tr>
												<td colspan="4"><button id="btnenviar2" type="submit" value="Enviar">Enviar</button></td>
											</tr>											
									</table>

								</div>
							</li>
							<li id="Three"><a href="#Three" id="trd"><spring:message code="label.commercialAgreement"/></a>
								<div ><!-- id="tab2"-->
										<table id="registro2">
											<tr>
												<td><p>Descuento por GOS (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="desGosPorc" name="desGosPorc"/></td>
												<td><p>Descuento por GOS (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="desGosMonto" name="desGosMonto"/></td>
											</tr>
											<tr>
												<td><p>Descuento por inauguración de tienda (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="desInPorc" name="desInPorc"/></td>
												<td><p>Descuento por inauguración de tienda (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="desInMonto" name="desInMonto"/></td>
											</tr>
											<tr>
												<td><p>Descuento post venta (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="desPosVentPorc" name="desPosVentPorc"/></td>
												<td><p>Descuento post venta (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="desPosVentMonto" name="desPosVentMonto"/></td>
											</tr>
											<tr>
												<td><p>Descuento por reconocimiento de merma (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="desRecMerPorc" name="desRecMerPorc"/></td>
												<td><p>Descuento por reconocimiento de merma (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="desRecMerMonto" name="desRecMerMonto"/></td>
											</tr>
											<tr>
												<td><p>Descuento por centralización de entregas (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="desCenEntPorc" name="desCenEntPorc"/></td>
												<td><p>Descuento por centralización de entregas (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="desCentEntMonto" name="desCentEntMonto"/></td>
											</tr>
											<tr>
												<td><p>Descuento por Volumen fijo (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="desVolFijoPorc" name="desVolFijoPorc"/></td>
												<td><p>Descuento por Volumen fijo (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="desVolFijoMonto" name="desVolFijoMonto"/></td>
											</tr>
											<tr>
												<td><p>Primer descuento por Volumen Variable Desde:</p></td>
												<td><input class="inputform2" type="text" value="" id="priDesVolVarDes" name="priDesVolVarDes"/></td>
												<td><p>Primer descuento por Volumen Variable Hasta:</p></td>
												<td><input class="inputform2" type="text" value="" id="priDesVolVarHasta" name="priDesVolVarHasta"/></td>
											</tr>
											<tr>
												<td><p>Primer descuento por Volumen Variable (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="priDesVolVarPorc" name="priDesVolVarPorc"/></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td><p>Segundo descuento por Volumen Variable Desde:</p></td>
												<td><input class="inputform2" type="text" value="" id="segDesVolVarDes" name="segDesVolVarDes"/></td>
												<td><p>Segundo descuento por Volumen Variable Hasta:</p></td>
												<td><input class="inputform2" type="text" value="" id="segDesVolVarHasta" name="segDesVolVarHasta"/></td>
											</tr>
											<tr>
												<td><p>Segundo descuento por Volumen Variable (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="segDesVolVarPorc" name="segDesVolVarPorc"/></td>
												<td></td>
												<td></td>
											</tr>
											<tr>
												<td><p>Aporte a Publicidad (porcentaje):</p></td>
												<td><input class="inputform2" type="text" value="" id="aporPubPorc" name="aporPubPorc"/></td>
												<td><p>Aporte a Publicidad (monto):</p></td>
												<td><input class="inputform2" type="text" value="" id="aporPubMonto" name="aporPubMonto"/></td>
											</tr>
											<tr>
												<td><p>Moneda:</p></td>
												<td><input class="inputform2" type="text" value="" id="moneda"name="moneda"/></td>
												<td><p>Estado:</p></td>
												<td><select size="1" class="combo2" id="estado"> 
														<option value="">Seleccione</option>
														<option value="Vigente">Vigente</option>
														<option value="Vencido">Vencido</option>
														<option value="Borrador">Borrador</option> 
													</select></td>
											</tr>
											<tr>
												<td colspan="4"><p>Descargar Acuerdo Comercial:  <button name="descargar" id="descargar">Descargar ahora</button></p>
												</td>
											</tr>
											<tr>
												<td colspan="4"><button id="btnenviar2" type="submit" value="Enviar">Enviar</button></td>
											</tr>											
										</table>
								</div>
							</li>
							<li id="Four"><a href="#Four" id="fou"><spring:message code="label.paymentDetails"/></a>
								<div>
										<table id="registro2">
											<tr>
												<td><p>Condici&oacute;n de pago:</p></td>
												<td><select size="1" class="combo2" id="condicionPago"> 
														<option value="">Seleccione</option>
														<option value="30 Dias">30 D&iacute;as</option>
														<option value="60 Dias">60 D&iacute;as</option>
														<option value="90 Dias">90 D&iacute;as</option> 
													</select> 
												</td>
												<td><p>Forma de pago:</p></td>
												<td><select size="1" class="combo2" id="formaPago"> 
														<option value="">Seleccione</option>
														<option value="transferencia">Transferencia</option>
														<option value="cheque">Cheque</option>
													</select> 
												</td>
											</tr>
											<tr>
												<td><p>Banco:</p></td>
												<td colspan="2"><input class="inputform3" id="banco" type="text" value="" name="banco"/></td>
											</tr>
											<tr>
												<td><p>Número de Cuenta:</p></td>
												<td colspan="2"><input class="inputform3" type="text" value="" id="numeroCuenta" name="numeroCuenta"/></td>
											</tr>
											<tr>
												<td colspan="4"><button id="btnenviar2" type="submit" value="Enviar">Enviar</button></td>
											</tr>											
										</table>
								</div>
							</li>
							<li id="Five"><a href="#Five" id="fiv"><spring:message code="label.otherInformation"/></a>
								<div>
										<table id="registro2">
											<tr>
												<td><p>Direcci&oacute;n:</p></td>
												<td id="text" rowspan="2"><textarea id="inputarea2" rows="2" id="direccion" name="direccion"></textarea></td>
												<td><p>Actividad Económica:</p></td>
												<td><input class="inputform2" type="text" value="" id="actividadEconomica" name="actividadEconomica"/></td>
											</tr>
											<tr>
												<td></td>
											</tr>
											<tr>
												<td><p>Fax:</p></td>
												<td><input class="inputform2" type="text" value="" id="fax" name="fax"/></td>
												<td><p>Tipo de Persona:</p></td>
												<td><select size="1" class="combo2" id="tipoPersona"> 
														<option value="">Seleccione</option>
														<option value="link pagina 2">opcion2</option>
														<option value="link pagina 3">opcion3</option>
														<option value="link pagina 4">opcion4</option> 
													</select> 
												</td>
											</tr>
											<tr>
												<td><p>Número de Registro Mercantil:</p></td>
												<td><input class="inputform2" type="text" value="" id="numRegMerc" name="numRegMerc"/></td>
												<td><p>Fecha de Registro Mercantil:</p></td>
												<td><input class="inputform2" type="text" value="" id="fechaRegMerc"name="fechaRegMerc"/></td>
											</tr>
											<tr>
												<td><p>Tomo:</p></td>
												<td><input class="inputform2" type="text" value="" id="tomo" name="tomo"/></td>
												
											</tr>
											<tr>
												<td colspan="4"><button id="btnenviar2" type="submit" value="Enviar">Enviar</button></td>
											</tr>			
										</table>
								</div>
							</li>
							<li id="Six"><a href="#Six" id="sth">Archivos Adjuntos</a>
								<div>
									<table id="tabadjuntos">
										<tr>
											<td><p>Documento de identificaci&oacute;n fiscal: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Registro mercantil: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Copia de documento de identificaci&oacute;n de representante legal: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Copia de factura comercial: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Certificaci&oacute;n bancaria: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p> Acuerdo comercial firmado: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Registro marca comercial o contrato de licencia exclusiva: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Formato de marcas propias: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td><p>Registro de SENCAMER: </p>
											</td>
											<td><input type="file" name="nombre"/>
											</td>
										</tr>
										<tr>
											<td colspan="4"><button id="btnenviar2" type="submit" value="Enviar">Enviar</button></td>
										</tr>
										
									</table>
								</div>
							</li>
						</ul>
						
										
			</form:form>	
			
				</div>
				
			
		</div>	
			
	</div>
	
	<div id="footer">
		<p>Copyright 2014 AMAND/BECO/CAPUY All Rights Reserved. | Design by <a target="_blank">Sistemas</a></p>
	</div>
</div>
</body>
</html>
