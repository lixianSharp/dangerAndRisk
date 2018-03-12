package danger.bean.riIdentify;
//岗位职责分工
public class RiResponsibility {
    private String respid;

    private String quarters;

    private String duty;

    private String ctrlcontent;

    private String ctrlfrequency;

    private String analysisfrequency;

    public String getRespid() {
        return respid;
    }

    public void setRespid(String respid) {
        this.respid = respid == null ? null : respid.trim();
    }

    public String getQuarters() {
        return quarters;
    }

    public void setQuarters(String quarters) {
        this.quarters = quarters == null ? null : quarters.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public String getCtrlcontent() {
        return ctrlcontent;
    }

    public void setCtrlcontent(String ctrlcontent) {
        this.ctrlcontent = ctrlcontent == null ? null : ctrlcontent.trim();
    }

    public String getCtrlfrequency() {
        return ctrlfrequency;
    }

    public void setCtrlfrequency(String ctrlfrequency) {
        this.ctrlfrequency = ctrlfrequency == null ? null : ctrlfrequency.trim();
    }

    public String getAnalysisfrequency() {
        return analysisfrequency;
    }

    public void setAnalysisfrequency(String analysisfrequency) {
        this.analysisfrequency = analysisfrequency == null ? null : analysisfrequency.trim();
    }
}