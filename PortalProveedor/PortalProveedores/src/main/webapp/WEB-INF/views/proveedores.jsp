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
			<h1>Proveedores</h1>
			<div id="filtros">
				<form>
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
							<p>Bienes/Prod/Serv:</p>
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
							<p>Nacional / Ext:</p>
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
							<p>Nombre:</p>
						</div>
						<div id="filtro">
							<input id="buscarnombre" type="search" name="nombre"> 
						</div>
					</div>
					<div id="boton">
							<button action="busquedaavanzada" id="btnbusquedaav">B&uacute;squeda Avanzada</button>
					</div>
					<div id="boton">

							<button id="btnbuscar">Buscar</button>
						
					</div>
				</form>
			</div>
			
			<div class="datagrid">
				<table>
					<thead>
						<tr>
							<th>Proveedor</th><th>Pa&iacute;s</th><th>Tipo</th><th>Evaluaci&oacute;n</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td colspan="4">
								<div id="paging">
									<ul>
										<li><a href="#"><span>Previous</span></a></li>
										<li><a href="#" class="active"><span>1</span></a></li>
										<li><a href="#"><span>2</span></a></li>
										<li><a href="#"><span>3</span></a></li>
										<li><a href="#"><span>4</span></a></li>
										<li><a href="#"><span>5</span></a></li>
										<li><a href="#"><span>Next</span></a></li>
									</ul>
								</div>
							</td>
						</tr>
					</tfoot>
					<tbody>
						<tr>
							<td><a href="registro.html#One">Proveedor 1</a></td>
							<td>Venezuela</td>
							<td>Estrat&eacute;gico</td>
							<td>94%</td>
						</tr>
						<tr class="alt">
							<td><a href="registro.html#One">Proveedor 2</a></td>
							<td>Colombia</td>
							<td>Clave</td>
							<td>86%</td>
						</tr>
						<tr>
							<td><a href="registro.html#One">Proveedor 3</a></td>
							<td>China</td>
							<td>Regular</td>
							<td>82%</td>
						</tr>
						<tr class="alt">
							<td><a href="registro.html#One">Proveedor 4</a></td>
							<td>USA</td>
							<td>Estrat&eacute;gico</td>
							<td>79%</td>
						</tr>
						<tr>
							<td><a href="registro.html#One">Proveedor 5</a></td>
							<td>Venezuela</td>
							<td>Clave</td>
							<td>78%</td>
						</tr>
					</tbody>
				</table>
			</div>
			
	</div>
	<div id="footer">
		<p>Copyright 2014 AMAND/BECO/CAPUY All Rights Reserved. | Design by <a target="_blank">Sistemas</a></p>
	</div>
</div>
</body>
</html>
