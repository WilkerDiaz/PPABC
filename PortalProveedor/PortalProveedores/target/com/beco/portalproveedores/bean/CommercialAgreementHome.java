package com.beco.portalproveedores.bean;

// Generated 14/03/2014 11:08:13 AM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CommercialAgreement.
 * @see com.beco.portalproveedores.bean.CommercialAgreement
 * @author Hibernate Tools
 */
@Stateless
public class CommercialAgreementHome {

	private static final Log log = LogFactory
			.getLog(CommercialAgreementHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CommercialAgreement transientInstance) {
		log.debug("persisting CommercialAgreement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CommercialAgreement persistentInstance) {
		log.debug("removing CommercialAgreement instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CommercialAgreement merge(CommercialAgreement detachedInstance) {
		log.debug("merging CommercialAgreement instance");
		try {
			CommercialAgreement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CommercialAgreement findById(BigDecimal id) {
		log.debug("getting CommercialAgreement instance with id: " + id);
		try {
			CommercialAgreement instance = entityManager.find(
					CommercialAgreement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
