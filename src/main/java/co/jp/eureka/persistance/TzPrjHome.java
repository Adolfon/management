// default package
// Generated Jun 15, 2016 5:39:08 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.persistance;
import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.entities.MaEngineerkbn;
import co.jp.eureka.entities.TzPrj;
import co.jp.eureka.utils.HibernateUtil;

/**
 * Home object for domain model class TzPrj.
 * @see .TzPrj
 * @author Hibernate Tools
 */
public class TzPrjHome {

	private static final Log log = LogFactory.getLog(TzPrjHome.class);
	
	//private final SessionFactory sessionFactory = getSessionFactory();
	private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();

	protected SessionFactory getSessionFactory332() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
	
	

	public void persist(TzPrj transientInstance) {
		log.debug("persisting TzPrj instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TzPrj instance) {
		log.debug("attaching dirty TzPrj instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TzPrj instance) {
		log.debug("attaching clean TzPrj instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TzPrj persistentInstance) {
		log.debug("deleting TzPrj instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TzPrj merge(TzPrj detachedInstance) {
		log.debug("merging TzPrj instance");
		try {
			TzPrj result = (TzPrj) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TzPrj findById(Integer id) { //Changed to Integer from int
		log.debug("getting TzPrj instance with id: " + id);
		try {
			//TzPrj instance = (TzPrj) sessionFactory.getCurrentSession().get("TzPrj", id);
			TzPrj instance = (TzPrj) sessionFactory.getCurrentSession().get(TzPrj.class, id);//seems it is not working...
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

	public List findByExample(TzPrj instance) {
		log.debug("finding TzPrj instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("TzPrj").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List<TzPrj> listOfProjects_Named_query(){
		Query query = sessionFactory.getCurrentSession().getNamedQuery("listProjects");
		List<TzPrj> result= query.list();
		return result;
	}
	
	public List<TzPrj> listfProjects(){
		List<TzPrj> result= sessionFactory.getCurrentSession().createSQLQuery("SELECT * FROM tz_prj").list(); 		
		return result;
	}
	
	//Project with the given Bean
//	public List<TzPrj> listfProjectsAndBeans(){
//		String sql="SELECT * FROM tz_prj";
//		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql); 
//		query.addEntity(TzPrj.class);
//		List<TzPrj> result=query.list();
//		return result;
//	}
		
}
