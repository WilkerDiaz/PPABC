package com.beco.portalproveedores.bean;

public class BasicSearchForm {
	
	public String isProspect;
	public String department;
	public String name;
	public String prodServ;
	
	/**
	 * Default
	 */
	public BasicSearchForm(){
		
	}
	
	/**
	 * Constructor
	 * @param isProspect checkbox para saber si se busca un prospecto o un proveedor registrado
	 * @param department  departamento asociado a la busqueda
	 * @param name name del proveedor buscado
	 * @param prodServ indica si el proveedor es de bienes, productos o servicios
	 */
	public BasicSearchForm(String isProspect, String department, String name,
			String prodServ) {
		super();
		this.isProspect = isProspect;
		this.department = department;
		this.name = name;
		this.prodServ = prodServ;
	}
	
	public String getIsProspect() {
		return isProspect;
	}
	public void setIsProspect(String isProspect) {
		this.isProspect = isProspect;
	}
	public String getDepartament() {
		return department;
	}
	public void setDepartament(String department) {
		this.department = department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getprodServ() {
		return prodServ;
	}
	public void setprodServ(String prodServ) {
		this.prodServ = prodServ;
	}
}
