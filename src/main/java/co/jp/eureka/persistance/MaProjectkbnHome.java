// default package
// Generated Jun 15, 2016 5:39:08 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.persistance;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.jp.eureka.entities.MaProjectkbn;
import co.jp.eureka.utils.HibernateUtil;

/**
 * Home object for domain model class MaProjectkbn.
 * @see .MaProjectkbn
 * @author Hibernate Tools
 */
public class MaProjectkbnHome {

	//private static final Log log = LogFactory.getLog(MaProjectkbnHome.class);
	private static final Logger log = LogManager.getLogger(MaProjectkbnHome.class);

	//private final SessionFactory sessionFactory = getSessionFactory();
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MaProjectkbn transientInstance) {
		log.debug("persisting MaProjectkbn instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MaProjectkbn instance) {
		log.debug("attaching dirty MaProjectkbn instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MaProjectkbn instance) {
		log.debug("attaching clean MaProjectkbn instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MaProjectkbn persistentInstance) {
		log.debug("deleting MaProjectkbn instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MaProjectkbn merge(MaProjectkbn detachedInstance) {
		log.debug("merging MaProjectkbn instance");
		try {
			MaProjectkbn result = (MaProjectkbn) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MaProjectkbn findById(int id) {
		log.debug("getting MaProjectkbn instance with id: " + id);
		try {
			MaProjectkbn instance = (MaProjectkbn) sessionFactory.getCurrentSession().get("MaProjectkbn", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MaProjectkbn instance) {
		log.debug("finding MaProjectkbn instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("MaProjectkbn")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
