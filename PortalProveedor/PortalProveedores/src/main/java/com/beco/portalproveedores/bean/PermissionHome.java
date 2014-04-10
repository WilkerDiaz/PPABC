package com.beco.portalproveedores.bean;

// Generated 18/02/2014 09:38:43 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Permission.
 * @see com.beco.portalproveedores.bean.Permission
 * @author Hibernate Tools
 */
@Stateless
public class PermissionHome {

	private static final Log log = LogFactory.getLog(PermissionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Permission transientInstance) {
		log.debug("persisting Permission instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Permission persistentInstance) {
		log.debug("removing Permission instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Permission merge(Permission detachedInstance) {
		log.debug("merging Permission instance");
		try {
			Permission result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Permission findById(BigDecimal id) {
		log.debug("getting Permission instance with id: " + id);
		try {
			Permission instance = entityManager.find(Permission.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
