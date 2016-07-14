package co.jp.eureka.controllers;


import org.apache.log4j.Logger;

public class AddProject extends EurekaSupport{
	private static final Logger log =  Logger.getLogger(AddProject.class);
	private  Logger logfromOther= Logger.getLogger(ProjectList.class);	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ProjectId;
	
	
	
	public String getProjectId() {
		return ProjectId;
	}



	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}



	public String execute() throws Exception{
		log.debug("--- Start AddProject action method ---");
		logfromOther.debug("Testing from Addproject class using ProjectList logger ...====----");
		log.debug("Getting the project Id:"+getProjectId());
		return SUCCESS;
	}

}
