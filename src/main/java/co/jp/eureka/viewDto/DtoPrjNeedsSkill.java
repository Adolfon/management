package co.jp.eureka.viewDto;

import java.util.Date;

public class DtoPrjNeedsSkill {
	//PK
	private Integer prj_id;
	private Integer prj_sub_id;
	private Integer tz_prj_needs_engineerkbn_id;
	//Members
	//private String tz_prj_needs_skill_category_code;
	//private String prj_needs_skill_code;
	//private Integer prj_needs_skill_level;
	private Integer prj_needs_skill_upd_kaisha_id;
	private Integer prj_needs_skill_upd_user_id;
	private Date upd_dtime;
	
	public Integer getPrj_id() {
		return prj_id;
	}
	public void setPrj_id(Integer prj_id) {
		this.prj_id = prj_id;
	}
	public Integer getPrj_sub_id() {
		return prj_sub_id;
	}
	public void setPrj_sub_id(Integer prj_sub_id) {
		this.prj_sub_id = prj_sub_id;
	}
	public Integer getTz_prj_needs_engineerkbn_id() {
		return tz_prj_needs_engineerkbn_id;
	}
	public void setTz_prj_needs_engineerkbn_id(Integer tz_prj_needs_engineerkbn_id) {
		this.tz_prj_needs_engineerkbn_id = tz_prj_needs_engineerkbn_id;
	}
//	public String getTz_prj_needs_skill_category_code() {
//		return tz_prj_needs_skill_category_code;
//	}
//	public void setTz_prj_needs_skill_category_code(String tz_prj_needs_skill_category_code) {
//		this.tz_prj_needs_skill_category_code = tz_prj_needs_skill_category_code;
//	}
//	public String getPrj_needs_skill_code() {
//		return prj_needs_skill_code;
//	}
//	public void setPrj_needs_skill_code(String prj_needs_skill_code) {
//		this.prj_needs_skill_code = prj_needs_skill_code;
//	}
//	public Integer getPrj_needs_skill_level() {
//		return prj_needs_skill_level;
//	}
//	public void setPrj_needs_skill_level(Integer prj_needs_skill_level) {
//		this.prj_needs_skill_level = prj_needs_skill_level;
//	}
	public Integer getPrj_needs_skill_upd_kaisha_id() {
		return prj_needs_skill_upd_kaisha_id;
	}
	public void setPrj_needs_skill_upd_kaisha_id(Integer prj_needs_skill_upd_kaisha_id) {
		this.prj_needs_skill_upd_kaisha_id = prj_needs_skill_upd_kaisha_id;
	}
	public Integer getPrj_needs_skill_upd_user_id() {
		return prj_needs_skill_upd_user_id;
	}
	public void setPrj_needs_skill_upd_user_id(Integer prj_needs_skill_upd_user_id) {
		this.prj_needs_skill_upd_user_id = prj_needs_skill_upd_user_id;
	}
	public Date getUpd_dtime() {
		return upd_dtime;
	}
	public void setUpd_dtime(Date upd_dtime) {
		this.upd_dtime = upd_dtime;
	}
	@Override
	public String toString() {
//		return "DtoPrjNeedsSkill [prj_id=" + prj_id + ", prj_sub_id=" + prj_sub_id + ", tz_prj_needs_engineerkbn_id="
//				+ tz_prj_needs_engineerkbn_id + ", tz_prj_needs_skill_category_code=" + tz_prj_needs_skill_category_code
//				+ ", prj_needs_skill_code=" + prj_needs_skill_code + ", prj_needs_skill_level=" + prj_needs_skill_level
//				+ ", prj_needs_skill_upd_kaisha_id=" + prj_needs_skill_upd_kaisha_id + ", prj_needs_skill_upd_user_id="
//				+ prj_needs_skill_upd_user_id + ", upd_dtime=" + upd_dtime + "]";
		return "DtoPrjNeedsSkill [prj_id=" + prj_id + ", prj_sub_id=" + prj_sub_id + ", tz_prj_needs_engineerkbn_id="
		+ tz_prj_needs_engineerkbn_id + 		
		 ", prj_needs_skill_upd_kaisha_id=" + prj_needs_skill_upd_kaisha_id + ", prj_needs_skill_upd_user_id="
		+ prj_needs_skill_upd_user_id + ", upd_dtime=" + upd_dtime + "]";
	}
	
}
