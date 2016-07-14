package co.jp.eureka.viewDto;

import java.util.Date;

public class DtoPrjNeedsEngineer {
	
	//PK
		private Integer prj_id;
		private Integer prj_sub_id;
		private Integer tz_prj_needs_engineerkbn_id;
		//Members
		private Integer prj_needs_engineer_number;
		private Date prj_needs_priod_from;
		private Date prj_needs_priod_to;
		private Integer prj_needs_engineer_rough_price;
		private String prj_needs_engineer_working_place;
		private String prj_needs_engineer_etc;
		private  Integer prj_needs_eng_upd_kaisha_id;
		private Integer prj_needs_eng_upd_user_id;
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
		public Integer getPrj_needs_engineer_number() {
			return prj_needs_engineer_number;
		}
		public void setPrj_needs_engineer_number(Integer prj_needs_engineer_number) {
			this.prj_needs_engineer_number = prj_needs_engineer_number;
		}
		public Date getPrj_needs_priod_from() {
			return prj_needs_priod_from;
		}
		public void setPrj_needs_priod_from(Date prj_needs_priod_from) {
			this.prj_needs_priod_from = prj_needs_priod_from;
		}
		public Date getPrj_needs_priod_to() {
			return prj_needs_priod_to;
		}
		public void setPrj_needs_priod_to(Date prj_needs_priod_to) {
			this.prj_needs_priod_to = prj_needs_priod_to;
		}
		public Integer getPrj_needs_engineer_rough_price() {
			return prj_needs_engineer_rough_price;
		}
		public void setPrj_needs_engineer_rough_price(Integer prj_needs_engineer_rough_price) {
			this.prj_needs_engineer_rough_price = prj_needs_engineer_rough_price;
		}
		public String getPrj_needs_engineer_working_place() {
			return prj_needs_engineer_working_place;
		}
		public void setPrj_needs_engineer_working_place(String prj_needs_engineer_working_place) {
			this.prj_needs_engineer_working_place = prj_needs_engineer_working_place;
		}
		public String getPrj_needs_engineer_etc() {
			return prj_needs_engineer_etc;
		}
		public void setPrj_needs_engineer_etc(String prj_needs_engineer_etc) {
			this.prj_needs_engineer_etc = prj_needs_engineer_etc;
		}
		public Integer getPrj_needs_eng_upd_kaisha_id() {
			return prj_needs_eng_upd_kaisha_id;
		}
		public void setPrj_needs_eng_upd_kaisha_id(Integer prj_needs_eng_upd_kaisha_id) {
			this.prj_needs_eng_upd_kaisha_id = prj_needs_eng_upd_kaisha_id;
		}
		public Integer getPrj_needs_eng_upd_user_id() {
			return prj_needs_eng_upd_user_id;
		}
		public void setPrj_needs_eng_upd_user_id(Integer prj_needs_eng_upd_user_id) {
			this.prj_needs_eng_upd_user_id = prj_needs_eng_upd_user_id;
		}
		public Date getUpd_dtime() {
			return upd_dtime;
		}
		public void setUpd_dtime(Date upd_dtime) {
			this.upd_dtime = upd_dtime;
		}
		@Override
		public String toString() {
			return "DtoPrjNeedsEngineer [prj_id=" + prj_id + ", prj_sub_id=" + prj_sub_id
					+ ", tz_prj_needs_engineerkbn_id=" + tz_prj_needs_engineerkbn_id + ", prj_needs_engineer_number="
					+ prj_needs_engineer_number + ", prj_needs_priod_from=" + prj_needs_priod_from
					+ ", prj_needs_priod_to=" + prj_needs_priod_to + ", prj_needs_engineer_rough_price="
					+ prj_needs_engineer_rough_price + ", prj_needs_engineer_working_place="
					+ prj_needs_engineer_working_place + ", prj_needs_engineer_etc=" + prj_needs_engineer_etc
					+ ", prj_needs_eng_upd_kaisha_id=" + prj_needs_eng_upd_kaisha_id + ", prj_needs_eng_upd_user_id="
					+ prj_needs_eng_upd_user_id + ", upd_dtime=" + upd_dtime + "]";
		}
				
		
}
