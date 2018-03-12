package danger.bean.riIdentify;

import java.util.Date;
//风险识别范围
public class RiIdentificationRange {
    private String idenranid;

    private String facename;

    private String survey;

    private String rirtype;

    private Date starttime;

    private Date endtime;

    public String getIdenranid() {
        return idenranid;
    }

    public void setIdenranid(String idenranid) {
        this.idenranid = idenranid == null ? null : idenranid.trim();
    }

    public String getFacename() {
        return facename;
    }

    public void setFacename(String facename) {
        this.facename = facename == null ? null : facename.trim();
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey == null ? null : survey.trim();
    }

    public String getRirtype() {
        return rirtype;
    }

    public void setRirtype(String rirtype) {
        this.rirtype = rirtype == null ? null : rirtype.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}