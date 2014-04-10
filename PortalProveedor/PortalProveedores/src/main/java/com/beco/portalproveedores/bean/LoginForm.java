package com.beco.portalproveedores.bean;

import java.util.ArrayList;

public class LoginForm {

	public String user;
	public String password;
	public String language;
	private ArrayList<String> languageList;
	
	/**
	 * Default
	 */
	public LoginForm(){
		
	}
	
	/**
	 * Constructor
	 * @param user username del usuario a logearse
	 * @param password contraseña del usuario
	 * @param language idioma de preferencia del usuario
	 * @param languageList listado de idiomas disponibles
	 */
	public LoginForm(String user, String password, String language,
			ArrayList<String> languageList) {
		super();
		this.user = user;
		this.password = password;
		this.language = language;
		this.languageList = languageList;
	}
	
	
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ArrayList<String> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(ArrayList<String> languageList) {
		this.languageList = languageList;
	}
}
