// default package
// Generated Jun 15, 2016 5:39:06 PM by Hibernate Tools 5.1.0.Alpha1
package co.jp.eureka.entities;
import java.util.Date;

/**
 * MaProjectkbn generated by hbm2java
 */
public class MaProjectkbn implements java.io.Serializable {

	private Integer projectkbnId;
	private String projectkbnCode;
	private String projectkbnName;
	private Date creDtime;
	private Date updDtime;
	private TzPrj tzPrj;

	public MaProjectkbn() {
	}

	public MaProjectkbn(Integer projectkbnId, String projectkbnCode, String projectkbnName) {
		this.projectkbnId = projectkbnId;
		this.projectkbnCode = projectkbnCode;
		this.projectkbnName = projectkbnName;
	}

	public MaProjectkbn(Integer projectkbnId, String projectkbnCode, String projectkbnName, Date creDtime, Date updDtime,
			TzPrj tzPrj) {
		this.projectkbnId = projectkbnId;
		this.projectkbnCode = projectkbnCode;
		this.projectkbnName = projectkbnName;
		this.creDtime = creDtime;
		this.updDtime = updDtime;
		this.tzPrj = tzPrj;
	}

	public Integer getProjectkbnId() {
		return this.projectkbnId;
	}

	public void setProjectkbnId(Integer projectkbnId) {
		this.projectkbnId = projectkbnId;
	}

	public String getProjectkbnCode() {
		return this.projectkbnCode;
	}

	public void setProjectkbnCode(String projectkbnCode) {
		this.projectkbnCode = projectkbnCode;
	}

	public String getProjectkbnName() {
		return this.projectkbnName;
	}

	public void setProjectkbnName(String projectkbnName) {
		this.projectkbnName = projectkbnName;
	}

	public Date getCreDtime() {
		return this.creDtime;
	}

	public void setCreDtime(Date creDtime) {
		this.creDtime = creDtime;
	}

	public Date getUpdDtime() {
		return this.updDtime;
	}

	public void setUpdDtime(Date updDtime) {
		this.updDtime = updDtime;
	}

	public TzPrj getTzPrj() {
		return this.tzPrj;
	}

	public void setTzPrj(TzPrj tzPrj) {
		this.tzPrj = tzPrj;
	}

}
