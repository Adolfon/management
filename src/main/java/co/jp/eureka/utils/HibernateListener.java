package co.jp.eureka.utils;
/*
 * This class provides the configuration for the Hibernate session.
 * This way of initializate the context needs a listener in web.xml.
 * Something like this:
  
   </web-app>
	   <listener>
	    <listener-class>
		  co.jp.eureka.utils.HibernateListener
	    </listener-class>
	  </listener>	 
	</web-app>
 * 
 */

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.opensymphony.xwork2.ActionSupport;
 
public class HibernateListener extends ActionSupport implements ServletContextListener{
 
    private Configuration config;
    private SessionFactory factory;
    private String path = "/hibernate.cfg.xml";
    private static Class clazz = HibernateListener.class;
 
    public static final String KEY_NAME = clazz.getName();
    private static ServiceRegistry serviceRegistry;
    
    
	public void contextDestroyed(ServletContextEvent event) {
	  //Actions to take care of before destroy the Hibernate context.
	}
 
	public void contextInitialized(ServletContextEvent event) {
 
	 try { 
		 System.out.println("OK1------------------");
	        URL url = HibernateListener.class.getResource(path);
	        config = new Configuration().configure(url);
	        System.out.println("OK2------------------");
	        //factory = config.buildSessionFactory(); deprecated
	        //new way to do it from Hibernate 4.3
	        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
	                config.getProperties()).build();
	        System.out.println("OK3------------------");
	        factory= config.buildSessionFactory(serviceRegistry);

	        System.out.println("OK4------------------");
	        //save the Hibernate session factory into serlvet context
	        event.getServletContext().setAttribute(KEY_NAME, factory);
	  } catch (Exception e) {
	         System.out.println(e.getMessage());
	   }
	}
	
	//return the hibernate session 
	public Session getSessionFromServletContext(){
		SessionFactory sf = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);		
		return sf.openSession();		
	}
	
	
}//Class
