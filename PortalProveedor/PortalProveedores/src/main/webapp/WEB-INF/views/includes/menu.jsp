<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div id="accordion">
	<ul class="ac-menu">
		<li id="one">
			<a href="/portalproveedores/index?page=1"><spring:message code="label.home"/></a>
		</li>				
		<li id="two">
			<a href="#two"><spring:message code="label.topSupliers"/></a>
			<ul class="sub-menu">						
				<li><a href="registro.html?supplier=null#One"><spring:message code="label.register"/></a></li>					
				<li><a href="proveedores"><spring:message code="label.view"/></a></li>
				<li><a href="#one"><spring:message code="label.accountstatus"/></a></li>
				<li><a href="#one"><spring:message code="label.import"/></a></li>
			</ul>
		</li>				
		<li id="three">
			<a href="#three"><spring:message code="label.purchaseOrders"/></a>
			<ul class="sub-menu">						
				<li><a href="#three"><spring:message code="label.register"/></a></li>						
				<li><a href="#three"><spring:message code="label.view"/></a></li>
				<li><a href="#three"><spring:message code="label.import"/></a></li>
				<li><a href="#one"><spring:message code="label.invoicing"/></a></li>
			</ul>
		</li>				
		<li id="four">
			<a href="#four"><spring:message code="label.inventories"/></a>
			<ul class="sub-menu">					
				<li><a href="#three">Inner One</a></li>						
				<li><a href="#three">Inner Two</a></li>
				<li><a href="#three">Inner Three</a></li>
			</ul>
		</li>
		<li id="five">
			<a href="#five"><spring:message code="label.documentsOfInterest"/></a>
			<ul class="sub-menu">					
				<li><a href="#three">Inner One</a></li>						
				<li><a href="#three">Inner Two</a></li>
				<li><a href="#three">Inner Three</a></li>
			</ul>
		</li>	
		<li id="six">
			<a href="#six"><spring:message code="label.claims"/></a>
			<ul class="sub-menu">					
				<li><a href="#three">Inner One</a></li>						
				<li><a href="#three">Inner Two</a></li>
				<li><a href="#three">Inner Three</a></li>
			</ul>
		</li>	
		<li id="seven">
			<a href="#seven"><spring:message code="label.franchiseOrders"/></a>
			<ul class="sub-menu">					
				<li><a href="#three">Inner One</a></li>						
				<li><a href="#three">Inner Two</a></li>
				<li><a href="#three">Inner Three</a></li>
			</ul>
		</li>	
		<li id="eight">
			<a href="#eight"><spring:message code="label.evaluation"/></a>
			<ul class="sub-menu">					
				<li><a href="#three">Inner One</a></li>
				<li><a href="#three">Inner Two</a></li>
				<li><a href="#three">Inner Three</a></li>
			</ul>
		</li>	
	</ul>
	<a href="postulation.html#One">Registro b&aacute;sico</a>

	 
	
	
</div>