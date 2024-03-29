package com.beco.portalproveedores.bean;

// Generated 14/03/2014 11:08:13 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class RolePermission.
 * @see com.beco.portalproveedores.bean.RolePermission
 * @author Hibernate Tools
 */
@Stateless
public class RolePermissionHome {

	private static final Log log = LogFactory.getLog(RolePermissionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(RolePermission transientInstance) {
		log.debug("persisting RolePermission instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(RolePermission persistentInstance) {
		log.debug("removing RolePermission instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public RolePermission merge(RolePermission detachedInstance) {
		log.debug("merging RolePermission instance");
		try {
			RolePermission result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public RolePermission findById(BigDecimal id) {
		log.debug("getting RolePermission instance with id: " + id);
		try {
			RolePermission instance = entityManager.find(RolePermission.class,
					id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
