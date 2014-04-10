package com.beco.portalproveedores.bean;

// Generated 14/03/2014 11:08:13 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Prospect.
 * @see com.beco.portalproveedores.bean.Prospect
 * @author Hibernate Tools
 */
@Stateless
public class ProspectHome {

	private static final Log log = LogFactory.getLog(ProspectHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Prospect transientInstance) {
		log.debug("persisting Prospect instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Prospect persistentInstance) {
		log.debug("removing Prospect instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Prospect merge(Prospect detachedInstance) {
		log.debug("merging Prospect instance");
		try {
			Prospect result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Prospect findById(BigDecimal id) {
		log.debug("getting Prospect instance with id: " + id);
		try {
			Prospect instance = entityManager.find(Prospect.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
