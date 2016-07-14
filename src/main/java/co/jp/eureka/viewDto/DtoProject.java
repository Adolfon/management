package co.jp.eureka.viewDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.jp.eureka.entities.MaCustomer;
import co.jp.eureka.entities.MaEngineerkbn;
import co.jp.eureka.entities.MaSkillcategory;
import co.jp.eureka.entities.MaSkillitem;
import co.jp.eureka.entities.TzPrjNeedsSkill;

public class DtoProject {
	
		
	private Integer prId;  	
	private Date cre_date;	
	private Integer prj_maCustomerId; 
	private Integer maProjectkbn; 
	private Integer prjKbnId; 
	private Integer prjImportanceId; 
	private Integer prjTargetId; 
	private Integer prjProfitabilityId; 
	private Integer prjNearshoreId; 
	private Integer prjStrategicId; 
	private String prjEnduserName;  
	private String prjName;
	private String prjSummary; 
	private String prjWorkingPlace; 
	private String prjEtc;  //Field 14
	//4 new ones 
	private Date prjDeliveryDate;	
	private String securityRequirements;
	private String prjEtcRequirementes;
	private Date prjUpdateDtime;
	
	private List<DtoPrjNeedsSkill> dtoTzPrjNeedsSkill;
	//private List<DtoMaSkillitem> dtoMaSkillitem;
	private List<ArrayList<DtoMaSkillitem>> dtoMaSkillitemList;
	
	//Only for access in the .jps (test)
//	private List<DtoMaSkillitem> dtoMaSkillitem;
//	
//	
//	
//	public List<DtoMaSkillitem> getDtoMaSkillitem() {
//		return dtoMaSkillitem;
//	}
//	public void setDtoMaSkillitem(List<DtoMaSkillitem> dtoMaSkillitem) {
//		this.dtoMaSkillitem = dtoMaSkillitem;
//	}
//==================================================

	
	
	
	public List<ArrayList<DtoMaSkillitem>> getDtoMaSkillitemList() {
		return dtoMaSkillitemList;
	}
	public void setDtoMaSkillitemList(List<ArrayList<DtoMaSkillitem>> dtoMaSkillitemList) {
		this.dtoMaSkillitemList = dtoMaSkillitemList;
	}
	public List<ArrayList<MaSkillcategory>> getEntityMaSkillcategory() {
		return entityMaSkillcategory;
	}
	public void setEntityMaSkillcategory(List<ArrayList<MaSkillcategory>> entityMaSkillcategory) {
		this.entityMaSkillcategory = entityMaSkillcategory;
	}
	private List<DtoPrjNeedsEngineer> dtoPrjNeedsEngineer;
	private List<MaEngineerkbn> entityMaEngineerkbn;
	//new one
	private List<ArrayList<MaSkillcategory>> entityMaSkillcategory;
	private MaCustomer entityMaCustomer;
	
	
	
	
	
public MaCustomer getEntityMaCustomer() {
		return entityMaCustomer;
	}
	public void setEntityMaCustomer(MaCustomer entityMaCustomer) {
		this.entityMaCustomer = entityMaCustomer;
	}
//public List<MaSkillcategory> getEntityMaSkillcategory() {
//		return entityMaSkillcategory;
//	}
//	public void setEntityMaSkillcategory(List<MaSkillcategory> entityMaSkillcategory) {
//		this.entityMaSkillcategory = entityMaSkillcategory;
//	}
public List<MaEngineerkbn> getEntityMaEngineerkbn() {
		return entityMaEngineerkbn;
	}
	public void setEntityMaEngineerkbn(List<MaEngineerkbn> entityMaEngineerkbn) {
		this.entityMaEngineerkbn = entityMaEngineerkbn;
	}
public List<DtoPrjNeedsEngineer> getDtoPrjNeedsEngineer() {
		return dtoPrjNeedsEngineer;
	}
	public void setDtoPrjNeedsEngineer(List<DtoPrjNeedsEngineer> dtoPrjNeedsEngineer) {
		this.dtoPrjNeedsEngineer = dtoPrjNeedsEngineer;
	}
//public List<DtoMaSkillitem> getDtoMaSkillitem() {
//		return dtoMaSkillitem;
//	}
//	public void setDtoMaSkillitem(List<DtoMaSkillitem> dtoMaSkillitem) {
//		this.dtoMaSkillitem = dtoMaSkillitem;
//	}
	public List<DtoPrjNeedsSkill> getDtoTzPrjNeedsSkill() {
		return this.dtoTzPrjNeedsSkill;
	}
	public void setDtoTzPrjNeedsSkill(List<DtoPrjNeedsSkill> tzPrjNeedsSkills) {
		this.dtoTzPrjNeedsSkill = tzPrjNeedsSkills;
	}
	
	public Date getPrjUpdateDtime() {
		return prjUpdateDtime;
	}
	public void setPrjUpdateDtime(Date prjUpdateDtime) {
		this.prjUpdateDtime = prjUpdateDtime;
	}
	
	public Date getPrjDeliveryDate() {
		return prjDeliveryDate;
	}
	public void setPrjDeliveryDate(Date prjDeliveryDate) {
		this.prjDeliveryDate = prjDeliveryDate;
	}
	public String getSecurityRequirements() {
		return securityRequirements;
	}
	public void setSecurityRequirements(String securityRequirements) {
		this.securityRequirements = securityRequirements;
	}
	public String getPrjEtcRequirementes() {
		return prjEtcRequirementes;
	}
	public void setPrjEtcRequirementes(String prjEtcRequirementes) {
		this.prjEtcRequirementes = prjEtcRequirementes;
	}		
	
	public Integer getPrId() {
		return prId;
	}
	public void setPrId(Integer prId) {
		this.prId = prId;
	}
	
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	
	public Integer getPrj_maCustomerId() {
		return prj_maCustomerId;
	}
	public void setPrj_maCustomerId(Integer prj_maCustomer) {
		this.prj_maCustomerId = prj_maCustomer;
	}
	public Integer getMaProjectkbn() {
		return maProjectkbn;
	}
	public void setMaProjectkbn(Integer maProjectkbn) {
		this.maProjectkbn = maProjectkbn;
	}
	public Integer getPrjKbnId() {
		return prjKbnId;
	}
	public void setPrjKbnId(Integer prjKbnId) {
		this.prjKbnId = prjKbnId;
	}
	public Integer getPrjImportanceId() {
		return prjImportanceId;
	}
	public void setPrjImportanceId(Integer prjImportanceId) {
		this.prjImportanceId = prjImportanceId;
	}
	public Integer getPrjTargetId() {
		return prjTargetId;
	}
	public void setPrjTargetId(Integer prjTargetId) {
		this.prjTargetId = prjTargetId;
	}
	public Integer getPrjProfitabilityId() {
		return prjProfitabilityId;
	}
	public void setPrjProfitabilityId(Integer prjProfitabilityId) {
		this.prjProfitabilityId = prjProfitabilityId;
	}
	public Integer getPrjNearshoreId() {
		return prjNearshoreId;
	}
	public void setPrjNearshoreId(Integer prjNearshoreId) {
		this.prjNearshoreId = prjNearshoreId;
	}
	public Integer getPrjStrategicId() {
		return prjStrategicId;
	}
	public void setPrjStrategicId(Integer prjStrategicId) {
		this.prjStrategicId = prjStrategicId;
	}
	public String getPrjEnduserName() {
		return prjEnduserName;
	}
	public void setPrjEnduserName(String prjEnduserName) {
		this.prjEnduserName = prjEnduserName;
	}
	public String getPrjName() {
		return prjName;
	}
	public void setPrjName(String prjName) {
		this.prjName = prjName;
	}
	public String getPrjSummary() {
		return prjSummary;
	}
	public void setPrjSummary(String prjSummary) {
		this.prjSummary = prjSummary;
	}
	public String getPrjWorkingPlace() {
		return prjWorkingPlace;
	}
	public void setPrjWorkingPlace(String prjWorkingPlace) {
		this.prjWorkingPlace = prjWorkingPlace;
	}
	public String getPrjEtc() {
		return prjEtc;
	}
	public void setPrjEtc(String prjEtc) {
		this.prjEtc = prjEtc;
	}
	
}
