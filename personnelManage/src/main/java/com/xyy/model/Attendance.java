package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
public class Attendance {
    private long attend_no;
    private String e_id;
    private String e_name;
    private String depart_name;
    private String pos_name;
    private long depart_no;
    private long pos_no;
    private String attend_time;
    private String leave_time;
    private String date;
    private int be_late;
    private int leave_early;
    private int overtime;
    private int person_leave;
    private int sick_leave;
    private int annual_leave;
    private int marriage_leave;
    private int maternity_leave;

    public long getAttend_no() {
        return attend_no;
    }

    public void setAttend_no(long attend_no) {
        this.attend_no = attend_no;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public long getDepart_no() {
        return depart_no;
    }

    public void setDepart_no(long depart_no) {
        this.depart_no = depart_no;
    }

    public long getPos_no() {
        return pos_no;
    }

    public void setPos_no(long pos_no) {
        this.pos_no = pos_no;
    }

    public String getAttend_time() {
        return attend_time;
    }

    public void setAttend_time(String attend_time) {
        this.attend_time = attend_time;
    }

    public String getLeave_time() {
        return leave_time;
    }

    public void setLeave_time(String leave_time) {
        this.leave_time = leave_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBe_late() {
        return be_late;
    }

    public void setBe_late(int be_late) {
        this.be_late = be_late;
    }

    public int getLeave_early() {
        return leave_early;
    }

    public void setLeave_early(int leave_early) {
        this.leave_early = leave_early;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
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

    public int getMarriage_leave() {
        return marriage_leave;
    }

    public void setMarriage_leave(int marriage_leave) {
        this.marriage_leave = marriage_leave;
    }

    public int getMaternity_leave() {
        return maternity_leave;
    }

    public void setMaternity_leave(int maternity_leave) {
        this.maternity_leave = maternity_leave;
    }
}
