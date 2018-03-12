package danger.bean.riIdentify;

import java.util.Date;
//风险评估
public class RiAssessment {
    private String assessmentid;

    private String riskmsgid;

    private String possibility;

    private String persondegreeofexposure;

    private String lossofcconsequences;

    private Double riskvalue;

    private String riskgrade;

    private Date evaluatetime;

    public String getAssessmentid() {
        return assessmentid;
    }

    public void setAssessmentid(String assessmentid) {
        this.assessmentid = assessmentid == null ? null : assessmentid.trim();
    }

    public String getRiskmsgid() {
        return riskmsgid;
    }

    public void setRiskmsgid(String riskmsgid) {
        this.riskmsgid = riskmsgid == null ? null : riskmsgid.trim();
    }

    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility == null ? null : possibility.trim();
    }

    public String getPersondegreeofexposure() {
        return persondegreeofexposure;
    }

    public void setPersondegreeofexposure(String persondegreeofexposure) {
        this.persondegreeofexposure = persondegreeofexposure == null ? null : persondegreeofexposure.trim();
    }

    public String getLossofcconsequences() {
        return lossofcconsequences;
    }

    public void setLossofcconsequences(String lossofcconsequences) {
        this.lossofcconsequences = lossofcconsequences == null ? null : lossofcconsequences.trim();
    }

    public Double getRiskvalue() {
        return riskvalue;
    }

    public void setRiskvalue(Double riskvalue) {
        this.riskvalue = riskvalue;
    }

    public String getRiskgrade() {
        return riskgrade;
    }

    public void setRiskgrade(String riskgrade) {
        this.riskgrade = riskgrade == null ? null : riskgrade.trim();
    }

    public Date getEvaluatetime() {
        return evaluatetime;
    }

    public void setEvaluatetime(Date evaluatetime) {
        this.evaluatetime = evaluatetime;
    }
}