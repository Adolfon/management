package co.jp.eureka.persistance;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.entities.MaEngineerkbn;
import co.jp.eureka.entities.MaSkillcategory;
import co.jp.eureka.entities.TzPrjNeedsSkill;
import co.jp.eureka.utils.HibernateUtil;
import co.jp.eureka.viewDto.DtoMaSkillitem;
import co.jp.eureka.viewDto.DtoPrjNeedsEngineer;
import co.jp.eureka.viewDto.DtoPrjNeedsSkill;



//This class propagate to the rest of the tables the project embedded beans (MaCustomer, MaProjectkbn, 
//tzPrjNeedsSkills --> MaSkillcategory, MaSkillitem, TzPrjNeedsEngineer, MaEngineerkbn
public class TzPrjHomeHelper {
	
	private static final Logger log = LogManager.getLogger(TzPrjHomeHelper.class);
	
	private Session session;
	
	private  List<DtoPrjNeedsSkill> dtoTzPrjNeedsSkillList= new ArrayList<DtoPrjNeedsSkill>();;
	//private List<DtoMaSkillitem> dtoMaSkillitemList= new ArrayList<DtoMaSkillitem>();
	private List<ArrayList<DtoMaSkillitem>> dtoMaSkillitemListofList = new ArrayList<ArrayList<DtoMaSkillitem>>();
	
	private List<DtoPrjNeedsEngineer> dtoTzPrjNeedsEngineerList;
	private List<MaEngineerkbn> maEngineerkbnList;
	
	private List<ArrayList<MaSkillcategory>> beanMaSkillcategoryListofList =new ArrayList<ArrayList<MaSkillcategory>>();
	

	

	private List<MaCustomer> beanMaCustomerList;
	
	



	public TzPrjHomeHelper(){
		
	}
	
	
	public void initProject(Session sf, Integer projectId){			
		log.debug("the session is open?: "+sf.isOpen());
		if (!sf.isOpen()){
			sf= HibernateUtil.getSessionFactory().getCurrentSession();
			sf.beginTransaction();
		}
		this.session=sf;
		
		//Beans Lists
				
	//Retrieving the skills for the project
		TzPrjNeedsSkillHome daoTzPrjNeedsSkill = new TzPrjNeedsSkillHome();
		
   	//session is open by this point
		retrieveAndPopulateTables(daoTzPrjNeedsSkill.listOfSkillsByProject(projectId));
	 				
	}
	
	
	public TzPrjHomeHelper(Session sf, Integer  projectId){
		log.debug("the session is open?: "+sf.isOpen());
		if (!sf.isOpen()){
			sf= HibernateUtil.getSessionFactory().getCurrentSession();
			sf.beginTransaction();
		}
		this.session=sf;
		
		//Beans Lists
				
	//Retrieving the skills for the project
		TzPrjNeedsSkillHome daoTzPrjNeedsSkill = new TzPrjNeedsSkillHome();
		
   	//session is open at this point
		retrieveAndPopulateTables(daoTzPrjNeedsSkill.listOfSkillsByProject(projectId));
	 				
	}// Constructor
	
	private void retrieveAndPopulateTables(List<TzPrjNeedsSkill> listOfSkillsByProject) {
		
		if (listOfSkillsByProject==null) return;
	//--- Local Beans
		// -- NeedsSkillBeans --
		List<DtoPrjNeedsSkill> listPrjNeedsSkillsDto=new ArrayList<DtoPrjNeedsSkill>(); //Perhaps reuse the class one		
		DtoPrjNeedsSkill dtoSkillNeedsBean;		
		// MaSkillitem Beans and dao
		MaSkillitemHome daoMaSkillitemHome= new MaSkillitemHome(); //Okay I put new extra methods for this ocassion.
		List<ArrayList<DtoMaSkillitem>> listOfListDtoMaSkillitem= new ArrayList<ArrayList<DtoMaSkillitem>>();			
		DtoMaSkillitem dtoBeanMaSkillitem;
		//tz_prj_needs_engineer_table
		DtoPrjNeedsEngineer dtoBeanPrjNeedsEngineer;
		List<DtoPrjNeedsEngineer> listDtoPrjNeedsEngineer= new ArrayList<DtoPrjNeedsEngineer>();
		TzPrjNeedsEngineerHome daoTzPrjNeedsEngineerHome = new TzPrjNeedsEngineerHome();
		//ma_engineerkbn table
		MaEngineerkbn entityMaEngineerkbn;
		List<MaEngineerkbn> listEntitiesMaEngineerkbn= new ArrayList<MaEngineerkbn>();
		MaEngineerkbnHome daoMaEngineerkbn= new MaEngineerkbnHome();
		//ma_skillCategory table
		List<MaSkillcategory> entityMaSkillcategory;
		List<MaSkillcategory> listEntitiesMaSkillcategory;
		List<ArrayList<MaSkillcategory>> listOfListEntitiesMaSkillcategory= new  ArrayList<ArrayList<MaSkillcategory>>();
		MaSkillcategoryHome daoMaSkillcategory= new MaSkillcategoryHome();				
		
		Iterator it = listOfSkillsByProject.iterator();		
		
		//Skills by Project
		while(it.hasNext()){
			
			dtoSkillNeedsBean= new DtoPrjNeedsSkill();
			Object[] obj=(Object[]) it.next();
			
			//PK						
			dtoSkillNeedsBean.setPrj_id((Integer)obj[0]);
			dtoSkillNeedsBean.setPrj_sub_id((Integer)obj[1]);
			dtoSkillNeedsBean.setTz_prj_needs_engineerkbn_id((Integer)obj[2]);
			
			//Rest of the Bean			
//			dtoSkillNeedsBean.setTz_prj_needs_skill_category_code((String)obj[3]);
//			dtoSkillNeedsBean.setPrj_needs_skill_code((String)obj[4]);						
//			dtoSkillNeedsBean.setPrj_needs_skill_level((Integer)obj[5]);
			dtoSkillNeedsBean.setPrj_needs_skill_upd_kaisha_id((Integer)obj[3]);						
			dtoSkillNeedsBean.setPrj_needs_skill_upd_user_id((Integer)obj[4]);
			dtoSkillNeedsBean.setUpd_dtime((Date)obj[5]);
			
			listPrjNeedsSkillsDto.add(dtoSkillNeedsBean);
			log.debug("-----listPrjNeedsSkillsDto Recovered: "+listPrjNeedsSkillsDto.toString());
		//flushing the caller query transaction 				
		session.flush();
		//MaSkillItem
			List<DtoMaSkillitem>listdtoBeanMaSkillitem= new ArrayList<DtoMaSkillitem>();
			
			listdtoBeanMaSkillitem = daoMaSkillitemHome.findListMaSkillItems_BySkillNeedsId(String.valueOf(dtoSkillNeedsBean.getPrj_id()+
					""+dtoSkillNeedsBean.getPrj_sub_id()+""+dtoSkillNeedsBean.getTz_prj_needs_engineerkbn_id()));
		session.flush();	
		listOfListDtoMaSkillitem.add((ArrayList<DtoMaSkillitem>) listdtoBeanMaSkillitem);
			//log.debug("----dtoBeanMaSkillitem Recovered: "+listdtoBeanMaSkillitem.toString());
		//Tz_prj_needs_engineer
			dtoBeanPrjNeedsEngineer= new DtoPrjNeedsEngineer();
			dtoBeanPrjNeedsEngineer = daoTzPrjNeedsEngineerHome.findPrjNeedsEngineer_ById(dtoSkillNeedsBean.getPrj_id(),
					dtoSkillNeedsBean.getPrj_sub_id(),dtoSkillNeedsBean.getTz_prj_needs_engineerkbn_id());
		session.flush();
			listDtoPrjNeedsEngineer.add(dtoBeanPrjNeedsEngineer);			
			log.debug("---- listDtoPrjNeedsEngineer Recovered: "+dtoBeanPrjNeedsEngineer.toString());
		//ma_engineerkbn	
			entityMaEngineerkbn= new MaEngineerkbn();
			entityMaEngineerkbn= daoMaEngineerkbn.findById(dtoBeanPrjNeedsEngineer.getTz_prj_needs_engineerkbn_id());
		session.flush();				
			listEntitiesMaEngineerkbn.add(entityMaEngineerkbn);
			log.debug("----entityMaEngineerkbn Recovered: "+entityMaEngineerkbn.toString());
		//ma_skillCategory
			listEntitiesMaSkillcategory= new ArrayList<MaSkillcategory>();
			listEntitiesMaSkillcategory=daoMaSkillcategory.findListMaSkillCategorys_BySkillitemList(listdtoBeanMaSkillitem);
		session.flush();
		listOfListEntitiesMaSkillcategory.add((ArrayList<MaSkillcategory>) listEntitiesMaSkillcategory);
			log.debug("-----entityMaSkillcategory recovered:"+listEntitiesMaSkillcategory.toString());		
			
		}//End while
		//Setting the final results in this object.
		this.setDtoTzPrjNeedsSkillList(listPrjNeedsSkillsDto);
		this.setDtoMaSkillitemListofList(listOfListDtoMaSkillitem);
		this.setDtoTzPrjNeedsEngineerList(listDtoPrjNeedsEngineer);
		this.setMaEngineerkbn(listEntitiesMaEngineerkbn);
		//new one
		this.setBeanMaSkillcategoryListofList(listOfListEntitiesMaSkillcategory);
		
	}
	
	public List<ArrayList<DtoMaSkillitem>> getDtoMaSkillitemListofList() {
		return dtoMaSkillitemListofList;
	}


	public void setDtoMaSkillitemListofList(List<ArrayList<DtoMaSkillitem>> dtoMaSkillitemListofList) {
		this.dtoMaSkillitemListofList = dtoMaSkillitemListofList;
	}


	public List<ArrayList<MaSkillcategory>> getBeanMaSkillcategoryListofList() {
		return beanMaSkillcategoryListofList;
	}


	public void setBeanMaSkillcategoryListofList(List<ArrayList<MaSkillcategory>> beanMaSkillcategoryListofList) {
		this.beanMaSkillcategoryListofList = beanMaSkillcategoryListofList;
	}
	
	

	
	public List<MaCustomer> getBeanMaCustomerList() {
		return beanMaCustomerList;
	}


	public void setBeanMaCustomerList(List<MaCustomer> beanMaCustomerList) {
		this.beanMaCustomerList = beanMaCustomerList;
	}
	
	
	public List<DtoPrjNeedsSkill> getDtoTzPrjNeedsSkillList() {
		return dtoTzPrjNeedsSkillList;
	}

	public void setDtoTzPrjNeedsSkillList(List<DtoPrjNeedsSkill> tzPrjNeedsSkillBean) {
		this.dtoTzPrjNeedsSkillList = tzPrjNeedsSkillBean;
	}

	

	

	public List<DtoPrjNeedsEngineer> getDtoTzPrjNeedsEngineerList() {
		return dtoTzPrjNeedsEngineerList;
	}


	public void setDtoTzPrjNeedsEngineerList(List<DtoPrjNeedsEngineer> dtoTzPrjNeedsEngineerList) {
		this.dtoTzPrjNeedsEngineerList = dtoTzPrjNeedsEngineerList;
	}


	public List<MaEngineerkbn> getMaEngineerkbn() {
		return maEngineerkbnList;
	}

	public void setMaEngineerkbn(List<MaEngineerkbn> maEngineerkbn) {
		this.maEngineerkbnList = maEngineerkbn;
	}

}
