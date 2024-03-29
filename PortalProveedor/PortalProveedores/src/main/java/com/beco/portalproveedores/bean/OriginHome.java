package com.beco.portalproveedores.bean;

// Generated 14/03/2014 04:13:58 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Origin.
 * @see com.beco.portalproveedores.bean.Origin
 * @author Hibernate Tools
 */
@Stateless
public class OriginHome {

	private static final Log log = LogFactory.getLog(OriginHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Origin transientInstance) {
		log.debug("persisting Origin instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Origin persistentInstance) {
		log.debug("removing Origin instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Origin merge(Origin detachedInstance) {
		log.debug("merging Origin instance");
		try {
			Origin result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Origin findById(BigDecimal id) {
		log.debug("getting Origin instance with id: " + id);
		try {
			Origin instance = entityManager.find(Origin.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
