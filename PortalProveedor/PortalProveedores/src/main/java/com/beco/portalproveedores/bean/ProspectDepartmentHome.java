package com.beco.portalproveedores.bean;

// Generated 28/03/2014 02:09:19 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProspectDepartment.
 * @see com.beco.portalproveedores.bean.ProspectDepartment
 * @author Hibernate Tools
 */
@Stateless
public class ProspectDepartmentHome {

	private static final Log log = LogFactory
			.getLog(ProspectDepartmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProspectDepartment transientInstance) {
		log.debug("persisting ProspectDepartment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProspectDepartment persistentInstance) {
		log.debug("removing ProspectDepartment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProspectDepartment merge(ProspectDepartment detachedInstance) {
		log.debug("merging ProspectDepartment instance");
		try {
			ProspectDepartment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProspectDepartment findById(BigDecimal id) {
		log.debug("getting ProspectDepartment instance with id: " + id);
		try {
			ProspectDepartment instance = entityManager.find(
					ProspectDepartment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
