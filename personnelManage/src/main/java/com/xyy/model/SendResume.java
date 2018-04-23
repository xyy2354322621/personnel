package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
public class SendResume {
    private long send_no;
    private long resume_no;
    private long recruit_no;
    private String isRead;
    private String invite;
    private String interview;
    private String hire;
    private int exist;

    public long getSend_no() {
        return send_no;
    }

    public void setSend_no(long send_no) {
        this.send_no = send_no;
    }

    public long getResume_no() {
        return resume_no;
    }

    public void setResume_no(long resume_no) {
        this.resume_no = resume_no;
    }

    public long getRecruit_no() {
        return recruit_no;
    }

    public void setRecruit_no(long recruit_no) {
        this.recruit_no = recruit_no;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getInvite() {
        return invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }
}
