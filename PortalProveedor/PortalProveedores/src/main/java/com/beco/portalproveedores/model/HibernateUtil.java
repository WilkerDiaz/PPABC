package com.beco.portalproveedores.model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory = getSessionFactory();
	public static ServiceRegistry serviceRegistry;
	
	protected static SessionFactory getSessionFactory() {
		try {
			
			if(sessionFactory!=null)
				return sessionFactory;
			
			Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
		    
		    SessionFactory sess = configuration.buildSessionFactory(serviceRegistry);
		  
		    
            return sess;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new IllegalStateException(
					e.getMessage());
		}
	}
}
