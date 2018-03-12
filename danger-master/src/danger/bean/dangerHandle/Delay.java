package danger.bean.dangerHandle;

import java.util.Date;

public class Delay {
    private Integer id;

    private Integer sidingid;

    private Integer delayseq;

    private String deleayreason;

    private Date delaytime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSidingid() {
        return sidingid;
    }

    public void setSidingid(Integer sidingid) {
        this.sidingid = sidingid;
    }

    public Integer getDelayseq() {
        return delayseq;
    }

    public void setDelayseq(Integer delayseq) {
        this.delayseq = delayseq;
    }

    public String getDeleayreason() {
        return deleayreason;
    }

    public void setDeleayreason(String deleayreason) {
        this.deleayreason = deleayreason == null ? null : deleayreason.trim();
    }

    public Date getDelaytime() {
        return delaytime;
    }

    public void setDelaytime(Date delaytime) {
        this.delaytime = delaytime;
    }
}