// default package
// Generated Jun 15, 2016 5:39:08 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.persistance;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.entities.MaEngineerkbn;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoMaSkillitem;

/**
 * Home object for domain model class MaCustomer.
 * @see .MaCustomer
 * @author Hibernate Tools
 */
public class MaCustomerHome {

	//private static final Log log = LogFactory.getLog(MaCustomerHome.class);
	private static final Logger log = LogManager.getLogger(MaCustomerHome.class);


	
	//private final SessionFactory sessionFactory = getSessionFactory();
	
		// Having the sessionFactory in the context I recover it as follows:
		//SessionFactory sessionFactory = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		// Recovering the Hibernate session from the utility class
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		
		
		//testion the session creation
		public void testSession(){
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.close();
		}
	

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MaCustomer transientInstance) {
		log.debug("persisting MaCustomer instance");
		try {
			//sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			//sessionFactory.getCurrentSession().getTransaction().commit();
			//sessionFactory.getCurrentSession().close();
			//HibernateUtil.getSessionFactory().getCurrentSession().persist(transientInstance);
			System.out.println("persist successful");
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MaCustomer instance) {
		log.debug("attaching dirty MaCustomer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MaCustomer instance) {
		log.debug("attaching clean MaCustomer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MaCustomer persistentInstance) {
		log.debug("deleting MaCustomer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MaCustomer merge(MaCustomer detachedInstance) {
		log.debug("merging MaCustomer instance");
		try {
			MaCustomer result = (MaCustomer) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MaCustomer findById(int id) {
		log.debug("getting MaCustomer instance with id: " + id);
		try {
			//It can not find the name of the class, it doesn't work properly 
			//MaCustomer instance = (MaCustomer) sessionFactory.getCurrentSession().get("MaCustomer", id);
			//Using another overload method...
			MaCustomer instance = (MaCustomer) sessionFactory.getCurrentSession().get(MaCustomer.class, id);
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

	public List findByExample(MaCustomer instance) {
		log.debug("finding MaCustomer instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("MaCustomer").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	public void saveOrUpdate(MaCustomer object){
		log.debug("--Start saveOrUpdate--");
		try{
			//sessionFactory.getCurrentSession().saveOrUpdate("MaCustomer",object); //In this case works OK too (same as bellow)
			sessionFactory.getCurrentSession().saveOrUpdate(object);
		}catch(RuntimeException re){
			log.error("--save or Update method failed ");
			re.printStackTrace();
			throw re;
		}
		log.debug("--End saveOrUpdate");				
	}


	public List<MaCustomer> listCustomers() {
		log.debug("--Start listCustomers--");
		List<MaCustomer> customers= new ArrayList<MaCustomer>();
		String sql="SELECT * FROM ma_customer";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql); 
		//Object[] result=query.list().toArray();
		query.addEntity(MaCustomer.class);
		customers=query.list();
		log.debug("--End listCustomers--");
		return customers;
	}
	
	public Integer retrieveId(){
		log.debug("Retrieving the new Id");
		String sql="SELECT COUNT(*) FROM ma_customer";
		SQLQuery query= sessionFactory.getCurrentSession().createSQLQuery(sql);
		Object[] obj=query.list().toArray();
		BigInteger result=(BigInteger) obj[0]; //BigInteger cannot casted to Integer..
		log.debug("End of retrieveId, value:"+result.intValue());
		return result.intValue();		
	}
	
}
