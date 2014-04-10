package com.beco.portalproveedores.bean;

// Generated 18/02/2014 09:38:43 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Product.
 * @see com.beco.portalproveedores.bean.Product
 * @author Hibernate Tools
 */
@Stateless
public class ProductHome {

	private static final Log log = LogFactory.getLog(ProductHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Product transientInstance) {
		log.debug("persisting Product instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Product persistentInstance) {
		log.debug("removing Product instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Product findById(BigDecimal id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = entityManager.find(Product.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
