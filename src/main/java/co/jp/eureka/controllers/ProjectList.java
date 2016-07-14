package co.jp.eureka.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import co.jp.eureka.entities.TzPrj;
import co.jp.eureka.persistance.TzPrjHome;
import co.jp.eureka.persistance.TzPrjHomeHelper;
import co.jp.eureka.persistance.TzPrjNeedsSkillHome;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoProject;


public class ProjectList extends EurekaSupport {
	private static final Logger log = LogManager.getLogger(ProjectList.class);
	
	
	
	
	List<DtoProject> dtoProjecList;
	
	public List<DtoProject> getDtoProjecList() {
		return dtoProjecList;
	}


	public void setDtoProjecList(List<DtoProject> dtoProjec) {
		this.dtoProjecList = dtoProjec;
	}


	
		
	public String execute() throws Exception{
		log.debug("-- ProjectList action Starts --");
		
		Session sf= HibernateUtil.getSessionFactory().getCurrentSession();
		TzPrjHome dao_projects = new TzPrjHome();
		TzPrjNeedsSkillHome dao_needs_skillHome= new TzPrjNeedsSkillHome();  
		sf.beginTransaction();
			List<TzPrj> projects= dao_projects.listfProjects();
		//sf.flush();
			//I have to do this for every project and Include it into every "tz_prj" bean of the List.
			//List<TzPrjNeedsSkill> bean_prj_needs_skill= dao_needs_skillHome.listOfSkillsByProject(3); //OK
			//List listprojects =dao_projects.listfProjectsAndBeans();
		sf.getTransaction().commit();		
		//dtoProjecList = new ArrayList<DtoProject>();
		dtoProjecList = new ArrayList<DtoProject>();
		this.setDtoProjecList(getBeanFromRecordSourceAndPropagate(projects));//this is the value to recover
		
		
		log.debug("-- ProjectList action Finish --");
		//For now..changed from missing
		return SUCCESS;
	}


	private List<DtoProject> getBeanFromRecordSourceAndPropagate(List<TzPrj> projects) {
		Iterator it=(Iterator) projects.iterator();
		DtoProject dtoProject;
		List<DtoProject> projecListDB= new ArrayList<DtoProject>();		
		
		
		TzPrjHomeHelper  daoPrjHelper=new TzPrjHomeHelper();
		// I am going to put the right table's beans in each iteration..(we are going to start with tz_prj_needs_skill)
		//For every Project:
		while(it.hasNext()){
			//TzPrj project= (TzPrj) it.next(); // Casting problem
			dtoProject = new DtoProject();			
			
			Object[] obj=(Object[]) it.next();			
			
			dtoProject.setPrId((Integer) obj[0]);	
			dtoProject.setPrj_maCustomerId((Integer)obj[1]);
			dtoProject.setCre_date((Date)obj[20]);
			dtoProject.setPrjKbnId((Integer) obj[2]); //Bool			
			dtoProject.setPrjImportanceId((Integer) obj[3]); //Bool			
			dtoProject.setPrjTargetId((Integer) obj[4]); //Bool			
			dtoProject.setPrjProfitabilityId((Integer) obj[5]); //Bool			
			dtoProject.setPrjNearshoreId((Integer) obj[6]);	//Bool
			dtoProject.setPrjStrategicId((Integer) obj[7]);	//Bool
			dtoProject.setPrjEnduserName((String) obj[8]);			
			dtoProject.setPrjName((String) obj[9]);			
			dtoProject.setPrjSummary((String) obj[10]);			
			dtoProject.setPrjWorkingPlace((String) obj[11]);			
			dtoProject.setPrjEtc((String) obj[15]);
			
			
			//Now query and set the values for tz_prj_needs_skill table and ma_skill_item
			Session sf= HibernateUtil.getSessionFactory().getCurrentSession();
//			TzPrjNeedsSkillHome daoTzPrjNeedsSkill = new TzPrjNeedsSkillHome();
//			MaSkillitemHome  daoMaSkillitem = new MaSkillitemHome();
			
			
		sf.beginTransaction();
		
			//new stuff
		//TzPrjHomeHelper  daoPrjHelper =new TzPrjHomeHelper(sf,dtoProject.getPrId());
		daoPrjHelper.initProject(sf,dtoProject.getPrId());
		dtoProject.setDtoTzPrjNeedsSkill(daoPrjHelper.getDtoTzPrjNeedsSkillList());
			//end new
		
			//dtoProject.setTzPrjNeedsSkill(convertToTzPrjNeedsSkillBean(daoTzPrjNeedsSkill.listOfSkillsByProject(dtoProject.getPrId())));
		//sf.flush();	
		
		//Adding MaSkillItem BeanList
		dtoProject.setDtoMaSkillitemList(daoPrjHelper.getDtoMaSkillitemListofList());
		dtoProject.setDtoPrjNeedsEngineer(daoPrjHelper.getDtoTzPrjNeedsEngineerList());
		dtoProject.setEntityMaEngineerkbn(daoPrjHelper.getMaEngineerkbn());
		
		sf.getTransaction().commit();
		
		
			projecListDB.add(dtoProject);
			
			log.debug("Project id: "+obj[0]);//id 
			log.debug("Prj_maCustomerId:"+obj[1]);
			log.debug("prj_importance_id: "+obj[3]); //
			log.debug("prj_target_id: "+obj[4]);
			log.debug("prj_profitability: "+obj[5]);
			log.debug("prj_nearshore_id: "+obj[6]);
			log.debug("prj_strategic_id: "+obj[7]);
			log.debug("prj_enduser_name: "+obj[8]);
			log.debug("prj_name: "+obj[9]);
			log.debug("prj_summary"+obj[10]);
			log.debug("prj_working_place: "+obj[11]);
			log.debug("prj_etc: "+obj[15]);

		}//while
		return projecListDB;
	}
	
}//Class
