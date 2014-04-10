//enviar por POST el formulario
 function redireccionar(){
   f=document.getElementById('realizar-busqueda-form');
	 if(f){
	   f.submit();
	 }
  }
  
  //cambiar el texto del boton de buscar, para que aparezca Buscando cuando este haciendo la consulta
 function cambiar_texto(id,mensaje){
	   document.getElementById(id).value = mensaje;
	   
	  }
 
  //funcion para validor que solo coloquen numeros en los campos numericos (mes, año)
 function acceptNum(evt){	
		var nav4 = window.Event ? true : false;
		// NOTE: Backspace = 8, Enter = 13, '0' = 48, '9' = 57	
		var key = nav4 ? evt.which : evt.keyCode;	
		return ((key <= 13) || (key >= 48 && key <= 57));
	}
 
//funcion para que exporta la tabla HTML a excel cuando presionen el ENTER
function importarExcel(evt,table, name){
	var nav4 = window.Event ? true : false;
	
	var key = nav4 ? evt.which : evt.keyCode;
	
	//Enter = 13
	
	//si presiona el enter llamar al metodo que se encarga exportar la tabla
	 if (key == 13){
		 tableToExcel (table, name);
		 return false;
	 }
  return true;
}
 
//funcion para validar el formulario de registro voluntario
 function validateSolicitude(){
	 msg = "";
	 
	 //si no se introduce el nombre
	 var nombre = document.getElementById("nombre").value;
	 if( nombre == null || nombre.length == 0 || /^\s+$/.test(nombre) ) {
	 	 msg += "Introduzca el nombre del proveedor.\n";
	 }
	 
	 //si no se introduce el rif
	 var rif = document.getElementById("rif").value;
	 if( rif == null || rif.length == 0 || /^\s+$/.test(rif) ) {
	 	 msg += "Introduzca el rif del proveedor.\n";
	 }
	 
	 //si no se introduce la persona de contacto
	 var pdc = document.getElementById("personaDeContacto").value;
	 if( pdc == null || pdc.length == 0 || /^\s+$/.test(pdc) ) {
	 	 msg += "Introduzca una persona de contacto.\n";
	 }
	 
	 //si no se selecciona un país
	 var pais = document.getElementById("pais").selectedIndex;
	 if( pais == null || pais == "" ) {
	 	 //msg += "Seleccione un País\n";
	 }
	 
	 var telefono = document.getElementById("telefono").value;
	 if( telefono == null || telefono == "" ) {
	 	 msg += "Introduzca un numero de teléfono\n";
	 }
	 
	 var correo = document.getElementById("correo").value;
	 if( !(/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)/.test(correo)) ) {
		 //msg += "Introduzca una dirección de correo electrónico válida\n";
	 }
	 
	 //si ocurrio algun error
	 if(msg != "") {
		 //envia un mensaje de error, con los errores ocurridos
	 	alert("Se han producido los siguientes errores:\n\n" + msg);
	 	return false;
	}
	 
	 //llamar al metodo de cambiar el texto del boton en caso de que no haya ocurrido algun error
	 //cambiar_texto('btn-consulta','Buscando...');
}

//Validar Prospecto desde formulario de registro
function validateFormRegistry(){
	 msg = "";
	 
	 //si no se introduce el nombre comercial
	 var nombrecomercial = document.getElementById("nombreComercial").value;
	 if( nombrecomercial == null || nombrecomercial.length == 0 || /^\s+$/.test(nombrecomercial) ) {
	 	 msg += "Introduzca el nombre comercial del proveedor.\n";
	 }
	 
	 //si no se selecciona un país
	 var pais = document.getElementById("pais").selectedIndex;
	 if( pais == null || pais == "" ) {
	 	 //msg += "Seleccione un País\n";
	 }
	 
	 var telefono = document.getElementById("telefono").value;
	 if( telefono == null || telefono == "" ) {
	 	 msg += "Introduzca un numero de teléfono\n";
	 }
	 
	 var correo = document.getElementById("correo").value;
	 if( !(/\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)/.test(correo)) ) {
		// msg += "Introduzca una dirección de correo electrónico válida\n";
	 }
	 
	 var procedencia = document.getElementById("procedencia").value;
	 if( procedencia == null || procedencia.length == 0 || /^\s+$/.test(procedencia) ) {
	 	 msg += "Introduzca la procedencia.\n";
	 }
	 
	 var detalleProcedencia = document.getElementById("detalleProcedencia").value;
	 if( detalleProcedencia == null || detalleProcedencia.length == 0 || /^\s+$/.test(detalleProcedencia) ) {
	 	 //msg += "Introduzca el detalle de la procedencia.\n";
	 }
	 
	 //si ocurrio algun error
	 if(msg != "") {
		 //envia un mensaje de error, con los errores ocurridos
	 	alert("Se han producido los siguientes errores:\n\n" + msg);
	 	return false;
	}
	 
	 //llamar al metodo de cambiar el texto del boton en caso de que no haya ocurrido algun error
	 //cambiar_texto('btn-consulta','Buscando...');
} 
 
//transformar una tabla de html a un excel
 var tableToExcel = (function () {
	    var uri = 'data:application/vnd.ms-excel;base64,',
	        template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
	        base64 = function (s) {
	            return window.btoa(unescape(encodeURIComponent(s)));
	        }, format = function (s, c) {
	            return s.replace(/{(\w+)}/g, function (m, p) {
	                return c[p];
	            });
	        };
	    
	      //funcion para poder obtener la tabla de la interfaz e importarlo a un excel
	      return function (table, name) {
	    	 var msg = "";
	    	 if (document.getElementById('text-export').value == '')
	    	   msg = "Introduzca el nombre del archivo.";
	    	 else {
	    		 if (!table.nodeType) 
	            	table = document.getElementById(table);
	    		
	    		//obtener la tabla de la interfaz
	    		 var html = table.outerHTML;
	            
	    		 //cambiar los caracteres especiales por su forma en el formato UTF-8
	            while (html.indexOf('á') != -1) html = html.replace('á', '&aacute;');
	            while (html.indexOf('é') != -1) html = html.replace('é', '&eacute;');
	            while (html.indexOf('í') != -1) html = html.replace('í', '&iacute;');
	            while (html.indexOf('ó') != -1) html = html.replace('ó', '&oacute;');
	            while (html.indexOf('ú') != -1) html = html.replace('ú', '&uacute;');
	            while (html.indexOf('º') != -1) html = html.replace('º', '&ordm;');
	            
	            var ctx = { worksheet: name || 'Worksheet', table : html};
	            
	            document.getElementById("dlink").href = uri + base64(format(template, ctx));
	            //agarrar el nombre del text field de la interfaz y asignarlo como nombre
	            document.getElementById("dlink").download = document.getElementById('text-export').value+".xls";
	            document.getElementById("dlink").click();
	      }
	      
	    //si hubo un error, manda un mensaje de advertencia
	      if (msg != "")
	    	alert("Se han producido los siguientes errores:\n\n" + msg);
			return false;
	     };

	})(); 
 
/*funcion para repintar el boton de guardado en la pantalla de configuracion
 * le setea las clases "btn" y "btn-danger" para poder pintar el boton
 * de color rojo cuando se presione una tecla
 */
function repintar(){
    document.getElementById('btn-guardar').className = "btn btn-danger";
}

/*
 * 
 */
function aumentar(cantidad,aumento){	
	aumento = parseFloat(aumento) + parseFloat(cantidad);

	document.getElementById('barra').style.width = aumento+"%";
	
	 if (aumento <= 99){
		 document.getElementById("text-barra").innerHTML = aumento.toFixed()+"%";
       return setTimeout("aumentar("+cantidad+","+aumento+")",1000);
	 }
	 else{
		 document.getElementById("text-barra").innerHTML = "99%";
	   return 0;
	 }
}

function processData(csv) {
    var allTextLines = csv.split(/\r\n|\n/);
    var cantidad = (100/((140*allTextLines.length)/49000));
    cantidad = cantidad.toFixed(2);
    aumentar (cantidad,0);
}

function loadHandler(event) {
    var csv = event.target.result;
    processData(csv);
  }


function getAsText(fileToRead) {
    var reader = new FileReader();
    // Read file into memory as UTF-8      
    reader.readAsText(fileToRead);
    // Handle errors load
    reader.onload = loadHandler;
  }
  
function handleFiles() {
	 document.getElementById("mensaje").innerHTML = " ";
	files = document.getElementById('csvFileInput').files;
	archivo = document.getElementById('csvFileInput').value;
	extension = (archivo.substring(archivo.lastIndexOf("."))).toLowerCase();
    // Check for the various File API support.
    if (window.FileReader) {
        // FileReader are supported.
       if (extension == '.csv')
        getAsText(files[0]);
    } else {
        alert('La carga de archivo no esta soportada en este explorador.');
    }
  }

function cargar(formulario){
	files = document.getElementById('csvFileInput').value;
	extension = (files.substring(files.lastIndexOf("."))).toLowerCase();
	
  if (extension == '.csv'){
	document.getElementById(formulario).action = "http://localhost:8080/cargarpresupuesto.html";
	document.getElementById(formulario).enctype = "multipart/form-data";
	document.getElementById('div-barra').className="progress progress-striped active";
	   f=document.getElementById(formulario);
		 if(f){
		   f.submit();
		 }
  }
  else{
    alert ("Solo se permiten archivos .csv");
	return 0;
  }
}
  
 function guardarCambios(elm){
	 document.getElementById(elm.id).name = elm.id;
	 document.getElementById(elm.id).value = "Guardando...";
	 document.getElementById('realizar-busqueda-form').action = "http://localhost:8080/modificarpresupuesto.html";
	 f=document.getElementById('realizar-busqueda-form');
	  if(f){
		f.submit();
	 }
  }
