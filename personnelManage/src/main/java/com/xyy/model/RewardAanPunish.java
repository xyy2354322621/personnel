package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/26 0026.
 */
public class RewardAanPunish {
    private long r_and_p_no;
    private String e_id;
    private String e_name;
    private String type;
    private String time;
    private String reason;
    private double money;
    private String exist;

    public long getR_and_p_no() {
        return r_and_p_no;
    }

    public void setR_and_p_no(long r_and_p_no) {
        this.r_and_p_no = r_and_p_no;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getExist() {
        return exist;
    }

    public void setExist(String exist) {
        this.exist = exist;
    }
}
