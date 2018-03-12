package danger.bean.riIdentify;
//辨识风险信息
public class RiIdentificationRriskMsg {
    private String riskmsgid;

    private String identiryid;

    private String riskaddress;

    private String riskdescribe;

    private String risktype;

    private String professionaltypes;

    private String disastertypes;

    private String cancauseaccidents;

    private String ctrlmeasure;

    private String principal;

    private String superintendent;

    private String monitoringperiod;

    private String evaluationstatus;

    public String getRiskmsgid() {
        return riskmsgid;
    }

    public void setRiskmsgid(String riskmsgid) {
        this.riskmsgid = riskmsgid == null ? null : riskmsgid.trim();
    }

    public String getIdentiryid() {
        return identiryid;
    }

    public void setIdentiryid(String identiryid) {
        this.identiryid = identiryid == null ? null : identiryid.trim();
    }

    public String getRiskaddress() {
        return riskaddress;
    }

    public void setRiskaddress(String riskaddress) {
        this.riskaddress = riskaddress == null ? null : riskaddress.trim();
    }

    public String getRiskdescribe() {
        return riskdescribe;
    }

    public void setRiskdescribe(String riskdescribe) {
        this.riskdescribe = riskdescribe == null ? null : riskdescribe.trim();
    }

    public String getRisktype() {
        return risktype;
    }

    public void setRisktype(String risktype) {
        this.risktype = risktype == null ? null : risktype.trim();
    }

    public String getProfessionaltypes() {
        return professionaltypes;
    }

    public void setProfessionaltypes(String professionaltypes) {
        this.professionaltypes = professionaltypes == null ? null : professionaltypes.trim();
    }

    public String getDisastertypes() {
        return disastertypes;
    }

    public void setDisastertypes(String disastertypes) {
        this.disastertypes = disastertypes == null ? null : disastertypes.trim();
    }

    public String getCancauseaccidents() {
        return cancauseaccidents;
    }

    public void setCancauseaccidents(String cancauseaccidents) {
        this.cancauseaccidents = cancauseaccidents == null ? null : cancauseaccidents.trim();
    }

    public String getCtrlmeasure() {
        return ctrlmeasure;
    }

    public void setCtrlmeasure(String ctrlmeasure) {
        this.ctrlmeasure = ctrlmeasure == null ? null : ctrlmeasure.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getSuperintendent() {
        return superintendent;
    }

    public void setSuperintendent(String superintendent) {
        this.superintendent = superintendent == null ? null : superintendent.trim();
    }

    public String getMonitoringperiod() {
        return monitoringperiod;
    }

    public void setMonitoringperiod(String monitoringperiod) {
        this.monitoringperiod = monitoringperiod == null ? null : monitoringperiod.trim();
    }

    public String getEvaluationstatus() {
        return evaluationstatus;
    }

    public void setEvaluationstatus(String evaluationstatus) {
        this.evaluationstatus = evaluationstatus == null ? null : evaluationstatus.trim();
    }
}