package danger.bean.dangerHandle;

import java.util.Date;
import java.util.List;

public class Sidingbiao {
    private Integer sidingid;

    private Integer dangerid;

    private Date sidingtime;

    private String supervisor;

    private Date rectificationtime;

    private String rectificationmeasure;

    private String dutyperson;
    
    //五定延迟信息
    private List<Delay> delays;
    
    
    public List<Delay> getDelays() {
		return delays;
	}

	public void setDelays(List<Delay> delays) {
		this.delays = delays;
	}

    public Integer getSidingid() {
        return sidingid;
    }

    public void setSidingid(Integer sidingid) {
        this.sidingid = sidingid;
    }

    public Integer getDangerid() {
        return dangerid;
    }

    public void setDangerid(Integer dangerid) {
        this.dangerid = dangerid;
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
        this.dutyperson = dutyperson == null ? null : dutyperson.trim();
    }

	@Override
	public String toString() {
		return "Sidingbiao [sidingid=" + sidingid + ", dangerid=" + dangerid + ", sidingtime=" + sidingtime
				+ ", supervisor=" + supervisor + ", rectificationtime=" + rectificationtime + ", rectificationmeasure="
				+ rectificationmeasure + ", dutyperson=" + dutyperson + ", delays=" + delays + "]";
	}
    
    
}