package com.beco.portalproveedores.controller;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.beco.consumoservicio.HoraServidorProxy;
import com.beco.portalproveedores.bean.*;
import com.beco.portalproveedores.model.HibernateHelper;
import com.beco.portalproveedores.model.HibernateUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	static String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";*/
		
		
		System.out.println("Este es el Main");
		
		HoraServidorProxy hsp = new HoraServidorProxy();
		
		try {
			String a = hsp.responderHora("hola");
			System.out.println("Soy el Cliente, La hora del Servidor es: " +a);
			
			model.addAttribute("serverTime", a);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
		
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		try {
		
		System.out.println("Este es el Main");
		HibernateHelper HH = new HibernateHelper();
		
		Prospect proveedor = new Prospect();
		proveedor.setCommercialName("Proveedor1");
		HH.saveProspect(proveedor);
		
		Prospect result =HH.getProspectById(7);
		
		System.out.println("el proveedor es: "+ result.getCommercialName() + " Id = " + result.getProspectId());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error insertando en BD: ");
			e.printStackTrace();
		}
		
		return "home";
		
	}

	/**
	 * Actualiza la configuración local para internacionalización
	 * @param lang Indica el idioma y región usando la nomenclatura ISO
	 * @param request
	 * @param response
	 */
	private void updateLocale(String lang, HttpServletRequest request,
			HttpServletResponse response) {
		//Actualizando locale
		if(lang!=null && !lang.equalsIgnoreCase("")){
			LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
			localeResolver.setLocale(request, response, new Locale(lang.split("_")[0], lang.split("_")[1]));

		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		
		try {
		
		System.out.println("Este es el Main");
		HibernateHelper HH = new HibernateHelper();
		
		Prospect proveedor = new Prospect();
		proveedor = HH.getProspectById(8);
		proveedor.setCommercialName("Proveedor2");
		HH.updateProspect(proveedor);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error insertando en BD: ");
			e.printStackTrace();
		}
		
		return "home";
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		
		
		System.out.println("Este es el Main");
		try {
			
			HibernateHelper HH = new HibernateHelper();
			
			Prospect[] array = HH.getProspectByComName("'Proveedor1'");
			
			System.out.println("la longitud del arreglo es:" + array.length);
			
			for (int i=0;i<array.length;i++){
				
				System.out.println("el proveedor es: "+ array[i].getCommercialName() + " Id = " + array[i].getProspectId());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error leyendo en BD: ");
			e.printStackTrace();
		}
		
		return "home";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		
		
		System.out.println("Este es el Main");
		try {
			
			HibernateHelper HH = new HibernateHelper();
			
			//String aux = HH.deleteProspect(6);
			//System.out.println(aux);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error borrando en BD: ");
			e.printStackTrace();
		}
		
		return "home";
		
	}
	
	
	//#########################################################  INDEX  ###################################################################
	
	@RequestMapping(value = "/index", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView index(@ModelAttribute(value="loginform")LoginForm loginForm, @ModelAttribute(value="basicSearchForm")BasicSearchForm bform, HttpServletRequest request, HttpServletResponse response, @RequestParam("page") String pagina) {
		
		updateLocale(loginForm.getLanguage(), request, response);
		ModelAndView modelAndView = new ModelAndView ("index");
		modelAndView.addObject("page",pagina);
		//BasicSearchForm basicform = new BasicSearchForm();
	
		//basicform=bform;
		HibernateHelper HH = new HibernateHelper();
		ArrayList<Prospect> prospectList = new ArrayList<Prospect>();
		ArrayList<Prospect> prospectList2 = new ArrayList<Prospect>();
		RegistrationForm regForm = new RegistrationForm();
		
		try {
			
			String isProspect = ""+bform.isProspect;
			String departament = ""+bform.department;
			String prodServ = ""+bform.prodServ;
			String name = ""+bform.name;
			
			
			System.out.println("Espropecto: "+isProspect);
			System.out.println("departament: "+departament);
			System.out.println("prodServ: "+prodServ);
			System.out.println("name: "+name);
			System.out.println("brakepoint100");
			if(/*isProspect.equals("YES") &&*/ (name.length()==0 || name.equals("null")) && prodServ.equals("null") && departament.equals("null")){
				
				System.out.println("atributos == null: " + bform.name);
				Prospect[] pArray = HH.getAllProspects();
				System.out.println("lenghtarray: "+pArray.length);
				for (int i = 0;i<pArray.length;i++){
					prospectList.add(pArray[i]);
				}
				
			}else{
				System.out.println("atributos != null: " + bform.name);
				// TODO Buscar Proveedores en Compiere
				Prospect[] pArray = HH.getAllProspects();
				for (int i = 0;i<prospectList.size();i++){
					prospectList.add(pArray[i]);
				}
				System.out.println("atributos != null: " + bform.name);
			
			}
			
			System.out.println("brakepoint99");
			
			int cantreg = 7;
			int intpag = Integer.parseInt(pagina);
			int desde = (intpag-1)*cantreg;
			System.out.println("desde: "+desde);
			System.out.println("intpag: "+intpag);
			System.out.println("cantreg: "+cantreg);
			int hasta = prospectList.size();
			System.out.println("hasta: "+hasta);
			int mod = 0;
			String previous = "/portalproveedores/index?page="+(intpag-1);
			String next = "/portalproveedores/index?page="+(intpag+1);
			String pg1 = ""+1;
			String pg2 = ""+(intpag-1);
			String pg3 = ""+(intpag);
			String pg4 = ""+(intpag+1);
			String pg5 = ""+(prospectList.size()/cantreg);
			String lpg1 = "/portalproveedores/index?page="+1;
			String lpg2 = "/portalproveedores/index?page="+(intpag-1);
			String lpg3 = "/portalproveedores/index?page="+(intpag);
			String lpg4 = "/portalproveedores/index?page="+(intpag+1);
			String lpg5 = "/portalproveedores/index?page="+pg5;
			System.out.println("brakepoint98");
			if ((prospectList.size() % cantreg) > 0){  //si existe una ultima página con menos de catnreg registros
				mod = 1;
				pg5 = ""+((prospectList.size()/cantreg)+1);
				lpg5 = "/portalproveedores/index?page="+pg5;
			}
			
			System.out.println("brakepoint97");
			if((prospectList.size()/cantreg)<=5){  // si hay 5 páginas ó menos
				pg5 = ""+5;
				//TODO color
				pg2 = ""+(2);
				pg3 = ""+(3);
				pg4 = ""+(4);
				pg5 = ""+(5);
				lpg2 = "/portalproveedores/index?page="+(2);
				lpg3 = "/portalproveedores/index?page="+(3);
				lpg4 = "/portalproveedores/index?page="+(4);
				
				if(intpag == 1){     //si estoy en la primera página
					previous = "#";
				}
				
				if ((prospectList.size() - desde)>5){// si no estoy en la ultima página  TODO creo que aquí es cantreg en lugar de 5
					hasta = desde+cantreg;
					if(((prospectList.size()/cantreg)+mod)<5){
						pg5 = "-";
						lpg5 = "#";
						if(((prospectList.size()/cantreg)+mod)<4){
							pg4 = "-";
							lpg4 = "#";
							if(((prospectList.size()/cantreg)+mod)<3){
								pg3 = "-";
								lpg3 = "#";
								if(((prospectList.size()/cantreg)+mod)<2){
									pg2 = "-";
									lpg2 = "#";
								}
							}
						}
					}
	
					
				}else{                        //si estoy en la ultima página
					next = "#";
					//TODO Manejo de ultima pagina
					pg5 = ""+5;
					
					if (intpag < 5){
						pg5 = "-";
						lpg2 = "/portalproveedores/index?page="+(intpag-2);
						lpg3 = "/portalproveedores/index?page="+(intpag-1);
						lpg4 = "/portalproveedores/index?page="+(intpag);
						lpg5 = "#";
						
						if (intpag < 4){
							pg4 = "-";
							lpg2 = "/portalproveedores/index?page="+(intpag-1);
							lpg3 = "/portalproveedores/index?page="+(intpag);
							lpg4 = "#";
							
							if (intpag < 3){
								pg3 = "-";
								lpg2 = "/portalproveedores/index?page="+(intpag-3);
								lpg3 = "#";
							}
							
							if (intpag < 2){
								pg2 = "-";
								lpg2 = "#";
							}
						}
					}
					
				}
			}else{                    // si hay más de 5 páginas
				
				if(intpag == 1){     //si estoy en la primera página
					previous = "#";
					//TODO color
					pg2 = ""+(2);
					pg3 = ""+(3);
					pg4 = ""+(4);
					lpg2 = "/portalproveedores/index?page="+(2);
					lpg3 = "/portalproveedores/index?page="+(3);
					lpg4 = "/portalproveedores/index?page="+(4);
				}
				
				if ((prospectList.size() - desde)>cantreg){// si no estoy en la ultima página
					hasta = desde+cantreg;
					if(prospectList.size() - desde <= (cantreg*2)){  //si estoy en la penultima página
						pg2 = ""+(intpag-2);
						pg3 = ""+(intpag-1);
						pg4 = ""+(intpag);
						lpg2 = "/portalproveedores/index?page="+(intpag-2);
						lpg3 = "/portalproveedores/index?page="+(intpag-1);
						lpg4 = "#";
					}
					
				}else{                        //si estoy en la ultima página
					next = "#";
					//TODO Manejo de ultima pagina
					pg2 = ""+(intpag-3);
					pg3 = ""+(intpag-2);
					pg4 = ""+(intpag-1);
					pg5 = ""+(intpag);
					lpg2 = "/portalproveedores/index?page="+(intpag-3);
					lpg3 = "/portalproveedores/index?page="+(intpag-2);
					lpg4 = "/portalproveedores/index?page="+(intpag-1);
				}
			}
			
			System.out.println("desde: "+desde);
			System.out.println("hasta: "+hasta);
			int j=0;
			for (int i=desde;i<hasta;i++){
				prospectList2.add(prospectList.get(i));
				j++;
				System.out.println("desde: "+desde);
				System.out.println("hasta: "+hasta);
			}
			
			System.out.println("brakepoint96");
			System.out.println("breackpoint 2");
			modelAndView.addObject("previous", previous);
			modelAndView.addObject("next", next);
			modelAndView.addObject("pg1", pg1);
			modelAndView.addObject("pg2", pg2);
			modelAndView.addObject("pg3", pg3);
			modelAndView.addObject("pg4", pg4);
			modelAndView.addObject("pg5", pg5);
			modelAndView.addObject("lpg1", lpg1);
			modelAndView.addObject("lpg2", lpg2);
			modelAndView.addObject("lpg3", lpg3);
			modelAndView.addObject("lpg4", lpg4);
			modelAndView.addObject("lpg5", lpg5);
			modelAndView.addObject("prospectList", prospectList2);
			modelAndView.addObject("par", prospectList2.size()%2);
			modelAndView.addObject("bform", bform);
			modelAndView.addObject("regFrom", regForm);
			System.out.println("brakepoint95");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error: ");
			e.printStackTrace();
		}
		
		return modelAndView;
		
	}
	
	/*@RequestMapping(value = "/?lang=en", method = RequestMethod.GET)
	public String indexen(HttpServletRequest request, HttpServletResponse response) {
		
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString("fr"));
		
		return "index";
		
	}*/
	
	@RequestMapping(value = "/proveedores", method = RequestMethod.GET)
	public String proveedores(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		return "proveedores";
	}
	
	@RequestMapping(value = "/registro.*", method = RequestMethod.GET, params="supplier")
	public @ResponseBody ModelAndView registro(HttpServletRequest request,HttpServletResponse response, @RequestParam("supplier") String proveedor, @ModelAttribute(value="lang")String lang) {
		

		ModelAndView modelAndView = new ModelAndView ("registro");		
		HibernateHelper HH = new HibernateHelper();
		RegistrationForm regForm = new RegistrationForm();
		ArrayList<String> selectedCategoryList = new ArrayList<String>();
		ArrayList<String> categoryList = new ArrayList<String>();
		ArrayList<String> departmentList = new ArrayList<String>();
		ArrayList<String> lineList = new ArrayList<String>();
		ArrayList<String> sectionList = new ArrayList<String>();
		ArrayList<String> countryList = new ArrayList<String>();
		ArrayList<String> originList = new ArrayList<String>();
		ArrayList<String> statusList = new ArrayList<String>();
		
		if(proveedor.equals("null")){
			System.out.println("proveedor nulo "+proveedor);
			
			Country[] countryArray = HH.getAllCountrys();
			Origin[] originArray = HH.getAllOrigins();
			Status[] statusArray = HH.getAllStatus();
			Category[] categoryArray = HH.getAllCategory();
			Department[] departmentArray = HH.getAllDepartment();
			Line[] lineArray = HH.getAllLine();
			Section[] sectionArray = HH.getAllSection();
			Prospect newProspect = new Prospect();
			
			System.out.println("array 0 "+countryArray[0].getCountryName()+"%");
			System.out.println("array 0 "+categoryArray[0].getCategoryName()+"%");
			
			
			
			for(int i=0;i<countryArray.length;i++){
				countryList.add(countryArray[i].getCountryName());
			}
			for(int i=0;i<originArray.length;i++){
				originList.add(originArray[i].getOriginName());
			}
			for(int i=0;i<statusArray.length;i++){
				statusList.add(statusArray[i].getStatusName());
			}
			for(int i=0;i<categoryArray.length;i++){
				categoryList.add(categoryArray[i].getCategoryName());
			}
			
			for(int i=0;i<departmentArray.length;i++){
				departmentList.add(departmentArray[i].getDepartmentName());
			}
			
			for(int i=0;i<lineArray.length;i++){
				lineList.add(lineArray[i].getLineName());
			}
			
			for(int i=0;i<sectionArray.length;i++){
				sectionList.add(sectionArray[i].getSectionName());
			}
			modelAndView.addObject("countriesList", countryList);
			modelAndView.addObject("originList", originList);
			modelAndView.addObject("statusList", statusList);
			modelAndView.addObject("prospecto", newProspect);
			
			regForm.setCategoryList(categoryList);
			regForm.setDepartmentList(departmentList);
			regForm.setLineList(lineList);
			regForm.setSectionList(sectionList);
			regForm.setOriginList(originList);
			regForm.setCountryList(countryList);
			
			System.out.println("categoria "+regForm.getCategoryList().get(0)+"%");
			modelAndView.addObject("regForm", regForm);
			modelAndView.addObject("categoryList", regForm.getCategoryList());
			modelAndView.addObject("departmentList", regForm.getDepartmentList());
			modelAndView.addObject("lineList", regForm.getLineList());
			modelAndView.addObject("sectionList", regForm.getSectionList());
			modelAndView.addObject("SelectedCategoryList", selectedCategoryList);
			modelAndView.addObject("countryList", countryList);
			modelAndView.addObject("originList", originList);
			modelAndView.addObject("statusList", statusList);
			
		}else{
			System.out.println("hola %"+proveedor+"%");
			
			
			Prospect newProspect;
			Prospect[] array = HH.getProspectByComName(proveedor);
			
			System.out.println("array 0 "+array[0].getCommercialName()+"%");
			newProspect = array[0];
			System.out.println("breakpoint reg -2");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("breakpoint reg -1");
			
			System.out.println("breakpoint reg 0");
			regForm.setCommercialName(newProspect.getCommercialName());
			regForm.setFiscalName(newProspect.getFiscalName());
			regForm.setRif(newProspect.getRifCi());
			regForm.setRifExpirationDate(newProspect.getExpirationDateRif());
			regForm.setEmail(newProspect.getEmail());
			regForm.setCountry(newProspect.getCountry());
			regForm.setContactPerson(newProspect.getContactPerson());
			regForm.setOrigin(newProspect.getOrigin());
			regForm.setOriginDetails(newProspect.getOriginDetails());
			regForm.setPhone(newProspect.getPhone());
			regForm.setPhone2(newProspect.getPhone2());
			regForm.setWebsite(newProspect.getWebsite());
			regForm.setObservation(newProspect.getObservation());
			regForm.setStatus(newProspect.getStatus());
			regForm.setStatusDetails(newProspect.getStatusDetails());
			regForm.setAssets(newProspect.getAssets());
			regForm.setProducts(newProspect.getProducts());
			regForm.setServices(newProspect.getServices());
			regForm.setApprovedFinance(newProspect.getApprovedFinance());
			regForm.setApprovedBoss(newProspect.getApprovedBoss());
			
			
			System.out.println("breakpoint reg 1");
			Category[] carray= HH.getCategoryByProspect(newProspect);
			System.out.println("breakpoint reg 2");
			for (int i=0;i<carray.length;i++){
				carray[i]= HH.getCategoryById(i);
				selectedCategoryList.add(carray[i].getCategoryName());
			}
			
			regForm.setSelectedCategoryList(selectedCategoryList);
			
			System.out.println("new prospect "+newProspect.getCommercialName()+"%");
			
			modelAndView.addObject("nombreComercial", newProspect.getCommercialName());
			modelAndView.addObject("nombreFiscal", newProspect.getFiscalName());
			
			Country[] countryArray = HH.getAllCountrys();
			Origin[] originArray = HH.getAllOrigins();
			Status[] statusArray = HH.getAllStatus();
			Category[] categoryArray = HH.getAllCategory();
			
			System.out.println("array 0 "+countryArray[0].getCountryName()+"%");
			
			for(int i=0;i<countryArray.length;i++){
				countryList.add(countryArray[i].getCountryName());
			}
			for(int i=0;i<originArray.length;i++){
				originList.add(originArray[i].getOriginName());
			}
			for(int i=0;i<statusArray.length;i++){
				statusList.add(statusArray[i].getStatusName());
			}
			for(int i=0;i<categoryArray.length;i++){
				System.out.println("category array i: "+categoryArray[i].getCategoryName());
				categoryList.add(categoryArray[i].getCategoryName());
			}
			
			modelAndView.addObject("regForm", regForm);
			modelAndView.addObject("countryList", countryList);
			modelAndView.addObject("originList", originList);
			modelAndView.addObject("statusList", statusList);
			modelAndView.addObject("categoryList", categoryList);
			modelAndView.addObject("SelectedCategoryList", selectedCategoryList);
			
		}
		
		System.out.println("breackpoint 1");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView iniciosesion(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		ArrayList<String> listaIdiomas = new ArrayList<String>();
		listaIdiomas.add("es_VE");
		listaIdiomas.add("en_US");
		LoginForm loginForm =  new LoginForm("jgraterol", "jgraterol", "es_VE", listaIdiomas);
		ModelAndView modelAndView = new ModelAndView ("iniciosesion");
		modelAndView.addObject("loginform",loginForm);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/postulation", method = RequestMethod.GET)
	public ModelAndView postulacion(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView ("postulation");
		HibernateHelper HH = new HibernateHelper();
		PostulationForm posform = new PostulationForm();
		
		Country[] countryArray = HH.getAllCountrys();
		Origin[] originArray = HH.getAllOrigins();
		Category[] categoryArray = HH.getAllCategory();
		Department[] departmentArray = HH.getAllDepartment();
		Line[] lineArray = HH.getAllLine();
		Section[] sectionArray = HH.getAllSection();
		
		System.out.println("array 0 "+countryArray[0].getCountryName()+"%");
		System.out.println("array 0 "+categoryArray[0].getCategoryName()+"%");

		
		ArrayList<String> countryList = new ArrayList<String>();
		ArrayList<String> originList = new ArrayList<String>();
		ArrayList<String> categoryList = new ArrayList<String>();
		ArrayList<String> departmentList = new ArrayList<String>();
		ArrayList<String> lineList = new ArrayList<String>();
		ArrayList<String> sectionList = new ArrayList<String>();
		
		for(int i=0;i<countryArray.length;i++){
			countryList.add(countryArray[i].getCountryName());
		}
		
		for(int i=0;i<originArray.length;i++){
			originList.add(originArray[i].getOriginName());
		}

		for(int i=0;i<categoryArray.length;i++){
			categoryList.add(categoryArray[i].getCategoryName());
		}
		
		for(int i=0;i<departmentArray.length;i++){
			departmentList.add(departmentArray[i].getDepartmentName());
		}
		
		for(int i=0;i<lineArray.length;i++){
			lineList.add(lineArray[i].getLineName());
		}
		
		for(int i=0;i<sectionArray.length;i++){
			sectionList.add(sectionArray[i].getSectionName());
		}
		
		posform.setCategoryList(categoryList);
		posform.setDepartmentList(departmentList);
		posform.setLineList(lineList);
		posform.setSectionList(sectionList);
		posform.setOriginList(originList);
		posform.setCountryList(countryList);
		
		System.out.println("categoria "+posform.getCategoryList().get(0)+"%");
		modelAndView.addObject("posform", posform);
		modelAndView.addObject("categoryList", posform.getCategoryList());
		modelAndView.addObject("departmentList", posform.getDepartmentList());
		modelAndView.addObject("lineList", posform.getLineList());
		modelAndView.addObject("sectionList", posform.getSectionList());
		
		System.out.println("breackpoint 11");
		return modelAndView;
		
		/*
		ModelAndView modelAndView = new ModelAndView ("postulation");
		HibernateHelper HH = new HibernateHelper();
		Country[] carray = HH.getAllCountrys();

		modelAndView.addObject("paises", carray);
		return modelAndView;*/
	}
	
	@RequestMapping(value = "/busquedaavanzada", method = RequestMethod.GET)
	public String busquedaavanzada(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		return "busquedaavanzada";
	}
	
	@RequestMapping(value = "/multiple", method = RequestMethod.GET)
	public String multiple(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		return "multiple";
	}
	
	@RequestMapping(value = "/guardarprospecto", method = RequestMethod.GET)
	public String guardarprospecto(Locale locale, Model model, @ModelAttribute(value="lang")String lang, HttpServletRequest request, HttpServletResponse response) {
		return "guardarprospecto";
	}
	
	@RequestMapping(value = "/postulationsuccess", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView postulationsuccess(@ModelAttribute(value="postulationForm")PostulationForm posForm, HttpServletRequest request,HttpServletResponse response) {
		
		ModelAndView modelAndView = new ModelAndView ("postulationsuccess");
		HibernateHelper HH = new HibernateHelper();
			System.out.println("Registrando");
			
			Prospect newProspect = new Prospect();
			
			
			ProspectDepartment newProspectDepartment = new ProspectDepartment();
			ProspectLine newProspectLine = new ProspectLine();
			ProspectSection newProspectSection = new ProspectSection();
			
			newProspect.setCommercialName(posForm.getCommercialName());
			newProspect.setRifCi(posForm.getRif());
			newProspect.setPhone(posForm.getPhone());
			newProspect.setEmail(posForm.getEmail());
			newProspect.setWebsite(posForm.getWebsite());
			newProspect.setCountry(posForm.getCountry());
			newProspect.setContactPerson(posForm.getContactPerson());
			newProspect.setOrigin(posForm.getOrigin());
			newProspect.setOriginDetails(posForm.getOriginDetails());
			newProspect.setObservation(posForm.getObservation());
			System.out.println("breackpoint ps1");
			HH.saveProspect(newProspect);
			
			System.out.println("breackpoint ps2");
			Prospect[] parray = HH.getProspectByComName(posForm.getCommercialName());
			System.out.println("breackpoint ps22");
			Category[] carray;
			Department[] darray;
			Line[] larray;
			Section[] sarray;
			ProspectCategory newProspectCategory;
			
			for(int i=0;i<posForm.getSelectedCategoryList().size();i++){
				System.out.println("listacategoryselected: "+posForm.getSelectedCategoryList().get(i));
				System.out.println("breackpoint ps3");
				carray = HH.getCategoryByName(posForm.getSelectedCategoryList().get(i));
				System.out.println("breackpoint ps4");
				
				newProspectCategory = new ProspectCategory();
				newProspectCategory.setProspect(parray[0]);
				newProspectCategory.setCategory(carray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectCategory(newProspectCategory);
				System.out.println("breackpoint ps6");
			}
			
			for(int i=0;i<posForm.getSelectedDepartmentList().size();i++){
				System.out.println("listadepartmentselected: "+posForm.getSelectedDepartmentList().get(i));
				darray = HH.getDepartmentByName(posForm.getSelectedDepartmentList().get(i));
				
				newProspectDepartment = new ProspectDepartment();
				newProspectDepartment.setProspect(parray[0]);
				newProspectDepartment.setDepartment(darray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectDepartment(newProspectDepartment);
				System.out.println("breackpoint ps6");
			}
			
			for(int i=0;i<posForm.getSelectedLineList().size();i++){
				System.out.println("listalineselected: "+posForm.getSelectedLineList().get(i));
				larray = HH.getLineByName(posForm.getSelectedLineList().get(i));
				
				newProspectLine = new ProspectLine();
				newProspectLine.setProspect(parray[0]);
				newProspectLine.setLine(larray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectLine(newProspectLine);
				System.out.println("breackpoint ps6");
			}
			
			for(int i=0;i<posForm.getSelectedSectionList().size();i++){
				System.out.println("listasectionselected: "+posForm.getSelectedSectionList().get(i));
				sarray = HH.getSectionByName(posForm.getSelectedSectionList().get(i));
				
				newProspectSection = new ProspectSection();
				newProspectSection.setProspect(parray[0]);
				newProspectSection.setSection(sarray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectSection(newProspectSection);
				System.out.println("breackpoint ps6");
			}
			System.out.println("nombre: "+posForm.getCommercialName());
			
			//HH.saveProspect(paramProspect);
			//System.out.println("prospecto Guardado "+paramProspect.getCommercialName());	
			return modelAndView;
		
	}

	@RequestMapping(value = "/registrationsuccess", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView registrationsuccess(@ModelAttribute(value="registrationForm")RegistrationForm regForm, HttpServletRequest request,HttpServletResponse response) {
		System.out.println("breackpoint ps0");
		ModelAndView modelAndView = new ModelAndView ("registrationsuccess");
		HibernateHelper HH = new HibernateHelper();
		System.out.println("Registrando");
		
		Prospect newProspect = new Prospect();
		Prospect[] actarray = HH.getProspectByComName(regForm.getCommercialName());
		if(actarray.length!=0){
			newProspect = actarray[0];
		}
		
		ProspectDepartment newProspectDepartment = new ProspectDepartment();
		ProspectLine newProspectLine = new ProspectLine();
		ProspectSection newProspectSection = new ProspectSection();
		
		System.out.println("nombre comercial: "+regForm.getCommercialName());
		System.out.println("telefono: "+regForm.getPhone());
		System.out.println("pais: "+regForm.getCountry());
		
		
		newProspect.setCommercialName(regForm.getCommercialName());
		newProspect.setFiscalName(regForm.getFiscalName());
		newProspect.setRifCi(regForm.getRif());
		newProspect.setExpirationDateRif(regForm.getRifExpirationDate());
		newProspect.setPhone(regForm.getPhone());
		newProspect.setPhone2(regForm.getPhone2());
		newProspect.setEmail(regForm.getEmail());
		newProspect.setWebsite(regForm.getWebsite());
		newProspect.setCountry(regForm.getCountry());
		newProspect.setContactPerson(regForm.getContactPerson());
		newProspect.setOrigin(regForm.getOrigin());
		newProspect.setOriginDetails(regForm.getOriginDetails());
		newProspect.setObservation(regForm.getObservation());
		newProspect.setStatus(regForm.getStatus());
		newProspect.setStatusDetails(regForm.getStatusDetails());
		newProspect.setAssets(regForm.getAssets());
		newProspect.setProducts(regForm.getProducts());
		newProspect.setServices(regForm.getServices());
		newProspect.setApprovedFinance(regForm.getApprovedFinance());
		newProspect.setApprovedBoss(regForm.getApprovedBoss());
		
		System.out.println("breackpoint ps1");
		
		if(actarray.length!=0){
			HH.updateProspect(newProspect);
		}else{
			HH.saveProspect(newProspect);
		}
		HH.saveOrUpdateProspect(newProspect);
		
		System.out.println("breackpoint ps2");
		Prospect[] parray = HH.getProspectByComName(regForm.getCommercialName());
		System.out.println("breackpoint ps22");
		Category[] carray;
		Department[] darray;
		Line[] larray;
		Section[] sarray;
		ProspectCategory newProspectCategory;
		System.out.println("breackpoint ps23");
		System.out.println("selectedCategoryList.size(): "+(regForm.getSelectedCategoryList()==null));
		
		if(regForm.getSelectedCategoryList()==null){
			
		}else{
			for(int i=0;i<regForm.getSelectedCategoryList().size();i++){
				System.out.println("listacategoryselected: "+regForm.getSelectedCategoryList().get(i));
				System.out.println("breackpoint ps3");
				carray = HH.getCategoryByName(regForm.getSelectedCategoryList().get(i));
				System.out.println("breackpoint ps4");
				
				newProspectCategory = new ProspectCategory();
				newProspectCategory.setProspect(parray[0]);
				newProspectCategory.setCategory(carray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectCategory(newProspectCategory);
				System.out.println("breackpoint ps6");
			}
		}
			
		System.out.println("breackpoint ps61");
		
		if(regForm.getSelectedDepartmentList()==null){
			
		}else{
			for(int i=0;i<regForm.getSelectedDepartmentList().size();i++){
				System.out.println("listadepartmentselected: "+regForm.getSelectedDepartmentList().get(i));
				darray = HH.getDepartmentByName(regForm.getSelectedDepartmentList().get(i));
				
				newProspectDepartment = new ProspectDepartment();
				newProspectDepartment.setProspect(parray[0]);
				newProspectDepartment.setDepartment(darray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectDepartment(newProspectDepartment);
				System.out.println("breackpoint ps6");
			}
		}
		
		if(regForm.getSelectedLineList()==null){
			
		}else{
			for(int i=0;i<regForm.getSelectedLineList().size();i++){
				System.out.println("listalineselected: "+regForm.getSelectedLineList().get(i));
				larray = HH.getLineByName(regForm.getSelectedLineList().get(i));
				
				newProspectLine = new ProspectLine();
				newProspectLine.setProspect(parray[0]);
				newProspectLine.setLine(larray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectLine(newProspectLine);
				System.out.println("breackpoint ps6");
			}
		}
		
		if(regForm.getSelectedSectionList()==null){
			
		}else{
			for(int i=0;i<regForm.getSelectedSectionList().size();i++){
				System.out.println("listasectionselected: "+regForm.getSelectedSectionList().get(i));
				sarray = HH.getSectionByName(regForm.getSelectedSectionList().get(i));
				
				newProspectSection = new ProspectSection();
				newProspectSection.setProspect(parray[0]);
				newProspectSection.setSection(sarray[0]);
				System.out.println("breackpoint ps5");
				HH.saveProspectSection(newProspectSection);
				System.out.println("breackpoint ps6");
			}
		}
		
		System.out.println("nombre: "+regForm.getCommercialName());
		
		//HH.saveProspect(paramProspect);
		//System.out.println("prospecto Guardado "+paramProspect.getCommercialName());	
		return modelAndView;
		
		/*ModelAndView modelAndView = new ModelAndView ("registrationsuccess");
		HibernateHelper HH = new HibernateHelper();
		//Prospect newProspect = new Prospect();
		
		System.out.println("Registrando");
		String nombreComercial = paramProspect.getCommercialName();
		
		
		Prospect[] array = HH.getProspectByComName("'"+nombreComercial+"'");
		System.out.println("longitud = "+array.length);
		if(array.length==0){
			HH.saveProspect(paramProspect);

			System.out.println("prospecto Guardado "+nombreComercial);	
			
		}else{
			
			BigDecimal id = array[0].getProspectId();
			paramProspect.setProspectId(id);
			HH.updateProspect(paramProspect);
			System.out.println("prospecto Actualizado "+nombreComercial);
			System.out.println("Assets: "+paramProspect.getAssets());
			
		}
		
		return modelAndView;
		*/
	}
}
