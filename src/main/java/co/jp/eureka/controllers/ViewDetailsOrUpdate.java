package co.jp.eureka.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.SubsetIteratorFilter.Decider;
import org.hibernate.Session;

import co.jp.eureka.persistance.DtoProjectHome;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoProject;

public class ViewDetailsOrUpdate extends EurekaSupport{
	private static final Logger log = LogManager.getLogger(ViewDetailsOrUpdate.class);
	
private String ProjectId;
private DtoProject dtoProjectBean;
Session sf= HibernateUtil.getSessionFactory().getCurrentSession();

	
	


	@Override
	public String execute()throws Exception{
		log.debug("--Starting ViewDetailsOrUpdate controller -- parameter: "+getProjectId());
		DtoProjectHome daoDtoProjectHome= new DtoProjectHome();
		sf.beginTransaction();
			setDtoProjectBean(daoDtoProjectHome.getDtoProjectById(sf,Integer.valueOf(getProjectId())));
		sf.getTransaction().commit();
		log.debug("--End ViewDetailsOrUpdate controller --");
		return SUCCESS;
	}
	
	
		
	
	public DtoProject getDtoProjectBean() {
		return dtoProjectBean;
	}

	
	public void setDtoProjectBean(DtoProject dtoProjectBean) {
		this.dtoProjectBean = dtoProjectBean;
	}
	
	public String getProjectId() {
		return ProjectId;
	}



	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	

}
