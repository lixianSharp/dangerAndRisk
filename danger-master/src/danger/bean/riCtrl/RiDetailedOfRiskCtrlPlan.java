package danger.bean.riCtrl;
import java.util.Date;

public class RiDetailedOfRiskCtrlPlan {
    private String detailedofriskctrlplanid;

    private String rictrlplanid;

    private String riskmsgid;

    private String dutydepartment;

    private String implementationofmeasures;

    private String measureisvalid;

    private String inspectionsituation;

    private Date analysistime;

    public String getDetailedofriskctrlplanid() {
        return detailedofriskctrlplanid;
    }

    public void setDetailedofriskctrlplanid(String detailedofriskctrlplanid) {
        this.detailedofriskctrlplanid = detailedofriskctrlplanid == null ? null : detailedofriskctrlplanid.trim();
    }

    public String getRictrlplanid() {
        return rictrlplanid;
    }

    public void setRictrlplanid(String rictrlplanid) {
        this.rictrlplanid = rictrlplanid == null ? null : rictrlplanid.trim();
    }

    public String getRiskmsgid() {
        return riskmsgid;
    }

    public void setRiskmsgid(String riskmsgid) {
        this.riskmsgid = riskmsgid == null ? null : riskmsgid.trim();
    }

    public String getDutydepartment() {
        return dutydepartment;
    }

    public void setDutydepartment(String dutydepartment) {
        this.dutydepartment = dutydepartment == null ? null : dutydepartment.trim();
    }

    public String getImplementationofmeasures() {
        return implementationofmeasures;
    }

    public void setImplementationofmeasures(String implementationofmeasures) {
        this.implementationofmeasures = implementationofmeasures == null ? null : implementationofmeasures.trim();
    }

    public String getMeasureisvalid() {
        return measureisvalid;
    }

    public void setMeasureisvalid(String measureisvalid) {
        this.measureisvalid = measureisvalid == null ? null : measureisvalid.trim();
    }

    public String getInspectionsituation() {
        return inspectionsituation;
    }

    public void setInspectionsituation(String inspectionsituation) {
        this.inspectionsituation = inspectionsituation == null ? null : inspectionsituation.trim();
    }

    public Date getAnalysistime() {
        return analysistime;
    }

    public void setAnalysistime(Date analysistime) {
        this.analysistime = analysistime;
    }
}