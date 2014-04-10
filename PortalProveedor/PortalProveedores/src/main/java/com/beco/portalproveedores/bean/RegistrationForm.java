package com.beco.portalproveedores.bean;

import java.util.ArrayList;

public class RegistrationForm {
	
	public String commercialName;
	public String fiscalName;
	public String rif;
	public String rifExpirationDate;
	public String email;
	public String country;
	public String contactPerson;
	public String origin;
	public String originDetails;
	public String observation;
	public String phone;
	public String phone2;
	public String website;
	public String status;
	public String statusDetails;
	public String assets;
	public String products;
	public String services;
	public String category;
	public String department;
	public String line;
	public String section;
	public String approvedFinance;
	public String approvedBoss;
	ArrayList<String> countryList = new ArrayList<String>();
	ArrayList<String> originList = new ArrayList<String>();
	ArrayList<String> categoryList = new ArrayList<String>();
	ArrayList<String> departmentList = new ArrayList<String>();
	ArrayList<String> lineList = new ArrayList<String>();
	ArrayList<String> sectionList = new ArrayList<String>();
	ArrayList<String> selectedCategoryList = new ArrayList<String>();
	ArrayList<String> selectedDepartmentList = new ArrayList<String>();
	ArrayList<String> selectedLineList = new ArrayList<String>();
	ArrayList<String> selectedSectionList = new ArrayList<String>();	
	
	/**
	 * Default
	 */
	public RegistrationForm(){
		
	}

	public RegistrationForm(String commercialName, String fiscalName,
			String rif, String rifExpirationDate, String email, String country,
			String contactPerson, String origin, String originDetails,
			String observation, String phone, String phone2, String website,
			String status, String statusDetails, String assets,
			String products, String services, String category,
			String department, String line, String section,
			String approvedFinance, String approvedBoss,
			ArrayList<String> countryList, ArrayList<String> originList,
			ArrayList<String> categoryList, ArrayList<String> departmentList,
			ArrayList<String> lineList, ArrayList<String> sectionList,
			ArrayList<String> selectedCategoryList,
			ArrayList<String> selectedDepartmentList,
			ArrayList<String> selectedLineList,
			ArrayList<String> selectedSectionList) {
		super();
		this.commercialName = commercialName;
		this.fiscalName = fiscalName;
		this.rif = rif;
		this.rifExpirationDate = rifExpirationDate;
		this.email = email;
		this.country = country;
		this.contactPerson = contactPerson;
		this.origin = origin;
		this.originDetails = originDetails;
		this.observation = observation;
		this.phone = phone;
		this.phone2 = phone2;
		this.website = website;
		this.status = status;
		this.statusDetails = statusDetails;
		this.assets = assets;
		this.products = products;
		this.services = services;
		this.category = category;
		this.department = department;
		this.line = line;
		this.section = section;
		this.approvedFinance = approvedFinance;
		this.approvedBoss = approvedBoss;
		this.countryList = countryList;
		this.originList = originList;
		this.categoryList = categoryList;
		this.departmentList = departmentList;
		this.lineList = lineList;
		this.sectionList = sectionList;
		this.selectedCategoryList = selectedCategoryList;
		this.selectedDepartmentList = selectedDepartmentList;
		this.selectedLineList = selectedLineList;
		this.selectedSectionList = selectedSectionList;
	}

	public String getCommercialName() {
		return commercialName;
	}

	public void setCommercialName(String commercialName) {
		this.commercialName = commercialName;
	}

	public String getFiscalName() {
		return fiscalName;
	}

	public void setFiscalName(String fiscalName) {
		this.fiscalName = fiscalName;
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}

	public String getRifExpirationDate() {
		return rifExpirationDate;
	}

	public void setRifExpirationDate(String rifExpirationDate) {
		this.rifExpirationDate = rifExpirationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOriginDetails() {
		return originDetails;
	}

	public void setOriginDetails(String originDetails) {
		this.originDetails = originDetails;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(String statusDetails) {
		this.statusDetails = statusDetails;
	}

	public String getAssets() {
		return assets;
	}

	public void setAssets(String assets) {
		this.assets = assets;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public String getServices() {
		return services;
	}

	public void setServices(String services) {
		this.services = services;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getApprovedFinance() {
		return approvedFinance;
	}

	public void setApprovedFinance(String approvedFinance) {
		this.approvedFinance = approvedFinance;
	}

	public String getApprovedBoss() {
		return approvedBoss;
	}

	public void setApprovedBoss(String approvedBoss) {
		this.approvedBoss = approvedBoss;
	}

	public ArrayList<String> getCountryList() {
		return countryList;
	}

	public void setCountryList(ArrayList<String> countryList) {
		this.countryList = countryList;
	}

	public ArrayList<String> getOriginList() {
		return originList;
	}

	public void setOriginList(ArrayList<String> originList) {
		this.originList = originList;
	}

	public ArrayList<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}

	public ArrayList<String> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(ArrayList<String> departmentList) {
		this.departmentList = departmentList;
	}

	public ArrayList<String> getLineList() {
		return lineList;
	}

	public void setLineList(ArrayList<String> lineList) {
		this.lineList = lineList;
	}

	public ArrayList<String> getSectionList() {
		return sectionList;
	}

	public void setSectionList(ArrayList<String> sectionList) {
		this.sectionList = sectionList;
	}

	public ArrayList<String> getSelectedCategoryList() {
		return selectedCategoryList;
	}

	public void setSelectedCategoryList(ArrayList<String> selectedCategoryList) {
		this.selectedCategoryList = selectedCategoryList;
	}

	public ArrayList<String> getSelectedDepartmentList() {
		return selectedDepartmentList;
	}

	public void setSelectedDepartmentList(ArrayList<String> selectedDepartmentList) {
		this.selectedDepartmentList = selectedDepartmentList;
	}

	public ArrayList<String> getSelectedLineList() {
		return selectedLineList;
	}

	public void setSelectedLineList(ArrayList<String> selectedLineList) {
		this.selectedLineList = selectedLineList;
	}

	public ArrayList<String> getSelectedSectionList() {
		return selectedSectionList;
	}

	public void setSelectedSectionList(ArrayList<String> selectedSectionList) {
		this.selectedSectionList = selectedSectionList;
	}
	
	
}
