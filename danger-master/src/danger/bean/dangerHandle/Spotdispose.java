package danger.bean.dangerHandle;

import java.util.Date;

public class Spotdispose {
    private Integer disposeid;

    private Integer dangerid;

    private String hassafemeasure;

    private String disposemeasure;

    private Date disposedate;

    private String disposeperson;

    public Integer getDisposeid() {
        return disposeid;
    }

    public void setDisposeid(Integer disposeid) {
        this.disposeid = disposeid;
    }

    public Integer getDangerid() {
        return dangerid;
    }

    public void setDangerid(Integer dangerid) {
        this.dangerid = dangerid;
    }

    public String getHassafemeasure() {
        return hassafemeasure;
    }

    public void setHassafemeasure(String hassafemeasure) {
        this.hassafemeasure = hassafemeasure == null ? null : hassafemeasure.trim();
    }

    public String getDisposemeasure() {
        return disposemeasure;
    }

    public void setDisposemeasure(String disposemeasure) {
        this.disposemeasure = disposemeasure == null ? null : disposemeasure.trim();
    }

    public Date getDisposedate() {
        return disposedate;
    }

    public void setDisposedate(Date disposedate) {
        this.disposedate = disposedate;
    }

    public String getDisposeperson() {
        return disposeperson;
    }

    public void setDisposeperson(String disposeperson) {
        this.disposeperson = disposeperson == null ? null : disposeperson.trim();
    }

	@Override
	public String toString() {
		return "Spotdispose [disposeid=" + disposeid + ", dangerid=" + dangerid + ", hassafemeasure=" + hassafemeasure
				+ ", disposemeasure=" + disposemeasure + ", disposedate=" + disposedate + ", disposeperson="
				+ disposeperson + "]";
	}
}