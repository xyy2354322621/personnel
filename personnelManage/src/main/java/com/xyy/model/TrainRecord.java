package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
public class TrainRecord {
    private long train_record_no;
    private String e_id;
    private String e_name;
    private String examine;
    private String attend;
    private String train_no;
    private Employee employee;

    public long getTrain_record_no() {
        return train_record_no;
    }

    public void setTrain_record_no(long train_record_no) {
        this.train_record_no = train_record_no;
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

    public String getExamine() {
        return examine;
    }

    public void setExamine(String examine) {
        this.examine = examine;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }

    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
