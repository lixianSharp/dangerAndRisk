package danger.bean.queryView;

import java.util.Date;

public class DangerSiding {
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

    private Integer sidingid;

    private Date sidingtime;

    private String supervisor;

    private Date rectificationtime;
    
    private String dutyperson;

    private String rectificationmeasure;

    public Integer getDangerid() {
        return dangerid;
    }

    public void setDangerid(Integer dangerid) {
        this.dangerid = dangerid;
    }

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

    public Integer getSidingid() {
        return sidingid;
    }

    public void setSidingid(Integer sidingid) {
        this.sidingid = sidingid;
    }

    public Date getSidingtime() {
        return sidingtime;
    }

    public void setSidingtime(Date sidingtime) {
        this.sidingtime = sidingtime;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor == null ? null : supervisor.trim();
    }

    public Date getRectificationtime() {
        return rectificationtime;
    }

    public void setRectificationtime(Date rectificationtime) {
        this.rectificationtime = rectificationtime;
    }

    public String getRectificationmeasure() {
        return rectificationmeasure;
    }

    public void setRectificationmeasure(String rectificationmeasure) {
        this.rectificationmeasure = rectificationmeasure == null ? null : rectificationmeasure.trim();
    }

	public String getDutyperson() {
		return dutyperson;
	}

	public void setDutyperson(String dutyperson) {
		this.dutyperson = dutyperson;
	}

	@Override
	public String toString() {
		return "DangerSiding [dangerid=" + dangerid + ", findtime=" + findtime + ", classtype=" + classtype
				+ ", findperson=" + findperson + ", checkunit=" + checkunit + ", address=" + address + ", content="
				+ content + ", dangergrade=" + dangergrade + ", type=" + type + ", unit=" + unit + ", manager="
				+ manager + ", dangerstatusnum=" + dangerstatusnum + ", dangerstatus=" + dangerstatus
				+ ", dangerreport=" + dangerreport + ", sidingid=" + sidingid + ", sidingtime=" + sidingtime
				+ ", supervisor=" + supervisor + ", rectificationtime=" + rectificationtime + ", dutyperson="
				+ dutyperson + ", rectificationmeasure=" + rectificationmeasure + "]";
	}
	
}