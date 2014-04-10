<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

	
	
	
	<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    
    
    
    <script src="resources/js/bootstrap-multiselect.js"></script> 
	
	
	
	<script type="text/javascript" src="resources/js/bootstrap-multiselect.js"></script>

	<title>Portal de Proveedores</title>
	<style type="text/css" media="all">
		@import "resources/styles/bootstrap.css";
		@import "resources/styles/bootstrap-multiselect.css";
	</style>

</head>
<body>
	<!-- Build your select: -->
	<select class="multiselect" multiple="multiple">
	  <option value="cheese">Cheese</option>
	  <option value="tomatoes">Tomatoes</option>
	  <option value="mozarella">Mozzarella</option>
	  <option value="mushrooms">Mushrooms</option>
	  <option value="pepperoni">Pepperoni</option>
	  <option value="onions">Onions</option>
	</select>
	 
	<!-- Initialize the plugin: -->
	<script type="text/javascript">
	  $(document).ready(function() {
	    $('.multiselect').multiselect();
	  });
	</script>
</body>
</html>