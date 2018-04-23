package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public class Position {
    private long pos_no;
    private String pos_name;
    private String depart_name;
    private long depart_no;
    private long basic_salary;
    private int exist;

    public long getPos_no() {
        return pos_no;
    }

    public void setPos_no(long pos_no) {
        this.pos_no = pos_no;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public long getDepart_no() {
        return depart_no;
    }

    public void setDepart_no(long depart_no) {
        this.depart_no = depart_no;
    }

    public long getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(long basic_salary) {
        this.basic_salary = basic_salary;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }
}
