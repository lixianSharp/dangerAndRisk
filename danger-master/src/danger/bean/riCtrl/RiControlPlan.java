package danger.bean.riCtrl;

import java.util.Date;

public class RiControlPlan {
    private String rictrlplanid;

    private String year;

    private String monthorweek;

    private Date createtime;

    private String specialty;

    private String leader;

    private String riskctrlplanmark;

    private String reportstatus;

    private String checkstatus;

    public String getRictrlplanid() {
        return rictrlplanid;
    }

    public void setRictrlplanid(String rictrlplanid) {
        this.rictrlplanid = rictrlplanid == null ? null : rictrlplanid.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonthorweek() {
        return monthorweek;
    }

    public void setMonthorweek(String monthorweek) {
        this.monthorweek = monthorweek == null ? null : monthorweek.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader == null ? null : leader.trim();
    }

    public String getRiskctrlplanmark() {
        return riskctrlplanmark;
    }

    public void setRiskctrlplanmark(String riskctrlplanmark) {
        this.riskctrlplanmark = riskctrlplanmark == null ? null : riskctrlplanmark.trim();
    }

    public String getReportstatus() {
        return reportstatus;
    }

    public void setReportstatus(String reportstatus) {
        this.reportstatus = reportstatus == null ? null : reportstatus.trim();
    }

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus == null ? null : checkstatus.trim();
    }

	@Override
	public String toString() {
		return "RiControlPlan [rictrlplanid=" + rictrlplanid + ", year=" + year + ", monthorweek=" + monthorweek
				+ ", createtime=" + createtime + ", specialty=" + specialty + ", leader=" + leader
				+ ", riskctrlplanmark=" + riskctrlplanmark + ", reportstatus=" + reportstatus + ", checkstatus="
				+ checkstatus + "]";
	}
    
    
}