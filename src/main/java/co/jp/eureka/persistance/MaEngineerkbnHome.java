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
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.jp.eureka.entities.MaEngineerkbn;
import co.jp.eureka.utils.HibernateUtil;

/**
 * Home object for domain model class MaEngineerkbn.
 * @see .MaEngineerkbn
 * @author Hibernate Tools
 */
public class MaEngineerkbnHome {

//	private static final Log log = LogFactory.getLog(MaEngineerkbnHome.class);
//
//	private final SessionFactory sessionFactory = getSessionFactory();

	//private static final Log log = LogFactory.getLog(MaEngineerkbnHome.class);
	private static final Logger log = LogManager.getLogger(MaEngineerkbnHome.class);	
	private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MaEngineerkbn transientInstance) {
		log.debug("persisting MaEngineerkbn instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MaEngineerkbn instance) {
		log.debug("attaching dirty MaEngineerkbn instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MaEngineerkbn instance) {
		log.debug("attaching clean MaEngineerkbn instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MaEngineerkbn persistentInstance) {
		log.debug("deleting MaEngineerkbn instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MaEngineerkbn merge(MaEngineerkbn detachedInstance) {
		log.debug("merging MaEngineerkbn instance");
		try {
			MaEngineerkbn result = (MaEngineerkbn) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MaEngineerkbn findById(int id) {
		log.debug("getting MaEngineerkbn instance with id: " + id);
		try {
			MaEngineerkbn instance = (MaEngineerkbn) sessionFactory.getCurrentSession().get(MaEngineerkbn.class, id);
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

	public List findByExample(MaEngineerkbn instance) {
		log.debug("finding MaEngineerkbn instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("MaEngineerkbn")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<MaEngineerkbn> listOfEngineerKbn(){
		String sql="SELECT * FROM ma_engineerkbn";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql); 
		query.addEntity(MaEngineerkbn.class);
		List<MaEngineerkbn> result=query.list();
		return result;
	}
	
	
}
