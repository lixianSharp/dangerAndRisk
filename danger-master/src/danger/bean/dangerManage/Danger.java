package danger.bean.dangerManage;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import danger.bean.dangerHandle.Sidingbiao;

public class Danger {



	private Integer dangerid;

	private Date findtime;

	private String classtype;

	private String findperson;

	private String checkunit;

	private String address;

	private String content;

	private String dangergrade;

	private String type;

	private String unit;

	private String manager;

	private String dangerstatusnum;

	private String dangerstatus;

	private String dangerreport;

	private List<Sidingbiao> siDings;

	public List<Sidingbiao> getSiDings() {
		return siDings;
	}

	public void setSiDings(List<Sidingbiao> siDings) {
		this.siDings = siDings;
	}

	public Integer getDangerid() {
		return dangerid;
	}

	public void setDangerid(Integer dangerid) {
		this.dangerid = dangerid;
	}

	/*@JSON(format = "yy-MM-dd HH:mm:ss")*/
	public Date getFindtime() {
		return findtime;
	}

	public void setFindtime(Date findtime) {
		this.findtime = findtime;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype == null ? null : classtype.trim();
	}

	public String getFindperson() {
		return findperson;
	}

	public void setFindperson(String findperson) {
		this.findperson = findperson == null ? null : findperson.trim();
	}

	public String getCheckunit() {
		return checkunit;
	}

	public void setCheckunit(String checkunit) {
		this.checkunit = checkunit == null ? null : checkunit.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getDangergrade() {
		return dangergrade;
	}

	public void setDangergrade(String dangergrade) {
		this.dangergrade = dangergrade == null ? null : dangergrade.trim();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit == null ? null : unit.trim();
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager == null ? null : manager.trim();
	}

	public String getDangerstatusnum() {
		return dangerstatusnum;
	}

	public void setDangerstatusnum(String dangerstatusnum) {
		this.dangerstatusnum = dangerstatusnum == null ? null : dangerstatusnum.trim();
	}

	public String getDangerstatus() {
		return dangerstatus;
	}

	public void setDangerstatus(String dangerstatus) {
		this.dangerstatus = dangerstatus == null ? null : dangerstatus.trim();
	}

	public String getDangerreport() {
		return dangerreport;
	}

	public void setDangerreport(String dangerreport) {
		this.dangerreport = dangerreport == null ? null : dangerreport.trim();
	}

	@Override
	public String toString() {
		return "Danger [dangerid=" + dangerid + ", findtime=" + findtime + ", classtype=" + classtype + ", findperson="
				+ findperson + ", checkunit=" + checkunit + ", address=" + address + ", content=" + content
				+ ", dangergrade=" + dangergrade + ", type=" + type + ", unit=" + unit + ", manager=" + manager
				+ ", dangerstatusnum=" + dangerstatusnum + ", dangerstatus=" + dangerstatus + ", dangerreport="
				+ dangerreport + ", siDings=" + siDings + "]";
	}
	
	
}