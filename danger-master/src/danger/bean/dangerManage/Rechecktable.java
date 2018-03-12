package danger.bean.dangerManage;

import java.util.Date;

public class Rechecktable {
    private Integer recheckid;

    private Integer followid;

    private Integer dangerid;

    private String recheckman;

    private Date recheckdate;

    private String recheckresult;

    private String comment;

    public Integer getRecheckid() {
        return recheckid;
    }

    public void setRecheckid(Integer recheckid) {
        this.recheckid = recheckid;
    }

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }

    public Integer getDangerid() {
        return dangerid;
    }

    public void setDangerid(Integer dangerid) {
        this.dangerid = dangerid;
    }

    public String getRecheckman() {
        return recheckman;
    }

    public void setRecheckman(String recheckman) {
        this.recheckman = recheckman == null ? null : recheckman.trim();
    }

    public Date getRecheckdate() {
        return recheckdate;
    }

    public void setRecheckdate(Date recheckdate) {
        this.recheckdate = recheckdate;
    }

    public String getRecheckresult() {
        return recheckresult;
    }

    public void setRecheckresult(String recheckresult) {
        this.recheckresult = recheckresult == null ? null : recheckresult.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	@Override
	public String toString() {
		return "Rechecktable [recheckid=" + recheckid + ", followid=" + followid + ", dangerid=" + dangerid
				+ ", recheckman=" + recheckman + ", recheckdate=" + recheckdate + ", recheckresult=" + recheckresult
				+ ", comment=" + comment + "]";
	}
    
    
}