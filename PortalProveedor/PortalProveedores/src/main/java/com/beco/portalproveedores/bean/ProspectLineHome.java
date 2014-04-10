package com.beco.portalproveedores.bean;

// Generated 28/03/2014 02:09:19 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProspectLine.
 * @see com.beco.portalproveedores.bean.ProspectLine
 * @author Hibernate Tools
 */
@Stateless
public class ProspectLineHome {

	private static final Log log = LogFactory.getLog(ProspectLineHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProspectLine transientInstance) {
		log.debug("persisting ProspectLine instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProspectLine persistentInstance) {
		log.debug("removing ProspectLine instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProspectLine merge(ProspectLine detachedInstance) {
		log.debug("merging ProspectLine instance");
		try {
			ProspectLine result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProspectLine findById(BigDecimal id) {
		log.debug("getting ProspectLine instance with id: " + id);
		try {
			ProspectLine instance = entityManager.find(ProspectLine.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
