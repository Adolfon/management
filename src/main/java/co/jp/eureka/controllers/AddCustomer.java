package co.jp.eureka.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddCustomer extends EurekaSupport{

	private static final Logger log = LogManager.getLogger(AddCustomer.class);
	
	
	public String execute() throws Exception{
		log.debug("--Start AddCustomer--");
		
		
		log.debug("--End AddCustomer--");
		return SUCCESS;
	}
	
}
