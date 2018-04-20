package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */

public class Tourist {
    private String tourist_no;
    private String pass;

    public String getTourist_no() {
        return tourist_no;
    }

    public void setTourist_no(String tourist_no) {
        this.tourist_no = tourist_no;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Tourist{" +
                "tourist_no='" + tourist_no + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
