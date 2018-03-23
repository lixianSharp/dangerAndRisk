package danger.bean.riIdentify;

import java.util.Date;
//风险识别主表
public class RiIdentificationMainTable {
    private String identiryid;

    private Date year;

    private String name;

    private String meetingaddress;

    private String compere;

    private String recorder;

    private String participants;

    private String meetingcontent;

    private String identifymark;

    private Date createtime;

    public String getIdentiryid() {
        return identiryid;
    }

    public void setIdentiryid(String identiryid) {
        this.identiryid = identiryid == null ? null : identiryid.trim();
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMeetingaddress() {
        return meetingaddress;
    }

    public void setMeetingaddress(String meetingaddress) {
        this.meetingaddress = meetingaddress == null ? null : meetingaddress.trim();
    }

    public String getCompere() {
        return compere;
    }

    public void setCompere(String compere) {
        this.compere = compere == null ? null : compere.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants == null ? null : participants.trim();
    }

    public String getMeetingcontent() {
        return meetingcontent;
    }

    public void setMeetingcontent(String meetingcontent) {
        this.meetingcontent = meetingcontent == null ? null : meetingcontent.trim();
    }

    public String getIdentifymark() {
        return identifymark;
    }

    public void setIdentifymark(String identifymark) {
        this.identifymark = identifymark == null ? null : identifymark.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}