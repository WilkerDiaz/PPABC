package com.beco.portalproveedores.bean;

// Generated 28/03/2014 02:09:19 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class ProspectSection.
 * @see com.beco.portalproveedores.bean.ProspectSection
 * @author Hibernate Tools
 */
@Stateless
public class ProspectSectionHome {

	private static final Log log = LogFactory.getLog(ProspectSectionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProspectSection transientInstance) {
		log.debug("persisting ProspectSection instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProspectSection persistentInstance) {
		log.debug("removing ProspectSection instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProspectSection merge(ProspectSection detachedInstance) {
		log.debug("merging ProspectSection instance");
		try {
			ProspectSection result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProspectSection findById(BigDecimal id) {
		log.debug("getting ProspectSection instance with id: " + id);
		try {
			ProspectSection instance = entityManager.find(
					ProspectSection.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
