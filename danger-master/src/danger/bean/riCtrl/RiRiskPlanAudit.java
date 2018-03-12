package danger.bean.riCtrl;

import java.util.Date;

public class RiRiskPlanAudit {
    private String riskplanauditid;

    private String rictrlplanid;

    private String auditmsg;

    private String auditstatus;

    private Date audittime;

    private String auditperson;

    public String getRiskplanauditid() {
        return riskplanauditid;
    }

    public void setRiskplanauditid(String riskplanauditid) {
        this.riskplanauditid = riskplanauditid == null ? null : riskplanauditid.trim();
    }

    public String getRictrlplanid() {
        return rictrlplanid;
    }

    public void setRictrlplanid(String rictrlplanid) {
        this.rictrlplanid = rictrlplanid == null ? null : rictrlplanid.trim();
    }

    public String getAuditmsg() {
        return auditmsg;
    }

    public void setAuditmsg(String auditmsg) {
        this.auditmsg = auditmsg == null ? null : auditmsg.trim();
    }

    public String getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(String auditstatus) {
        this.auditstatus = auditstatus == null ? null : auditstatus.trim();
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getAuditperson() {
        return auditperson;
    }

    public void setAuditperson(String auditperson) {
        this.auditperson = auditperson == null ? null : auditperson.trim();
    }
}