package co.jp.eureka.viewDto;

public class DtoMaSkillitem {

	
	private String skill_code;	
	private String skill_name;
	private Integer skill_dsp_order;
	private String category_code;	
	private Integer skillLevel;
	private String engineerId;
	
	//For testing different type of data. In order to fullfill the condition for writing the right engineer.
	private Integer engId;
	
	public Integer getEngId() {
		return engId;
	}

	public void setEngId(Integer engId) {
		this.engId = engId;
	}

	public String getEngineerId() {
		return engineerId;
	}

	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
	}

	public Integer getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}
	
	
	public String getCategory_code() {
		return category_code;
	}
	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}
	public String getSkill_code() {
		return skill_code;
	}
	public void setSkill_code(String skill_code) {
		this.skill_code = skill_code;
	}
	public String getSkill_name() {
		return skill_name;
	}
	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}
	public Integer getSkill_dsp_order() {
		return skill_dsp_order;
	}
	public void setSkill_dsp_order(Integer skill_dsp_order) {
		this.skill_dsp_order = skill_dsp_order;
	}
	@Override
	public String toString() {
		return "DtoMaSkillitem [category_code=" + category_code + ", skill_code=" + skill_code + ", skill_name="
				+ skill_name + ", skill_dsp_order=" + skill_dsp_order + ", skillEngineerId="+engineerId+"engId"+engId+"]";
	}
	
}
