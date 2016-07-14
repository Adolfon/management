package co.jp.eureka.controllers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.persistance.MaCustomerHome;
import co.jp.eureka.utils.HibernateUtil;

public class SaveCustomer extends ActionSupport {
	private static final Logger log = LogManager.getLogger(SaveCustomer.class);	
	
	public String getCompCode() {
		return compCode;
	}


	public void setCompCode(String compcode) {
		this.compCode = compcode;
	}
	
	public String getCompName() {
		return compName;
	}


	public void setCompName(String compName) {
		this.compName = compName;
	}


	public String getCompDspName() {
		return compDspName;
	}


	public void setCompDspName(String compDspName) {
		this.compDspName = compDspName;
	}


	public String getTel1() {
		return tel1;
	}


	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}


	public String getTel2() {
		return tel2;
	}


	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}


	public String getTel3() {
		return tel3;
	}


	public void setTel3(String tel3) {
		this.tel3 = tel3;
	}


	public String getFax1() {
		return fax1;
	}


	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}


	public String getFax2() {
		return fax2;
	}


	public void setFax2(String fax2) {
		this.fax2 = fax2;
	}


	public String getFax3() {
		return fax3;
	}


	public void setFax3(String fax3) {
		this.fax3 = fax3;
	}
	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	private String compCode; //8
	private String compName; //30
	private String compDspName; //30
	private String tel1;
	private String tel2; //15
	private String tel3;
	private String fax1;
	private String fax2;//15
	private String fax3;
	private String contactName;	
	private String email;


	public String execute() throws Exception{
		log.debug("--- Starts SaveCustomer----");
		
//		if (!validation())
//			return INPUT;
		
		 Session sf = HibernateUtil.getSessionFactory().getCurrentSession();
		
		MaCustomer customer=new MaCustomer();
		//After validating the fields in the form I am just setting up the values and persist the bean in DB
		//if (isInvalidName(this.getCompCode())) return INPUT;
		customer.setCustomerCode(getCompCode());
		customer.setCuatomerName(this.getCompName());
		customer.setCustomerDspName(this.getCompDspName());
		customer.setCustomerTel((this.tel1+this.tel2+this.tel3).replaceAll("\\s+",""));
		customer.setCustomerFax((this.fax1+this.fax2+this.fax3).replaceAll("\\s+",""));
		customer.setCustomerTantoName(this.getContactName());
		customer.setCustomerEmailAddrs(this.getEmail().replaceAll("\\s+",""));
		
		//I have to do something about the PK for saving or query or auto value..
		
		//customer.setCustomerId(2);
		MaCustomerHome daoMaCustomer= new MaCustomerHome();
		sf.beginTransaction();
			Integer idNum=daoMaCustomer.retrieveId();
		sf.flush();
			customer.setCustomerId(++idNum);
			daoMaCustomer.saveOrUpdate(customer);
		sf.getTransaction().commit();
		
		log.debug("checkin property compcode: "+getCompCode());
		log.debug("--- End of SaveCustomer----");
		return SUCCESS;
	}


	private boolean validation() {
		boolean validate=true;
		Map session =ActionContext.getContext().getSession();
		List<String> errors= (List<String>) session.get("errorMessages");
		//if (this.getCompDspName()==null)
			
		if(errors==null)
			session.put("errorMessages", errors=new ArrayList<String>());
		
		//fields validation..
		if((this.getCompCode()==null)||(this.getCompCode().equals(""))||this.getCompCode().length()>8){
			errors.add(getText("required.ccode.saveCustomer"));
			validate=false;
		}
		if((this.getCompName()==null)||(this.getCompName().equals(""))||this.getCompName().length()>30){
			errors.add(getText("required.cname.saveCustomer"));
			validate=false;
		}
		if((this.getCompDspName()==null)||(this.getCompDspName().equals("")||this.getCompDspName().length()>30)){
			errors.add(getText("required.dspname.saveCustomer"));
			validate=false;
		}
		String tel=(this.getTel1()+this.getTel2()+this.getTel3()).replaceAll("\\s+","");		
		if ((tel.equals(""))||(tel.length()>15)||(!StringUtils.isNumeric(tel))){
			errors.add(getText("required.tel.saveCustomer"));
			validate=false;
		}
		String fax=(this.getFax1()+this.getFax2()+this.getFax3()).replaceAll("\\s+","");
		if ((fax.equals(""))||(fax.length()>15)||(!StringUtils.isNumeric(fax))){
			errors.add(getText("required.fax.saveCustomer"));
			validate=false;
		}
		if((this.getContactName()==null)||(this.getContactName().equals(""))||this.getContactName().length()>30){
			errors.add(getText("required.cperson.saveCustomer"));
			validate=false;
		}
		
		if (this.getEmail()!=null){
			Integer whr =this.getEmail().indexOf("@");
			if((this.getEmail()==null)||(this.getEmail().equals(""))||
					(whr.intValue()==-1)||(this.getEmail().replaceAll("\\s+","").length()>48)){
							errors.add(getText("required.email.saveCustomer"));
							validate=false;
							}
							
		}else{
			validate=false;
			errors.add(getText("required.email.saveCustomer"));
		}
		
		return validate;
	}


		
}
