package com.beco.portalproveedores.bean;

// Generated 27/03/2014 04:21:06 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Line.
 * @see com.beco.portalproveedores.bean.Line
 * @author Hibernate Tools
 */
@Stateless
public class LineHome {

	private static final Log log = LogFactory.getLog(LineHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Line transientInstance) {
		log.debug("persisting Line instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Line persistentInstance) {
		log.debug("removing Line instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Line merge(Line detachedInstance) {
		log.debug("merging Line instance");
		try {
			Line result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Line findById(BigDecimal id) {
		log.debug("getting Line instance with id: " + id);
		try {
			Line instance = entityManager.find(Line.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
