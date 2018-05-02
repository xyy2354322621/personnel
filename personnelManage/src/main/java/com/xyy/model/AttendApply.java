package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/28 0028.
 */
public class AttendApply {
    private long attend_apply_no;
    private long attend_no;
    private String forget_clock_in;
    private String forget_clock_out;
    private int person_leave;
    private int sick_leave;
    private int annual_leave;
    private int maternity_leave;
    private int marriage_leave;
    private int funeral_leave;
    private String date;
    private String e_id;
    private String e_name;
    private String approve;

    public String getApprove() {
        return approve;
    }

    public void setApprove(String approve) {
        this.approve = approve;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public long getAttend_apply_no() {
        return attend_apply_no;
    }

    public void setAttend_apply_no(long attend_apply_no) {
        this.attend_apply_no = attend_apply_no;
    }

    public long getAttend_no() {
        return attend_no;
    }

    public void setAttend_no(long attend_no) {
        this.attend_no = attend_no;
    }

    public String getForget_clock_in() {
        return forget_clock_in;
    }

    public void setForget_clock_in(String forget_clock_in) {
        this.forget_clock_in = forget_clock_in;
    }

    public String getForget_clock_out() {
        return forget_clock_out;
    }

    public void setForget_clock_out(String forget_clock_out) {
        this.forget_clock_out = forget_clock_out;
    }

    public int getPerson_leave() {
        return person_leave;
    }

    public void setPerson_leave(int person_leave) {
        this.person_leave = person_leave;
    }

    public int getSick_leave() {
        return sick_leave;
    }

    public void setSick_leave(int sick_leave) {
        this.sick_leave = sick_leave;
    }

    public int getAnnual_leave() {
        return annual_leave;
    }

    public void setAnnual_leave(int annual_leave) {
        this.annual_leave = annual_leave;
    }

    public int getMaternity_leave() {
        return maternity_leave;
    }

    public void setMaternity_leave(int maternity_leave) {
        this.maternity_leave = maternity_leave;
    }

    public int getMarriage_leave() {
        return marriage_leave;
    }

    public void setMarriage_leave(int marriage_leave) {
        this.marriage_leave = marriage_leave;
    }

    public int getFuneral_leave() {
        return funeral_leave;
    }

    public void setFuneral_leave(int funeral_leave) {
        this.funeral_leave = funeral_leave;
    }

    @Override
    public String toString() {
        return "AttendApply{" +
                "attend_apply_no=" + attend_apply_no +
                ", attend_no=" + attend_no +
                ", forget_clock_in='" + forget_clock_in + '\'' +
                ", forget_clock_out='" + forget_clock_out + '\'' +
                ", person_leave=" + person_leave +
                ", sick_leave=" + sick_leave +
                ", annual_leave=" + annual_leave +
                ", maternity_leave=" + maternity_leave +
                ", marriage_leave=" + marriage_leave +
                ", funeral_leave=" + funeral_leave +
                ", date='" + date + '\'' +
                ", e_id='" + e_id + '\'' +
                ", e_name='" + e_name + '\'' +
                ", approve='" + approve + '\'' +
                '}';
    }
}
