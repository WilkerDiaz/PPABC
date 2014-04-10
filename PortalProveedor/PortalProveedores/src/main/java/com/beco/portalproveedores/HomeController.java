package com.beco.portalproveedores;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beco.consumoservicio.HoraServidorProxy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
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
	
}
