package co.jp.eureka.utils;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.opensymphony.xwork2.ActionSupport;

public class HibernateSession extends ActionSupport{

	public Session getSessionFromServletContext(){
		SessionFactory sf = (SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);		
		return sf.openSession();		
	}
	
	
}
