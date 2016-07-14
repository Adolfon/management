package co.jp.eureka.utils;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
	//private static final Log log = LogFactory.getLog(HibernateUtil.class);
	private static final Logger log = LogManager.getLogger(HibernateUtil.class);
	
	private static SessionFactory sessionFactory = null;
	//for the second method
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory buildSessionFactory() {
		try{
			Configuration configuration= new Configuration();
			//configuration.addAnnotatedClass(User.class);
			return configuration.buildSessionFactory(new StandardServiceRegistryBuilder().build());
		} catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("There was an error building the factory");
		}		
	}
	
	private static SessionFactory buildSessionFactory2(){
		 log.debug("OK1------------------");
		 log.debug("-----------buildingSessionFactory--------");
		 try{
	        URL url = HibernateListener.class.getResource("/hibernate.cfg.xml");
	        Configuration config = new Configuration().configure(url);
	        log.debug("OK2------------------");
	        //factory = config.buildSessionFactory(); deprecated
	        //new way to do it from Hibernate 4.3
	        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                config.getProperties()).build();
	        log.debug("OK3------------------");
	        sessionFactory= config.buildSessionFactory(serviceRegistry);
	        log.debug("-----------Finishing buildingSessionFactory creation--------");
	        //sessionFactory.openSession(); //Added today bc problems with session closed 2016/06/20
		 	} catch (Exception e){
				e.printStackTrace();
				throw new RuntimeException("There was an error building the factory");
			}
		 return sessionFactory;
	}
	
	
	public static SessionFactory getSessionFactory(){
		if (sessionFactory==null||sessionFactory.isClosed())//adding isClosed bc problems..
			return buildSessionFactory2();
		else
			return sessionFactory;
	}
	
	
}
