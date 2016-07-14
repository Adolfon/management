// default package
// Generated Jun 15, 2016 5:39:08 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.persistance;
import java.util.ArrayList;
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

import co.jp.eureka.entities.MaSkillcategory;
import co.jp.eureka.entities.MaSkillitem;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoMaSkillitem;

/**
 * Home object for domain model class MaSkillcategory.
 * @see .MaSkillcategory
 * @author Hibernate Tools
 */
public class MaSkillcategoryHome {

//	private static final Log log = LogFactory.getLog(MaSkillcategoryHome.class);
//
//	private final SessionFactory sessionFactory = getSessionFactory();
	private static final Logger log = LogManager.getLogger(MaSkillcategoryHome.class);	
	private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	
	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MaSkillcategory transientInstance) {
		log.debug("persisting MaSkillcategory instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MaSkillcategory instance) {
		log.debug("attaching dirty MaSkillcategory instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MaSkillcategory instance) {
		log.debug("attaching clean MaSkillcategory instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MaSkillcategory persistentInstance) {
		log.debug("deleting MaSkillcategory instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MaSkillcategory merge(MaSkillcategory detachedInstance) {
		log.debug("merging MaSkillcategory instance");
		try {
			MaSkillcategory result = (MaSkillcategory) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MaSkillcategory findById(java.lang.String id) {
		log.debug("getting MaSkillcategory instance with id: " + id);
		try {
			//MaSkillcategory instance = (MaSkillcategory) sessionFactory.getCurrentSession().get("MaSkillcategory", id);
			MaSkillcategory instance = (MaSkillcategory) sessionFactory.getCurrentSession().get(MaSkillcategory.class, id);
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

	public List findByExample(MaSkillcategory instance) {
		log.debug("finding MaSkillcategory instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("MaSkillcategory")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<MaSkillcategory> findListMaSkillCategorys_BySkillitemList(List<DtoMaSkillitem> skillItemList) {
		List<MaSkillcategory> listOfCategories=new ArrayList<MaSkillcategory>();	
		StringBuilder sql;
		String maSkillcategoryId;
		MaSkillcategory maSkillcategoryLoop;
		DtoMaSkillitem dtoMaSkillitem;
		Object[] result;
		Iterator it=skillItemList.iterator();
		SQLQuery query;
		
		while(it.hasNext()){
				
			
			dtoMaSkillitem=(DtoMaSkillitem) it.next();
			//Object[] obj=(Object[]) it.next();
			
			
			//maSkillcategoryId =new String(((String) obj[3]));
			maSkillcategoryId= new String (dtoMaSkillitem.getCategory_code());
			
			sql=new StringBuilder("SELECT * FROM ma_skillcategory m WHERE m.category_code='"+maSkillcategoryId+"'");
			query= sessionFactory.getCurrentSession().createSQLQuery(sql.toString());
			result=query.list().toArray();
			
			for (int i=0;i<result.length;i++){
				Object[] objLoop=(Object[])result[i];
				maSkillcategoryLoop= new MaSkillcategory();
				maSkillcategoryLoop.setCategoryCodecode((String)objLoop[0]);
				maSkillcategoryLoop.setCategoryName((String) objLoop[1]);
				maSkillcategoryLoop.setCategoryDspOrder((Integer)objLoop[2]);			
				log.debug("Bean added: "+maSkillcategoryLoop.toString());
				listOfCategories.add(maSkillcategoryLoop);
			}//for
			
		}//while
		
		return listOfCategories;
		
	}
}
