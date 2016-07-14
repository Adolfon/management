package co.jp.eureka.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.persistance.MaCustomerHome;
import co.jp.eureka.utils.HibernateUtil;

public class CustomerList extends EurekaSupport{
	private static final Logger log = LogManager.getLogger(CustomerList.class);
	
	private List<MaCustomer> customerList= new ArrayList<MaCustomer>();
	
	
	
	public List<MaCustomer> getCustomerList() {
		return customerList;
	}



	public void setCustomerList(List<MaCustomer> customerList) {
		this.customerList = customerList;
	}



	public String execute()throws Exception{
		log.debug("-- CustomerList action Starts --");
		
		Session sf= HibernateUtil.getSessionFactory().getCurrentSession();
		MaCustomer customer;
		MaCustomerHome daoCustomer= new MaCustomerHome();
		sf.beginTransaction();					
			this.setCustomerList(daoCustomer.listCustomers());
		sf.getTransaction().commit();
		
		log.debug("-- CustomerList action Finished --");
		return SUCCESS;
	}
}
