// default package
// Generated Jun 15, 2016 5:39:06 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.entities;
import java.util.HashSet;
import java.util.Set;

/**
 * MaSkillitem generated by hbm2java
 */
public class MaSkillitem_old implements java.io.Serializable {

	private MaSkillitemId id;
	private String skillName;
	private Integer skillDspOrder;
	private Set tzPrjNeedsSkills = new HashSet(0);

	public MaSkillitem_old() {
	}

	public MaSkillitem_old(MaSkillitemId id, String skillName, Integer skillDspOrder) {
		this.id = id;
		this.skillName = skillName;
		this.skillDspOrder = skillDspOrder;
	}

	public MaSkillitem_old(MaSkillitemId id, String skillName, Integer skillDspOrder, Set tzPrjNeedsSkills) {
		this.id = id;
		this.skillName = skillName;
		this.skillDspOrder = skillDspOrder;
		this.tzPrjNeedsSkills = tzPrjNeedsSkills;
	}

	public MaSkillitemId getId() {
		return this.id;
	}

	public void setId(MaSkillitemId id) {
		this.id = id;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public Integer getSkillDspOrder() {
		return this.skillDspOrder;
	}

	public void setSkillDspOrder(Integer skillDspOrder) {
		this.skillDspOrder = skillDspOrder;
	}

	public Set getTzPrjNeedsSkills() {
		return this.tzPrjNeedsSkills;
	}

	public void setTzPrjNeedsSkills(Set tzPrjNeedsSkills) {
		this.tzPrjNeedsSkills = tzPrjNeedsSkills;
	}

}