package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/29 0029.
 */
public class ChangePos {
    private long change_no;
    private String e_id;
    private long origin_pos;
    private long new_pos;
    private String change_date;

    public long getChange_no() {
        return change_no;
    }

    public void setChange_no(long change_no) {
        this.change_no = change_no;
    }

    public String getE_id() {
        return e_id;
    }

    public void setE_id(String e_id) {
        this.e_id = e_id;
    }

    public long getOrigin_pos() {
        return origin_pos;
    }

    public void setOrigin_pos(long origin_pos) {
        this.origin_pos = origin_pos;
    }

    public long getNew_pos() {
        return new_pos;
    }

    public void setNew_pos(long new_pos) {
        this.new_pos = new_pos;
    }

    public String getChange_date() {
        return change_date;
    }

    public void setChange_date(String change_date) {
        this.change_date = change_date;
    }
}
