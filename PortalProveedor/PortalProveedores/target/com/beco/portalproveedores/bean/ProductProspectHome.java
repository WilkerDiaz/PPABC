package com.beco.portalproveedores.bean;

// Generated 14/03/2014 11:08:13 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProductProspect.
 * @see com.beco.portalproveedores.bean.ProductProspect
 * @author Hibernate Tools
 */
@Stateless
public class ProductProspectHome {

	private static final Log log = LogFactory.getLog(ProductProspectHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProductProspect transientInstance) {
		log.debug("persisting ProductProspect instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductProspect persistentInstance) {
		log.debug("removing ProductProspect instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductProspect merge(ProductProspect detachedInstance) {
		log.debug("merging ProductProspect instance");
		try {
			ProductProspect result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductProspect findById(BigDecimal id) {
		log.debug("getting ProductProspect instance with id: " + id);
		try {
			ProductProspect instance = entityManager.find(
					ProductProspect.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
