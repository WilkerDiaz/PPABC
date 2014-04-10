<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="styles/style_accordion.css">
<title>Portal de Proveedores</title>
<style type="text/css" media="all">
	@import "resources/styles/global.css";
	@import "resources/styles/style_accordion.css";
</style>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<div id="logobox">
			<h1>Portal de Proveedores</h1>
			<h2>AMAND - BECO - CAPUY</h2>
		</div>
		<div id="headimg">&nbsp;</div>
	</div>
	<div id="topnavi">
		<div class="spacing1">
			<ul>
				
			</ul>
		</div>
	</div>
	<div id="bodybox">
		<%@include file="includes/menu.jsp" %>
		<div class="ic"></div>	
		<div id="content">
			<h1>B&uacute;squeda Avanzada</h1>
			<div id="filtros">
				<form method="post">
					<div id="filtro">
						<div id="lblfiltro">
							<p>Estado:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">Prospecto</OPTION>
								<OPTION VALUE="link pagina 3">Pre-Aprobado</OPTION>
								<OPTION VALUE="link pagina 4">Autorizado Registro</OPTION>
								<OPTION VALUE="link pagina 4">Por Aprobar Control</OPTION> 
								<OPTION VALUE="link pagina 4">Registrado</OPTION>
								<OPTION VALUE="link pagina 4">Inactivo</OPTION>
								<OPTION VALUE="link pagina 4">Negociación No Concretada</OPTION>  
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>Bienes/Prod/Serv:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">Bienes</OPTION>
								<OPTION VALUE="link pagina 3">Productos</OPTION>
								<OPTION VALUE="link pagina 4">Servicios</OPTION> 
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>Nacional / Int:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">Nacional</OPTION>
								<OPTION VALUE="link pagina 3">Internacional</OPTION>
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>Pa&iacute;s:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">opcion2</OPTION>
								<OPTION VALUE="link pagina 3">opcion3</OPTION>
								<OPTION VALUE="link pagina 4">opcion4</OPTION> 
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>Tipo:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">Estrat&eacute;gico</OPTION>
								<OPTION VALUE="link pagina 3">Clave</OPTION>
								<OPTION VALUE="link pagina 4">Regular</OPTION> 
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>Categoría:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">opcion2</OPTION>
								<OPTION VALUE="link pagina 3">opcion3</OPTION>
								<OPTION VALUE="link pagina 4">opcion4</OPTION> 
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>Departamento:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">opcion2</OPTION>
								<OPTION VALUE="link pagina 3">opcion3</OPTION>
								<OPTION VALUE="link pagina 4">opcion4</OPTION> 
							</SELECT> 
						</div>
					</div>
					<div id="filtro">
						<div id="lblfiltro">
							<p>L&iacute;nea:</p>
						</div>
						<div id="filtro">
							<SELECT SIZE=1 class="combo" onChange="javascript:alert('prueba');"> 
								<OPTION VALUE="link pagina 1">Seleccione</OPTION>
								<OPTION VALUE="link pagina 2">opcion2</OPTION>
								<OPTION VALUE="link pagina 3">opcion3</OPTION>
								<OPTION VALUE="link pagina 4">opcion4</OPTION> 
							</SELECT> 
						</div>
					</div>
					<div id="boton">

							<button id="btnbuscar2">Buscar</button>
						
					</div>
				</form>
			</div>
			
			
			
	</div>
	<div id="footer">
		<p>Copyright 2014 AMAND/BECO/CAPUY All Rights Reserved. | Design by <a target="_blank">Sistemas</a></p>
	</div>
</div>
</body>
</html>
