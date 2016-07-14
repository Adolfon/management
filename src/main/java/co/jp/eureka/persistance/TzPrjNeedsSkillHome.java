// default package
// Generated Jul 7, 2016 5:11:46 PM by Hibernate Tools 5.1.0.Alpha1
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

import co.jp.eureka.entities.TzPrjNeedsSkill;
import co.jp.eureka.entities.TzPrjNeedsSkillId;
import co.jp.eureka.utils.HibernateUtil;

/**
 * Home object for domain model class TzPrjNeedsSkill.
 * @see .TzPrjNeedsSkill
 * @author Hibernate Tools
 */
public class TzPrjNeedsSkillHome {

//	private static final Log log = LogFactory.getLog(TzPrjNeedsSkillHome.class);
//
//	private final SessionFactory sessionFactory = getSessionFactory();
	
	
	private static final Logger log = LogManager.getLogger(TzPrjNeedsSkillHome_old.class);	
	private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TzPrjNeedsSkill transientInstance) {
		log.debug("persisting TzPrjNeedsSkill instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TzPrjNeedsSkill instance) {
		log.debug("attaching dirty TzPrjNeedsSkill instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TzPrjNeedsSkill instance) {
		log.debug("attaching clean TzPrjNeedsSkill instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TzPrjNeedsSkill persistentInstance) {
		log.debug("deleting TzPrjNeedsSkill instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TzPrjNeedsSkill merge(TzPrjNeedsSkill detachedInstance) {
		log.debug("merging TzPrjNeedsSkill instance");
		try {
			TzPrjNeedsSkill result = (TzPrjNeedsSkill) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TzPrjNeedsSkill findById(TzPrjNeedsSkillId id) {
		log.debug("getting TzPrjNeedsSkill instance with id: " + id);
		try {
			TzPrjNeedsSkill instance = (TzPrjNeedsSkill) sessionFactory.getCurrentSession().get("TzPrjNeedsSkill", id);
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

	public List findByExample(TzPrjNeedsSkill instance) {
		log.debug("finding TzPrjNeedsSkill instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("TzPrjNeedsSkill")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

//	public Object listOfSkillsByProject(Integer projectId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public List<TzPrjNeedsSkill> listOfSkillsByProject(Integer projectId){
		String sql="SELECT * FROM tz_prj_needs_skill t WHERE t.prj_id = "+projectId;
		List<TzPrjNeedsSkill> result= (List<TzPrjNeedsSkill>) sessionFactory.getCurrentSession().createSQLQuery(sql).list(); 		
		return result;
	}
	
	
}
