package com.beco.portalproveedores.bean;

// Generated 14/03/2014 11:08:13 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class RoleUserPortal.
 * @see com.beco.portalproveedores.bean.RoleUserPortal
 * @author Hibernate Tools
 */
@Stateless
public class RoleUserPortalHome {

	private static final Log log = LogFactory.getLog(RoleUserPortalHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RoleUserPortal transientInstance) {
		log.debug("persisting RoleUserPortal instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RoleUserPortal persistentInstance) {
		log.debug("removing RoleUserPortal instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RoleUserPortal merge(RoleUserPortal detachedInstance) {
		log.debug("merging RoleUserPortal instance");
		try {
			RoleUserPortal result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RoleUserPortal findById(BigDecimal id) {
		log.debug("getting RoleUserPortal instance with id: " + id);
		try {
			RoleUserPortal instance = entityManager.find(RoleUserPortal.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
