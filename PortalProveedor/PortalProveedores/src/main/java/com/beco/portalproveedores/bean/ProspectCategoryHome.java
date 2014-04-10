package com.beco.portalproveedores.bean;

// Generated 28/03/2014 02:09:19 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProspectCategory.
 * @see com.beco.portalproveedores.bean.ProspectCategory
 * @author Hibernate Tools
 */
@Stateless
public class ProspectCategoryHome {

	private static final Log log = LogFactory
			.getLog(ProspectCategoryHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProspectCategory transientInstance) {
		log.debug("persisting ProspectCategory instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProspectCategory persistentInstance) {
		log.debug("removing ProspectCategory instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProspectCategory merge(ProspectCategory detachedInstance) {
		log.debug("merging ProspectCategory instance");
		try {
			ProspectCategory result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProspectCategory findById(BigDecimal id) {
		log.debug("getting ProspectCategory instance with id: " + id);
		try {
			ProspectCategory instance = entityManager.find(
					ProspectCategory.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
