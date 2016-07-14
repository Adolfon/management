// default package
// Generated Jun 15, 2016 5:39:08 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.persistance;
import java.util.Iterator;
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

import co.jp.eureka.entities.MaSkillitem;
import co.jp.eureka.entities.MaSkillitemId;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoMaSkillitem;

/**
 * Home object for domain model class MaSkillitem.
 * @see .MaSkillitem
 * @author Hibernate Tools
 */
public class MaSkillitemHome_old {

	//private static final Log log = LogFactory.getLog(MaSkillitemHome.class);

	//private final SessionFactory sessionFactory = getSessionFactory();
	private static final Logger log = LogManager.getLogger(MaSkillitemHome.class);	
	private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MaSkillitem transientInstance) {
		log.debug("persisting MaSkillitem instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MaSkillitem instance) {
		log.debug("attaching dirty MaSkillitem instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MaSkillitem instance) {
		log.debug("attaching clean MaSkillitem instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MaSkillitem persistentInstance) {
		log.debug("deleting MaSkillitem instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MaSkillitem merge(MaSkillitem detachedInstance) {
		log.debug("merging MaSkillitem instance");
		try {
			MaSkillitem result = (MaSkillitem) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MaSkillitem findById(MaSkillitemId id) {
		log.debug("getting MaSkillitem instance with id: " + id);
		try {
			MaSkillitem instance = (MaSkillitem) sessionFactory.getCurrentSession().get(MaSkillitem.class, id);
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

	public List findByExample(MaSkillitem instance) {
		log.debug("finding MaSkillitem instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("MaSkillitem")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	// Extra methods needed by the DTOs classes
	public DtoMaSkillitem findMaSkillItem_ById(String catCode,String skillCode){
		String sql="SELECT * FROM ma_skillitem m WHERE m.category_code='"+catCode+"' AND m.skill_code='"+skillCode+"'";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql); 		
		Object[] result=query.list().toArray();	
		Object[] obj=(Object[])result[0];
		
		if (result.length>1) log.error("The database recover more than one record, expected only one");
		DtoMaSkillitem dtoResult=new DtoMaSkillitem();
		dtoResult.setCategory_code((String) obj[0]);
		dtoResult.setSkill_code((String)obj[1]);
		dtoResult.setSkill_name((String)obj[2]);
		dtoResult.setSkill_dsp_order((Integer)obj[3]);	
		return dtoResult;
	}
	
	
}
