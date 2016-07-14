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

import co.jp.eureka.entities.TzPrjNeedsEngineer;
import co.jp.eureka.entities.TzPrjNeedsEngineerId;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoPrjNeedsEngineer;
import java.util.Date;

/**
 * Home object for domain model class TzPrjNeedsEngineer.
 * @see .TzPrjNeedsEngineer
 * @author Hibernate Tools
 */
public class TzPrjNeedsEngineerHome {

//	private static final Log log = LogFactory.getLog(TzPrjNeedsEngineerHome.class);
//
//	private final SessionFactory sessionFactory = getSessionFactory();

	private static final Logger log = LogManager.getLogger(TzPrjNeedsEngineerHome.class);	
	private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(TzPrjNeedsEngineer transientInstance) {
		log.debug("persisting TzPrjNeedsEngineer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(TzPrjNeedsEngineer instance) {
		log.debug("attaching dirty TzPrjNeedsEngineer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TzPrjNeedsEngineer instance) {
		log.debug("attaching clean TzPrjNeedsEngineer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(TzPrjNeedsEngineer persistentInstance) {
		log.debug("deleting TzPrjNeedsEngineer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TzPrjNeedsEngineer merge(TzPrjNeedsEngineer detachedInstance) {
		log.debug("merging TzPrjNeedsEngineer instance");
		try {
			TzPrjNeedsEngineer result = (TzPrjNeedsEngineer) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TzPrjNeedsEngineer findById(TzPrjNeedsEngineerId id) {
		log.debug("getting TzPrjNeedsEngineer instance with id: " + id);
		try {
			TzPrjNeedsEngineer instance = (TzPrjNeedsEngineer) sessionFactory.getCurrentSession()
					.get("TzPrjNeedsEngineer", id);
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

	public List findByExample(TzPrjNeedsEngineer instance) {
		log.debug("finding TzPrjNeedsEngineer instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("TzPrjNeedsEngineer")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public DtoPrjNeedsEngineer findPrjNeedsEngineer_ById(Integer prjId, Integer prSubId,
			Integer prNeedsId) {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM tz_prj_needs_engineer t where t.prj_id="+prjId+" and t.prj_sub_id="+prSubId+
				" and t.prj_needs_engineerkbn_id="+prNeedsId;
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql); 		
		Object[] result=query.list().toArray();	
		Object[] obj=(Object[])result[0];
		if (result.length>1) log.error("The database recover more than one record, expected only one");
		DtoPrjNeedsEngineer dtoEngineer= new DtoPrjNeedsEngineer();
		//PK
		dtoEngineer.setPrj_id((Integer)obj[0]);
		dtoEngineer.setPrj_sub_id((Integer)obj[1]);
		dtoEngineer.setTz_prj_needs_engineerkbn_id((Integer)obj[2]);
		//Members
		dtoEngineer.setPrj_needs_engineer_number((Integer)obj[3]);
		dtoEngineer.setPrj_needs_priod_from((Date)obj[4]);
		dtoEngineer.setPrj_needs_priod_to((Date)obj[5]);
		dtoEngineer.setPrj_needs_engineer_rough_price((Integer)obj[6]);
		dtoEngineer.setPrj_needs_engineer_working_place((String)obj[7]);
		dtoEngineer.setPrj_needs_engineer_etc((String)obj[8]);
		dtoEngineer.setPrj_needs_eng_upd_kaisha_id((Integer)obj[9]);
		dtoEngineer.setPrj_needs_eng_upd_user_id((Integer)obj[10]);
		dtoEngineer.setUpd_dtime((Date)obj[11]);
		return dtoEngineer;
	}
	
}//Class TzPrjNeedsEngineerHome
