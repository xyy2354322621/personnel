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
    private long train_no;
    private Employee employee;
    private String train_name;
    private String train_address;
    private String start_time;
    private String end_time;
    private String message;
    private int scan;

    public int getScan() {
        return scan;
    }

    public void setScan(int scan) {
        this.scan = scan;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getTrain_address() {
        return train_address;
    }

    public void setTrain_address(String train_address) {
        this.train_address = train_address;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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

    public long getTrain_no() {
        return train_no;
    }

    public void setTrain_no(long train_no) {
        this.train_no = train_no;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
