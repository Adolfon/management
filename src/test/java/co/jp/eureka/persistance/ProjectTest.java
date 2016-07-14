package co.jp.eureka.persistance;

import java.util.Date;
import java.util.HashSet;

import org.apache.jasper.tagplugins.jstl.core.Set;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.StrutsTestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.entities.MaEngineerkbn;
import co.jp.eureka.entities.MaProjectkbn;
import co.jp.eureka.entities.MaSkillcategory;
import co.jp.eureka.entities.MaSkillitem;
import co.jp.eureka.entities.MaSkillitemId;
import co.jp.eureka.entities.TzPrj;
import co.jp.eureka.entities.TzPrjNeedsEngineer;
import co.jp.eureka.entities.TzPrjNeedsEngineerId;
import co.jp.eureka.entities.TzPrjNeedsSkill;
import co.jp.eureka.entities.TzPrjNeedsSkillId;
import co.jp.eureka.utils.HibernateUtil;

public class ProjectTest extends StrutsTestCase{

	private static final Logger log = LogManager.getLogger(ProjectTest.class);
	//private static final Logger log = LogManager.getRootLogger();  I was using this before..
	
	private static Integer iter=1;
	
	//create 5 registers , just change the value of "iter" or the loop value in order to generate more or less registers
	
	public void testProject_createWithSkills(){
		log.debug("--Start  testProject_createWithSkills--");
	do{	
	//ban tz_prj	
		TzPrj beanTzPrj= new TzPrj();	
		beanTzPrj.setPrId(iter+1); // ---------------------------PK
		beanTzPrj.setPrjKbnId(iter+1);// ------------------------Fk (it was failing here..) same as bellow!
		fillUpBean(beanTzPrj);
		
	//bean ma_projectkbn
		MaProjectkbn mapkbn=new MaProjectkbn();
		mapkbn.setProjectkbnCode("code");
		mapkbn.setProjectkbnName("name");
		mapkbn.setProjectkbnId(iter+1);	// -----------------FK		
		beanTzPrj.setMaProjectkbn(mapkbn);
		
		
// --------------------- the bean part ----------------------------------------------------------------------
		
//First change all the int datatype for Integer, later this should be the order for saving data..	
  //bean ma_skillitem_id (O2) ok
	MaSkillitemId beanSkillitemId = new MaSkillitemId();
	beanSkillitemId.setCategoryCode("catCode"+iter); //------------------PK
	beanSkillitemId.setSkillCode(String.valueOf(iter));           //------------------PK
  //bean ma_skillitem (O2) ok
	MaSkillitem beanSkillitem = new MaSkillitem();
	//-------------beanSkillitem.setId(beanSkillitemId); // previous bean which actually is just the Id //------------------PK
	beanSkillitem.setSkillName(new String("Java Programming"));		
	beanSkillitem.setSkillDspOrder(1);
  //bean ma_skillcategory (O1) ok
	MaSkillcategory bean_skillCategory = new MaSkillcategory();
	bean_skillCategory.setCategoryCodecode("catCode"+iter);  //------------------PK
	bean_skillCategory.setCategoryName("catName2_"+iter);
	bean_skillCategory.setCategoryDspOrder(1);
//trying to fix the problem........
	HashSet tzPrjNeedsSkills = new HashSet<MaSkillcategory>();
	bean_skillCategory.setTzPrjNeedsSkills(tzPrjNeedsSkills);
//trying to fix the problem........
	
	
  //bean ma_engineerkbn (O3) ok
	MaEngineerkbn beanMaEngineerkbn = new MaEngineerkbn();
	beanMaEngineerkbn.setEngineerkbnId(iter); //new row, new bean -----PK---		
	
  //bean tz_prj_needs_engineer_Id (O4)
	TzPrjNeedsEngineerId beanTzPrjNeedsEngineerId = new TzPrjNeedsEngineerId();
	beanTzPrjNeedsEngineerId.setPrjId(beanTzPrj.getPrId()); //--------------- Project PK(1/3rd part) and FK of tz_prj
	beanTzPrjNeedsEngineerId.setPrjNeedsEngineerkbnId(iter); // ----------PK(1/3rd part) and FK of bean ma_engineerkbn
	beanTzPrjNeedsEngineerId.setPrjSubId(Integer.valueOf(iter+""+iter)); //----------PK (1/3rd part) 
	//-----------(3 registers above PK = 1111 )shared PK (tz_prj_needs_skill and tz_prj_needs_engineer)
  //bean tz_prj_needs_engineer (O4)
	TzPrjNeedsEngineer beanTzPrjNeedsEngineer = new TzPrjNeedsEngineer();
	beanTzPrjNeedsEngineer.setId(beanTzPrjNeedsEngineerId);//-------------setting the PK (generated with the bean before)
	beanTzPrjNeedsEngineer.setMaEngineerkbn(beanMaEngineerkbn);//-------------FK (generated in the bean before)
	
	beanTzPrjNeedsEngineer.setPrjNeedsEngineerNumber(1);
	beanTzPrjNeedsEngineer.setPrjNeedsPriodFrom(new Date());
	beanTzPrjNeedsEngineer.setPrjNeedsEngineerRoughPrice(5000);
	beanTzPrjNeedsEngineer.setPrjNeedsEngineerWorkingPlace("Hirooka");
	beanTzPrjNeedsEngineer.setPrjNeedsEngineerEtc("etc needs");
	beanTzPrjNeedsEngineer.setPrjNeedsEngineerUpdKaishaId(7);
	beanTzPrjNeedsEngineer.setPrjNeedsEngineerUpdUserId(11);
	beanTzPrjNeedsEngineer.setUpdDtime(new Date());		
  //bean tz_prj_needs_skillId
	  // Same as before for coherence (it shares the info with the other bean (tz_prj_needs_engineer)
	TzPrjNeedsSkillId beanTzPrjNeedsSkillId = new TzPrjNeedsSkillId();
	beanTzPrjNeedsSkillId.setPrjId(beanTzPrjNeedsEngineerId.getPrjId());
	beanTzPrjNeedsSkillId.setPrjSubId(beanTzPrjNeedsEngineerId.getPrjSubId());
	beanTzPrjNeedsSkillId.setTzPrjNeedsEngineerkbnId(beanTzPrjNeedsEngineerId.getPrjNeedsEngineerkbnId());
	
  //bean tz_prj_needs_skill
	TzPrjNeedsSkill beanTzPrjNeedsSkill= new TzPrjNeedsSkill();
	beanTzPrjNeedsSkill.setId(beanTzPrjNeedsSkillId); 		//---------- PK (share PK with tz_prj_needs_engineer)
	//--------------beanTzPrjNeedsSkill.setMaSkillcategory(bean_skillCategory);	//-------FK (previous bean)
	//--------------	beanTzPrjNeedsSkill.setMaSkillitem(beanSkillitem); 			//-------FK (previous bean)
	//--------------beanTzPrjNeedsSkill.setPrjNeedsSkillCode(beanSkillitem.getId().getSkillCode());//mio
	//--------------beanTzPrjNeedsSkill.setPrjNeedsSkillLevel(25);
	beanTzPrjNeedsSkill.setPrjNeedsSkillUpdKaishaId(7);
	beanTzPrjNeedsSkill.setPrjNeedsSkillUpdUserId(11);
	beanTzPrjNeedsSkill.setUpdDtime(new Date());
	//--------------beanTzPrjNeedsSkill.setTzPrjNeedsEngineer(beanTzPrjNeedsEngineer);//--------------FK TzPrjNeedsEngineer (Hibernate Functional Requirement)
	beanTzPrjNeedsSkill.setTzPrj(beanTzPrj); //it was missing..
	
	//bean Ma_customer
			MaCustomer maCustomerBeanppal = new MaCustomer();
			fillUpMaCustomerBean(maCustomerBeanppal);
// ----------------------------------- the DAO part --------------------------------------
						
		Session sf= HibernateUtil.getSessionFactory().getCurrentSession();
		MaProjectkbnHome  maProjectKbnDao = new MaProjectkbnHome(); //dependant dao
		TzPrjHome daoPrj=new TzPrjHome(); //project dao
				
		sf.beginTransaction();	
		//I have to commit first the dependant beans of projects
			maProjectKbnDao.persist(mapkbn);		
			
			//------------------------- New			
		log.debug("----Begin skill items option part----");
		//dao ma_engineerkbn
			MaEngineerkbnHome daoMaEngineerkbnHome = new MaEngineerkbnHome();
			daoMaEngineerkbnHome.persist(beanMaEngineerkbn);
		sf.flush();		
		//sf.clear();
		log.debug("-- beanMaEngineerkbn persisted--");
		//dao ma_skillitem   
			MaSkillitemHome daoMaSkillitemHome= new MaSkillitemHome();
			daoMaSkillitemHome.persist(beanSkillitem);
		sf.flush();
		log.debug("-- beanSkillitem persisted--");
		//dao ma_skillcategory
			MaSkillcategoryHome daoMaSkillcategoryHome= new MaSkillcategoryHome();
			daoMaSkillcategoryHome.persist(bean_skillCategory);
		sf.flush();
		log.debug("-- bean_skillCategory persisted--");
		//dao tz_prj_needs_engineer
			TzPrjNeedsEngineerHome daoTzPrjNeedsEngineerHome = new TzPrjNeedsEngineerHome();
			daoTzPrjNeedsEngineerHome.persist(beanTzPrjNeedsEngineer);
		sf.flush();		
		log.debug("-- beanTzPrjNeedsEngineer persisted--");
		//dao ma_customer
		MaCustomerHome daoMaCustomer = new MaCustomerHome();// customer dao
		daoMaCustomer.persist(maCustomerBeanppal);
		sf.flush();
		log.debug("-- beanmaCustomerBeanppal persisted --");
		//dao projecto
		daoPrj.persist(beanTzPrj);
		sf.flush();
		log.debug("-- bean beanTzPrj persisted --");
		//dao tz_prj_needs_skill
			TzPrjNeedsSkillHome daoTzPrjNeedsSkillHome= new TzPrjNeedsSkillHome();
			daoTzPrjNeedsSkillHome.persist(beanTzPrjNeedsSkill);
			//executequey(beanTzPrjNeedsSkill);
		sf.flush();	
		log.debug("-- beanTzPrjNeedsSkill persisted--");
			//daoPrj.persist(beanTzPrj);	//I change the place bc tz_prj_needs_skill reference project..						
		sf.getTransaction().commit();
		log.debug("-- beanTzPrj persisted--");	
		iter++;
		log.debug("--End of testProject_createWithSkills--");
	}while(iter<5);		
	}//procudure
	
	// Now I need to recover the created registers...
	
	public void list_registers(){
		log.debug("----------- Starting with the list_registers method --------------");
		
		log.debug("----------- Ending the list_registers method --------------");
	}
	
	
	
		
	private void fillUpBean(TzPrj bean) {
		
		MaCustomer maCustomerBean = new MaCustomer();
		fillUpMaCustomerBean(maCustomerBean);
		bean.setMaCustomer(maCustomerBean);			
		
		//bean.setPrjKbnId(1); //related to the ma_projectkbn table, check the MaProjectkbn.hbm.xml file (changed) change to default if fails..
		bean.setPrjImportanceId(2);
		bean.setPrjTargetId(0);
		bean.setPrjProfitabilityId(0);
		bean.setPrjNearshoreId(0);
		bean.setPrjStrategicId(0);
		bean.setPrjName("project aiko");
		bean.setPrjSummary("summary");
		bean.setPrjAddUserId(192);
		bean.setPrjUpdKaishaId(22);
		bean.setPrjUpdUserId(5);
		bean.setCreDtime(new Date());
		bean.setUpdDtime(new Date());			
		
	}

private void fillUpMaCustomerBean(MaCustomer maCustomer) {
		
		maCustomer.setCuatomerName("NombrePrj");
		maCustomer.setCustomerCode("1234"); //primary key required
		maCustomer.setCustomerDspName("DspName");	
		maCustomer.setCustomerEmailAddrs("email@domain.com");
		maCustomer.setCustomerFax("12345677");
		maCustomer.setCustomerId(iter);//Integer
		maCustomer.setCustomerTantoName("tanto");
		maCustomer.setCustomerTel("4445");
		//return maCustomer;
	}
	
	
}
