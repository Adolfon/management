package co.jp.eureka.persistance;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import co.jp.eureka.viewDto.DtoProject;

public class DtoProjectHome {
	private static final Logger log = LogManager.getLogger(DtoProjectHome.class);	
	
	//Recover the whole dtoProject structure
	public DtoProject getDtoProjectById(Session sf,Integer prjId){
		String sql="SELECT * FROM tz_prj p WHERE p.pr_id="+prjId;
		SQLQuery query= sf.getSessionFactory().getCurrentSession().createSQLQuery(sql); 
		Object[] result=query.list().toArray();	
		Object[] obj=(Object[])result[0];
		
		if (result.length>1) log.error("The database recover more than one record, expected only one");		
		DtoProject dtoProjectBean;// = new DtoProject();
		dtoProjectBean= fillUpBeanPrj(obj);
		log.debug("Bean project main fields retrieved.."+dtoProjectBean.toString());
		//The customer bean
		MaCustomerHome daoMaCustomer=new MaCustomerHome();
		dtoProjectBean.setEntityMaCustomer(daoMaCustomer.findById(dtoProjectBean.getPrj_maCustomerId()));
		log.debug("---MaCustomer bean retrieved: "+dtoProjectBean.getEntityMaCustomer().toString());
		
		//The rest of the fields	
		TzPrjHomeHelper daoPrjHelper= new TzPrjHomeHelper();				
		
		daoPrjHelper.initProject(sf,dtoProjectBean.getPrId());
		dtoProjectBean.setDtoTzPrjNeedsSkill(daoPrjHelper.getDtoTzPrjNeedsSkillList());			
		dtoProjectBean.setDtoMaSkillitemList(daoPrjHelper.getDtoMaSkillitemListofList());
		dtoProjectBean.setDtoPrjNeedsEngineer(daoPrjHelper.getDtoTzPrjNeedsEngineerList());
		dtoProjectBean.setEntityMaEngineerkbn(daoPrjHelper.getMaEngineerkbn());
		dtoProjectBean.setEntityMaSkillcategory(daoPrjHelper.getBeanMaSkillcategoryListofList());
		
		
		sf.flush();
						
		log.debug("DtoProject with "+prjId+" retrieved, toString= "+dtoProjectBean.toString());;
		
		return dtoProjectBean;
	}
	
	private DtoProject fillUpBeanPrj(Object[] obj) {
		DtoProject dtoProject = new DtoProject();
		
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
		//new
		dtoProject.setPrjDeliveryDate((Date)obj[12]);
		dtoProject.setSecurityRequirements((String)obj[13]);
		dtoProject.setPrjEtcRequirementes((String)obj[14]);
		dtoProject.setPrjUpdateDtime((Date)obj[21]);
		
		dtoProject.setPrjEtc((String) obj[15]);
		return dtoProject;
	}
}//End of the class

	