<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link rel="stylesheet" type="text/css" href="styles/style_accordion.css"/>
<link rel="stylesheet" type="text/css" href="styles/style_tabs.css"/>
<title>Portal de Proveedores</title>
<style type="text/css" media="all">
	@import "resources/styles/global.css";
	@import "resources/styles/style_accordion.css";
	@import "resources/styles/style_tabs.css";
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
	<div id="bodyboxnm">
		
		<div class="ic"></div>	
		<div id="content">
		
			<%

			   //podemos leer los datos del request a una variable
			   //String edad=(String)request.getParameter("edad");
			   //String prefieres=(String)request.getParameter("preferencia");
			   out.print("tu nombre es "+request.getParameter("nombre")+" rif: "+request.getParameter("rif"));
			   out.print("<br/>");
			   //out.print("procedencia "+request.getParameter("procedencia"));
			   //out.print("<br/>");
			   out.print("tu procedencia es "+request.getParameter("procedencia"));
			   out.print("<br/>");
			   //out.print("y prefieres el(a) "+prefieres+" de un proyecto");
			   out.print("<br/>");
			   //podemos usar los datos directamente desde el request
			   out.print("Bienvenido a jsp "+ request.getParameter("nombre").toString().toUpperCase());
			   
			 %> 
			
		</div>	
			<a href="/portalproveedores/">Inicio Portal</a>
	</div>
	<div id="footer">
		<p>Copyright 2014 AMAND/BECO/CAPUY All Rights Reserved. | Design by <a target="_blank">Sistemas</a></p>
	</div>
</div>
</body>
</html>
